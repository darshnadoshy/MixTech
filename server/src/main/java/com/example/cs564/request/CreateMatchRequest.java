package com.example.cs564.request;

import lombok.Data;

/**
 * used to receive info to create match from the frontend
 */
@Data
public class CreateMatchRequest {
    String mname;
    String spotifyUri1;

    public CreateMatchRequest() {

    }

    public CreateMatchRequest(String mname, String spotifyUri1) {
        this.mname = mname;
        this.spotifyUri1 = spotifyUri1;
    }
}
