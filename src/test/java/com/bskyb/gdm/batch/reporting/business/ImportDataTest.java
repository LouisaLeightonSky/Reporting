package com.bskyb.gdm.batch.reporting.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ImportDataTest {
    //1. Media type set to JSON
    @Test
    void CreateHeaderCheckContentType() {
        ImportData d1 = new ImportDataImpl();
        HttpHeaders h1 = d1.createHeaders();
       //System.out.print(h1);
        Assertions.assertEquals(MediaType.APPLICATION_JSON,h1.getContentType());
    }

    //2. What the acceptable media types are
    @Test
    void CreateHeaderCheckAcceptableMediaTypes() {
        ImportData d1 = new ImportDataImpl();
        HttpHeaders h1 = d1.createHeaders();
        //System.out.print(h1);
        Assertions.assertEquals(MediaType.APPLICATION_JSON,h1.getAccept());
    }

    //3. Type of Activity is either ADD, UPDATE or DELETE

    @Test
    void AcceptableActivityTypes() {
        ImportData d1 = new ImportDataImpl();
        //Assertions.assertEquals();
    }

    //4. URL is created accurately

    @Test
    void CreateURL() {
        ImportData d1 = new ImportDataImpl();
        String URL = d1.generateRestAPiUrl("CollibraActivities");
        System.out.println(URL);
        Assertions.assertEquals("https://sky-dev.collibra.com/rest/2.0/activities?offset=0&limit=0&startDate=1623336347&callCountEnabled=false", URL);
    }

    //8.

    @Test
    void StartDateIsValid() {
        Long StartDate = 1623801600000;
        System.out.println(StartDate);
       // Assertions.assertEquals;


    }
}


//. Type of Activity is reflects the action performed

//. Timestamp is in UTC time standard format

//. Timestamp reflects the time the action was performed