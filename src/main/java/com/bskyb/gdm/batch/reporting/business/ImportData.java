package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.model.LogResponse;
import org.springframework.http.HttpHeaders;

public interface ImportData {
    /**
     * The method generates the API url required to pull out he logs
     * @param apiName : various options like Activity | Users | userGroups
     *                refer : https://sky-dev.collibra.com/docs/restv2/index.html#
     * @return : The URL to make the rest call
     */
    String generateRestAPiUrl(String apiName);
    /**
     * This method will set the header and authication information required for
     * the rest API call
     * @return : httphear with following set
     * accepted media type
     * Content Type
     * Authorization
     * Authorization values
     */
    HttpHeaders createHeaders();
    /**
     * Will make a call to API and parse the response
     * @param apiName : various options like Activity | Users | userGroups
     *     refer : https://sky-dev.collibra.com/docs/restv2/index.html#
     * @return : LogResponse Object loaded with the parsed data.
     */
    LogResponse parseResponse(String apiName);

    /**
     * Returns the UTC date for long files
     * @return
     */
    long getStartDate();

}
