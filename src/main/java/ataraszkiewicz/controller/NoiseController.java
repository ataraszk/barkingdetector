package ataraszkiewicz.controller;

import ataraszkiewicz.documents.Noise;
import ataraszkiewicz.repo.NoiseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ataraszkiewicz
 * @since 2015-08-31
 */
@Controller
@RequestMapping("/noise")
public class NoiseController {

    private final NoiseRepo noiseRepo;

    @Autowired
    public NoiseController(NoiseRepo noiseRepo) {
        this.noiseRepo = noiseRepo;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public List<Noise> allNoises() {
        return noiseRepo.findAll();
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> submitStory(@RequestBody Noise noise) {
        noise.setCurrentDate(new Date());
        noiseRepo.save(noise);
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
        return responseEntity;
    }


    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST, value = "/list")
    @ResponseBody
    public ResponseEntity<Void> submitStoryList(@RequestBody List<Noise> list) {
        for (Noise noise : list) {
            noise.setCurrentDate(new Date());
            noiseRepo.save(noise);
        }
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
        return responseEntity;
    }

}
