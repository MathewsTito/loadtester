package com.discover.rewards.loadtest;

/**
 * Created by tito on 12/24/18.
 */
public class Result {
    private long creationTime;
    private long reqStartTime;
    private long reqEndTime;
    private String request;
    private String response;

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getReqStartTime() {
        return reqStartTime;
    }

    public void setReqStartTime(long reqStartTime) {
        this.reqStartTime = reqStartTime;
    }

    public long getReqEndTime() {
        return reqEndTime;
    }

    public void setReqEndTime(long reqEndTime) {
        this.reqEndTime = reqEndTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
