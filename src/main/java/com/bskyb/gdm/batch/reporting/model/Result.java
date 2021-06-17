package com.bskyb.gdm.batch.reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true,value = {"action"},allowGetters = true)
public class Result {

    @Autowired
    ObjectMapper objectMapper;
    Result(){

    }
    //Id assigned for the log
    String id;
    //The time when the activity happened. It is the timestamp (in UTC time standard).
    String timestamp;
    //The cause of the activity.
    String cause;
    //The ID of the call that resulted in an activity
    String callId;
    /**
     * The description of the activity. It's the string in json format.
     * It's exact content depends on activityType and on the type of the resource
     * that was affected by the change.
     */
   // String description;
    //The type of the activity, which could be ADD, UPDATE or DELETE
    @JsonProperty("activityType")
    String activityType;
    //Id inside th user object nested in json
    String userId;
    //type inside th user object nested in json
    String userType;
    // user name inside th user object nested in json
    String userName;
    @JsonUnwrapped
    Action action;
    

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @JsonProperty("user")
    private void unpackUserFomNestedObject(Map<String, String> user) {
        userId = user.get("id");
        userType=user.get("resourceType");
        userName=user.get("userName");
    }
   @JsonProperty("description")
    private void unpackDescription(String description) {
       objectMapper=new ObjectMapper();
       try {
           Action tempAction=objectMapper.readValue(description, Action.class);
           this.action=tempAction;
       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }

   }


    @JsonProperty("activityId")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("activityTimestamp")
    public String getTimestamp() {
        return timestamp;
    }
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

   /* public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
*/
    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
