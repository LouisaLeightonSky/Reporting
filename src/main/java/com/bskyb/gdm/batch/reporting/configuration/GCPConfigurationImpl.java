package com.bskyb.gdm.batch.reporting.configuration;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@Component
public class GCPConfigurationImpl implements GCPConfiguration{
    private String pathToConfig;
    private String projectId;
    /**
     * To set up authentication for perform
     * GCP operations
     *
     * @return
     */
    @Override
    public Storage connectToGCP() {
        try{
            Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(pathToConfig));
            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build().getService();
            return storage;
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
