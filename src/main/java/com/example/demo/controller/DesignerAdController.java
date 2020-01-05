package com.example.demo.controller;

import com.example.demo.Entity.DesignerAd;
import com.example.demo.Repository.DesignerAdRepo;
import com.example.demo.Service.DesignerAdService;
import com.example.demo.dto.DesignerAdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class DesignerAdController {
    @Autowired
    private DesignerAdService designerAdService;
    @Autowired
    private DesignerAdRepo designerAdRepo;

    @PostMapping(value = "/saveDesignerAd")
    public void saveDesignerAd(@RequestBody DesignerAdDTO dto){
        designerAdService.saveDesignerAd(dto);
    }


    @GetMapping(value = "/getAllDesignerAds")
    public List<DesignerAd> findAllDesignerAds(){
        return designerAdService.getAllDesignerAd();
    }

    @GetMapping(value = "/findDesignerAdById/{id}")
    public ResponseEntity<DesignerAd> findDesignerAdById(@PathVariable ("id")Integer id) {

        Optional<DesignerAd> designerAd = designerAdRepo.findById(id);
        if (designerAd.isPresent()){
            return new ResponseEntity<>(designerAd.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/saveImage")
    public void saveImage(@RequestParam("designerAdDto") DesignerAdDTO dto) throws IOException {
        designerAdService.saveDesignerAd(dto);
    }

}
