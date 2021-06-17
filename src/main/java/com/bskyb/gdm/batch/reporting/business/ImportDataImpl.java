package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.model.LogResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class ImportDataImpl implements ImportData{
    @Value("${reporting.collibra.username}")
    private String username;
    @Value("${reporting.collibra.password}")
    private String password;
    @Value("${reporting.collibra.api.url}")
    private String baseUrl;
    @Value("${reporting.demographic}")
    private String zone;
    RestTemplate restTemplate;
    ImportDataImpl(){
        restTemplate=new RestTemplate();
    }
    /**
     * The method generates the API url required to pull out he logs
     * @param apiName : various options like Activity | Users | userGroups
     *                refer : https://sky-dev.collibra.com/docs/restv2/index.html#
     * @return : The URL to make the rest call
     */
    @Override
    public String generateRestAPiUrl(String apiName) {
        String url=String.format("%s%s%s%s%d%s%d",
                baseUrl,apiName,
                "?",
                "startDate=",
                this.getStartDate(),
                "&endDate=",
                this.getEndDate());
        return url;
    }
    /**
     * This method will set the header and authentication information required for
     * the rest API call
     * @return : httphear with following set
     * accepted media type
     * Content Type
     * Authorization
     * Authorization values
     */
    @Override
    public HttpHeaders createHeaders() {
        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        String auth = this.username + ":" + this.password;
        String base64Creds = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeader = "Basic " + new String( base64Creds );
        return new HttpHeaders() {{
            setContentType(MediaType.APPLICATION_JSON);
            set( "Authorization", authHeader );
            setAccept(acceptableMediaTypes);
        }};
    }

    /**
     * Will make a call to API and parse the response
     *
     * @param apiName : various options like Activity | Users | userGroups
     *                refer : https://sky-dev.collibra.com/docs/restv2/index.html#
     * @return : LogResponse Object loaded with the parsed data.
     */
    @Override
    public LogResponse parseResponse(String apiName) {
        HttpEntity<String> entity = new HttpEntity<>("body",this.createHeaders());
        try{
            ResponseEntity<LogResponse> result=restTemplate.
                    exchange(this.generateRestAPiUrl(apiName),
                            HttpMethod.GET, entity , LogResponse.class);
            return result.getBody();
        }catch(HttpClientErrorException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public long getEndDate(){
        DateTimeZone.setDefault(DateTimeZone.UTC);
        DateTime today = new DateTime().withTimeAtStartOfDay();
        return (today.getMillis());
    }

    public long getStartDate(){
        DateTimeZone.setDefault(DateTimeZone.UTC);
        DateTime today = new DateTime().withTimeAtStartOfDay();
        DateTime previousDay = today.minusDays(1).withTimeAtStartOfDay();
        return (previousDay.getMillis());
    }
}
