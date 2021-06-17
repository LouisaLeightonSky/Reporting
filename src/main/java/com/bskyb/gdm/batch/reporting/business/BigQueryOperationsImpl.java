package com.bskyb.gdm.batch.reporting.business;

import org.springframework.stereotype.Component;

@Component
public class BigQueryOperationsImpl implements BigQueryOperations{
    public BigQueryOperationsImpl() {
    }

    /**
     * to load JSON data from Cloud Storage into a existing BigQuery table
     */
    @Override
    public void loadJsonFromGCS() {

    }

    /**
     * Upload an object- json file to a Cloud Storage bucket
     *
     * @param objectName
     */
    @Override
    public void uploadFileToBucket(String objectName) {

    }
}
