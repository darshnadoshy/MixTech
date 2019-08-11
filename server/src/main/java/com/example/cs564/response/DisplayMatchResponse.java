package com.example.cs564.response;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class DisplayMatchResponse {
    private Long mid;
    private String sname1;
    private String sname2;

    public DisplayMatchResponse() {}

    public DisplayMatchResponse(Long mid, String sname1) {
        this.mid = mid;
        this.sname1 = sname1;
    }

    public DisplayMatchResponse(Long mid, String sname1, String sname2) {
        this.mid = mid;
        this.sname1 = sname1;
        this.sname2 = sname2;
    }
}
