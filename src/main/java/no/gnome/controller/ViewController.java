package no.gnome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import no.gnome.City;
import no.gnome.Location;
import no.gnome.repository.CityRepository;

/**
 * Created by claus on 27/11/2016.
 */

@RestController
public class ViewController {
    
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public Map<String, Object> index() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("message", "Jeg æder blåbærsyltetøj!");
        return model;
    }
    
    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public List<City> getCity(@Valid @RequestBody Location payload, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            System.out.println("Error parsing payload");
        }
        
        List<City> city = cityRepository.findByName(payload.getName());
        return city;
    }

}
