package com.bskyb.gdm.batch.reporting.business;

import com.google.cloud.storage.Bucket;

public interface BucketOperations {
    /**
     * Get the bucket if bucket exists, else will call the
     * function to create a bucket on GCP
     * @param bucketName - name of the bucket
     * @return
     */
    Bucket getBucket(String bucketName);

    /**
     * To create a Bucket on GCP with given name
     * @param bucketName
     * @return
     */
    Bucket createBucket(String bucketName);

    /**
     * To upload the generated json file into Cloud storage
     * @param bucketName
     * @param filename
     * @return
     */
    String uploadFile(String bucketName,String filename );
}
