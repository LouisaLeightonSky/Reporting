package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class ExportDataImpl implements ExportData{
    public ExportDataImpl() {
    }

    /**
     * The response received from the collibra is written into a file for
     * upload into GCP
     *
     * @param result
     */
    @Override
    public void writeFileForUpload(List<Result> results) {
        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(Paths.get("one.json").toFile(), results);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The formatted data is to moved to a GCP bucket
     * to be uploaded into the Big Query
     *
     * @param fileName
     */
    @Override
    public void uploadFileToBucket(String fileName) {

    }

    /**
     * The method will establish the connection to
     * load data in to GCP
     */
    @Override
    public void writeToBigQuery() {

    }
}
