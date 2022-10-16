package com.example.edumeet;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof St_model)) return false;
        St_model st_model = (St_model) o;
        return Objects.equals(getName(), st_model.getName()) && Objects.equals(getId(), st_model.getId()) && Objects.equals(getDOB(), st_model.getDOB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getDOB());
    }
}
