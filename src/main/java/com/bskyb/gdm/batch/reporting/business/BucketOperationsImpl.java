package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.configuration.GCPConfiguration;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BucketOperationsImpl implements BucketOperations
{
    Storage storage;
    @Autowired
    GCPConfiguration gcpConfiguration;
    public BucketOperationsImpl() {
       // storage=gcpConfiguration.connectToGCP();
    }

    /**
     * Get the bucket if bucket exists, else will call the
     * function to create a bucket on GCP
     *
     * @param bucketName - name of the bucket
     * @return
     */
    @Override
    public Bucket getBucket(String bucketName) {
        Bucket bucket = storage.get(bucketName);
        if (bucket == null) {
            bucket = this.createBucket(bucketName);
        }
        return bucket;
    }

    /**
     * To create a Bucket on GCP with given name
     *
     * @param bucketName
     * @return
     */
    @Override
    public Bucket createBucket(String bucketName) {
        return storage.create(BucketInfo.of(bucketName));
    }

    /**
     * To upload the generated json file into Cloud storage
     *
     * @param bucketName
     * @param filename
     * @return
     */
    @Override
    public String uploadFile(String bucketName, String filename) {
        try {
            return null;
        }catch(IllegalStateException e){
           return null;

        }
    }


}
