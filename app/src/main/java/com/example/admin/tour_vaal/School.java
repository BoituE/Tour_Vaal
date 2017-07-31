package com.example.admin.tour_vaal;

/**
 * Created by Admin on 7/31/2017.
 */

public class School {
    String schoolId;
    String schoolName;
    String schoolAddress;

    public School(String id, String name, String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }


    public String getSchoollName() {
        return schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

}

