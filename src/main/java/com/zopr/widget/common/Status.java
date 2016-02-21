package com.zopr.widget.common;

/**
 * Created by zorana on 2/21/16.
 */
public enum Status {

    ALIVE("ALIVE"),
    DEAD("DEAD");

    private String statusName;

    private Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return this.statusName;
    }


}
