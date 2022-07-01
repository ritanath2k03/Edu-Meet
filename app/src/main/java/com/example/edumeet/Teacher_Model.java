package com.example.edumeet;

public class Teacher_Model {
    String Name,Id,Password;

    public Teacher_Model(String name, String id, String password) {
        Name = name;
        Id = id;
        Password = password;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Teacher_Model() {
    }
}
