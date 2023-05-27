package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Controller.Details.Pdetails;
import com.example.demo.Controller.Details.Repository.DetailsRepo;

@RestController


public class Controller {
    

     @Autowired
     private DetailsRepo detailsRepo;

    @GetMapping("/home")
    public ResponseEntity< String>  getmap()
    {
        String s= "this is Home Page";
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }


    @GetMapping("/details")
    public ResponseEntity<List<Pdetails>> details() {
        List<Pdetails> list= detailsRepo.getDetails();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(list);
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "server returning some error");
        }
            
        
        
    }

    @GetMapping("/details/{id}")
    public ResponseEntity< Pdetails> byId(@PathVariable int id){
        Pdetails pdetails= this.detailsRepo.getbyId(id);
        try {
            
        if(pdetails==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pdetails);
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    }

    @PostMapping("/details")
    public ResponseEntity<Map<String,Object>> addPdetails(@RequestBody Pdetails pdetails){
        try {
            Map<String, Object> jsonObjMap= this.detailsRepo.addPdetails(pdetails);
            return ResponseEntity.status((HttpStatus) jsonObjMap.get("Status")).body(jsonObjMap);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            
        }

    }

    @PutMapping("/details/{id}")
    public ResponseEntity<Map<String, Object>> putdPdetails(@RequestBody Pdetails pdetails, @PathVariable int id){
        
        try{
            Map<String,Object> jsoMap= this.detailsRepo.updatePdetails(pdetails, id);
        return ResponseEntity.status((HttpStatus) jsoMap.get("Status")).body(jsoMap);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity< Map<String,Object>> pdelete(@PathVariable int id){
         
         try {
            Map<String,Object> jsonMap= this.detailsRepo.pdelete(id);
            return ResponseEntity.status((HttpStatus) jsonMap.get("Status")).body(jsonMap);
            
         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            
         }
    }

    
}
