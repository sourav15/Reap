package com.letsreap.reap.beans;

import java.util.Map;

/**
 * Created by sourav on 9/3/16.
 */
public class ResponseBean {

    String status;
    Map<String, Map<String,String>> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }
}
