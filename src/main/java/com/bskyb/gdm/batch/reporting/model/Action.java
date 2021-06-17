package com.bskyb.gdm.batch.reporting.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
    //The data Type updated /modified
    @JsonProperty("kind")
    String kind;
    // The field updated / modified
    @JsonProperty("field")
    String field;
    //
    String affectedId;
    //
    String affectedName;
    //
    String  affectedType;
    //
    String  role;
    //
    String coRole;
    //
    String businessItemId;
    //
    String businessItemName;
    //
    String  businessItemType;
    //
    String sourceId;
    //
    String sourceName;
    //
    String  sourceType;
    //
    String targetId;
    //
    String targetName;
    //
    String  targetType;
    //
    String peopleId;
    //
    String peopleName;
    //
    String  peopleType;
    //
    String newId;
    //
    String newName;
    //
    String  newType;
    //
    String oldId;
    //
    String oldName;
    //
    String  oldType;
    //
    @JsonProperty("affected")
    private void unpackAffectedFomNestedObject(Map<String, String> affected) {
        affectedId = affected.get("id");
        affectedName=affected.get("name");
        affectedType=affected.get("type");
    }
    @JsonProperty("people")
    private void unpackPeopleFomNestedObject(Map<String, String> people) {
        peopleId = people.get("id");
        peopleName=people.get("name");
        peopleType=people.get("type");
    }
    @JsonProperty("new")
    private void unpackNewFomNestedObject(Map<String, String> newString) {
        newId = newString.get("id");
        newName=newString.get("name");
        newType=newString.get("type");
    }
    @JsonProperty("old")
    private void unpackOldFomNestedObject(Map<String, String> old) {
        oldId = old.get("id");
        oldName=old.get("name");
        oldType=old.get("type");
    }
    @JsonProperty("businessItem")
    private void unpackBusinessItemFomNestedObject(Map<String, String> businessItem) {
        businessItemId = businessItem.get("id");
        businessItemName=businessItem.get("name");
        businessItemType=businessItem.get("type");
    }

    @JsonProperty("source")
    private void unpackSourceFomNestedObject(Map<String, String> source) {
        sourceId = source.get("id");
        sourceName=source.get("name");
        sourceType=source.get("type");
    }
    @JsonProperty("target")
    private void unpackTargetFomNestedObject(Map<String, String> target) {
        targetId = target.get("id");
        targetName=target.get("name");
        targetType=target.get("type");
    }


    /* Getter and setter methods */
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }

    public String getAffectedId() {
        return affectedId;
    }

    public void setAffectedId(String affectedId) {
        this.affectedId = affectedId;
    }

    public String getAffectedName() {
        return affectedName;
    }

    public void setAffectedName(String affectedName) {
        this.affectedName = affectedName;
    }

    public String getAffectedType() {
        return affectedType;
    }

    public void setAffectedType(String affectedType) {
        this.affectedType = affectedType;
    }


    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldType() {
        return oldType;
    }

    public void setOldType(String oldType) {
        this.oldType = oldType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCoRole() {
        return coRole;
    }

    public void setCoRole(String coRole) {
        this.coRole = coRole;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public String getBusinessItemName() {
        return businessItemName;
    }

    public void setBusinessItemName(String businessItemName) {
        this.businessItemName = businessItemName;
    }

    public String getBusinessItemType() {
        return businessItemType;
    }

    public void setBusinessItemType(String businessItemType) {
        this.businessItemType = businessItemType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

}
