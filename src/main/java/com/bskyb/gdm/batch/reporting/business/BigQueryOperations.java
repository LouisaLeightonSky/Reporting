package com.bskyb.gdm.batch.reporting.business;

public interface BigQueryOperations {
    /**
     * to load JSON data from Cloud Storage into a existing BigQuery table
     */
    void loadJsonFromGCS();
    /**
     * Upload an object- json file to a Cloud Storage bucket
     * @param objectName
     */
    void uploadFileToBucket(String objectName);
}
