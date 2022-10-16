package com.example.edumeet;

import java.util.Objects;

public class College_Model {
    String Id,Pass;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public College_Model(String id, String pass) {
        Id = id;
        Pass = pass;
    }

    public College_Model() {
    }
    @Override
    public  boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof College_Model)) return false;
        College_Model college_model=(College_Model) o;
        return  Objects.equals(getId(), college_model.getId()) && Objects.equals(getPass(), college_model.getPass());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(),getPass());
    }
}
