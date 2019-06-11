package com.example.ShopREST.assortment;

import com.example.ShopREST.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AssortimentController {

    @Autowired
    AssortimentRepository assortimentRepository;

    //Get ALL ASSORTIMENT

    @GetMapping("/assortiments")
    public List<Assortment> getAllAssortiments() {

        return assortimentRepository.findAll();
    }

    //Add a new assortiment to database

    @PostMapping("assortiments")
    public Assortment createAssortiment(@Valid @RequestBody Assortment assortment) {
        return assortimentRepository.save(assortment);
    }

    //Get a single assortiment

    @GetMapping("/assortiment/{id}")
    public Assortment getAssortimentById(@PathVariable(value = "id") Long assortimentId) {
        return assortimentRepository.findById(assortimentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assortiment" , "id", assortimentId));
    }

    //Update a assortmient

    @PutMapping("/assortmients/{id}")
    public Assortment updateAssortiment(@PathVariable(value = "id") Long assortimentId,
                                        @Valid @RequestBody Assortment assortmentDetails) {
        Assortment assortment = assortimentRepository.findById(assortimentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assortiment" , "id" , assortimentId));

        assortment.setPrice(assortmentDetails.getPrice());
        assortment.setDescription(assortmentDetails.getDescription());

        Assortment updatedAssortiment = assortimentRepository.save(assortment);
        return updatedAssortiment;
    }

    @DeleteMapping("/assortiments.{id}")
    public ResponseEntity<?> deleteAssortiment(@PathVariable(value = "id") Long assortimentId) {
        Assortment assortment = assortimentRepository.findById(assortimentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assortiment", "id", assortimentId));

        assortimentRepository.delete(assortment);

        return ResponseEntity.ok().build();
    }

}
