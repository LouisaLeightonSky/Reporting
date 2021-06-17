package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.model.Result;

import java.util.List;

public interface ExportData {
    /**
     * The response received from the collibra is written into a file for
     * upload into GCP
     * @param result
     */
    void writeFileForUpload(List<Result> results);

    /**
     * The formatted data is to moved to a GCP bucket
     * to be uploaded into the Big Query
     * @param fileName
     */
    void uploadFileToBucket(String fileName);

    /**
     * The method will establish the connection to
     * load data in to GCP
     */
    void writeToBigQuery();
}
