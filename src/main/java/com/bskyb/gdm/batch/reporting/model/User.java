package com.bskyb.gdm.batch.reporting.model;

public class User {
    //The profile id of the referenced resource.
    String id;
    //The type of the resource, i.e. User | Manual
    String resourceType;
    // The name as in the AD
    String userName;
    /*getter and setter methods */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
