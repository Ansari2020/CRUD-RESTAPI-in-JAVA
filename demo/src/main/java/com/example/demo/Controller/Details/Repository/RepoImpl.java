package com.example.demo.Controller.Details.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.Details.Pdetails;


@Service
public class RepoImpl implements DetailsRepo {

    List <Pdetails> list;

    public RepoImpl(){
        list= new ArrayList<>();
        {
            list.add(new Pdetails("danish", 11, "ghazipur"));
            list.add(new Pdetails("ansari", 12, "U.P"));
        }
    }

    @Override
    public List<Pdetails> getDetails() {

        return list;
    
}

    @Override
    public Pdetails getbyId(int id) {
        Pdetails pdetails=findById(id);
        return pdetails;

    }

    @Override
    public Map<String,Object> addPdetails(Pdetails pdetails ) {

        Map<String,Object> map=new HashMap<>();
        
        for(Pdetails pdetails2:list){
            if(pdetails2.getId()==pdetails.getId()){
                map.put("Message", "Id alredy present, Please use diffrent id");
                map.put("Status", HttpStatus.ALREADY_REPORTED);
                return map;
            }
        }
       list.add(pdetails);
       map.put("Message", "Created");
       map.put("Status", HttpStatus.OK);
        return map;
    
    }

    @Override
    public Map<String, Object> updatePdetails(Pdetails pdetails, int id) {
        Map<String,Object> map=new HashMap<>();
        Pdetails pdetails2=findById(id);

        if(pdetails2==null){
            
        map.put("Status", HttpStatus.NOT_FOUND);
        map.put("Message", "Id did not match");
        map.putAll(map);
            
        return map;
            
        }
        else{
            pdetails2.setName(pdetails.getName());
            pdetails2.setAddress(pdetails.getAddress());
            pdetails2.setId(pdetails.getId());
            map.put("Status", HttpStatus.OK);
            map.put("Message", "Entry updated");
            map.putAll(map);
        
            return map;

        }
        
    }

    @Override
    public Map<String,Object> pdelete(int id ) {
        Pdetails pdetails=findById(id);
        Map<String,Object> map=new HashMap<>();

        if(pdetails==null){
            map.put("Status", HttpStatus.NOT_FOUND);
            map.put("Message", "Id did not present in Database");
            return map;

        }
        
        list.removeIf(Pdetails->Pdetails.getId()==id);
            map.put("Message", "Entry deleted successfully");
            map.put("Status", HttpStatus.NO_CONTENT);
            
            return map;

     

    }
  
    public Pdetails findById(int id){
        for(Pdetails pdetails:list){
            if(pdetails.getId()==id){
                return pdetails;
            }
        }
        return null;
    }
}
