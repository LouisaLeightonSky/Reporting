package com.bskyb.gdm.batch.reporting.configuration;
import com.google.cloud.storage.*;

public interface GCPConfiguration {
    /**
     * To set up authentication for perform
     * GCP operations
     * @return - Google Storage
     */
    Storage connectToGCP();
}
