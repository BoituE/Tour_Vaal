package com.example.admin.tour_vaal;

/**
 * Created by Admin on 7/28/2017.
 */

public class Mall {
    String mallId;
    String mallName;
    String mallAddress;

public Mall(){

}

    public Mall(String mallId, String mallName, String mallAddress) {
        this.mallId = mallId;
        this.mallName = mallName;
        this.mallAddress = mallAddress;
    }

    public String getMallId() {
        return mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public String getMallAddress() {
        return mallAddress;
    }

    }

