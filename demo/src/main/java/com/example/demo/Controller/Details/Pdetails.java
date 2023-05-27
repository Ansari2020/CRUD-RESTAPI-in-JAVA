package com.example.demo.Controller.Details;



public class Pdetails {

    String name;
    int id;
    String Address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Pdetails(String name, int id, String address) {
        this.name = name;
        this.id = id;
        Address = address;
    }
    @Override
    public String toString() {
        return "Pdetails [name=" + name + ", id=" + id + ", Address=" + Address + "]";
    }
   
    
    
   
    
   

    
}
