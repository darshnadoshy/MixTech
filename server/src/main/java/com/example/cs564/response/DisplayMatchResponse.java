package com.example.cs564.response;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class DisplayMatchResponse {
//    private String mname;
    private String sname1;
    private String sname2;

    public DisplayMatchResponse() {}

    public DisplayMatchResponse(String sname1) {
        this.sname1 = sname1;
    }

    public DisplayMatchResponse(String sname1, String sname2) {
        this.sname1 = sname1;
        this.sname2 = sname2;
    }
}
