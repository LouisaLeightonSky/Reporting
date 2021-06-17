package com.bskyb.gdm.batch.reporting.model;

import java.util.List;

public class LogResponse {
    // The total number of results
    String total;
    //The offset for the results.
    String offset;
    //The maximum number of results to be returned.
    String limit;
    //The list of results of activity
    List<Result> results;
    /*Getter and  setters */
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getOffset() {
        return offset;
    }
    public void setOffset(String offset) {
        this.offset = offset;
    }
    public String getLimit() {
        return limit;
    }
    public void setLimit(String limit) {
        this.limit = limit;
    }
    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
    public String toString() {
        return "Response{" +
                "total='" + total + '\'' +
                ", offset='" + offset + '\'' +
                ", limit='" + limit + '\'' +
                ", results=" + results.size() +
                '}';
    }
}
