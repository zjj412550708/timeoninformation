package com.example.information.pojo;

import java.util.Date;

public class Person {
    private String usercode;

    private String username;

    private String department;

    private Date hiredate;

    public Person(String usercode, String username, String department, Date hiredate) {
        this.usercode = usercode;
        this.username = username;
        this.department = department;
        this.hiredate = hiredate;
    }

    public Person() {
        super();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}