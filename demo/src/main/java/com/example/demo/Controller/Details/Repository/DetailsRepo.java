package com.example.demo.Controller.Details.Repository;

import java.util.List;
import java.util.Map;

import com.example.demo.Controller.Details.Pdetails;

public interface DetailsRepo {

    public List<Pdetails> getDetails();
    public Pdetails getbyId(int id);
    public Map<String,Object> addPdetails(Pdetails pdetails);
    public Map<String,Object> updatePdetails(Pdetails pdetails, int id);
    public Map<String,Object> pdelete(int id);   
    
}
