package com.example.edumeet;

public class St_model {
    String Name,Id,DOB;

    public St_model(String name, String id, String DOB) {
        Name = name;
        Id = id;
        this.DOB = DOB;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public St_model() {
    }
}
