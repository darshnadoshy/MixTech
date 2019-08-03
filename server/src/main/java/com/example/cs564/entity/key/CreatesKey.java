package com.example.cs564.entity.key;

import java.io.Serializable;

public class CreatesKey implements Serializable {
    private Long uid;
    private Long mid;

    public CreatesKey() {

    }

    public CreatesKey(long uid, Long mid) {
        this.uid = uid;
        this.mid =mid;
    }
}
