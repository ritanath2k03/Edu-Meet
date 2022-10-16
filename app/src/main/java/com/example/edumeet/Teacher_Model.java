package com.example.edumeet;

import java.util.Objects;

public class Teacher_Model {
    String Name,Id,Password;

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

    public Teacher_Model(String name, String id, String password) {
        Name = name;
        Id = id;
        Password = password;
    }




    @Override
    public  boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Teacher_Model)) return false;
      Teacher_Model teacher_model = (Teacher_Model) o;
        return Objects.equals(getName(), teacher_model.getName()) && Objects.equals(getId(), teacher_model.getId()) && Objects.equals(getPassword(), teacher_model.getPassword());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getPassword());
    }

}
