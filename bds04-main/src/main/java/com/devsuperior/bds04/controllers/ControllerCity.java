package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class ControllerCity {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        return ResponseEntity.ok(service.findAllSortName());
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.created(null).body(dto);
    }
}
