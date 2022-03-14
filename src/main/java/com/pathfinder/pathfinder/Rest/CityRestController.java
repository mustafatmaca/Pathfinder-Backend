package com.pathfinder.pathfinder.Rest;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Response;
import com.pathfinder.pathfinder.Service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cities")
public class CityRestController {
    CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/")
    public Response<City> addCity(@RequestBody City city){
        try {
            var response = cityService.addCity(city);
            return new Response<>(true,"City added",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @DeleteMapping("/{name}")
    public Response<Boolean> deleteCity(@PathVariable String name){
        try {
            var response = cityService.getCityByName(name);
            if (response != null)
                cityService.deleteCity(response);
                return new Response<>(true,"City deleted",true);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),false);
        }
    }

    @PutMapping("/{name}")
    public Response<City> updateCity(@PathVariable String name, @RequestBody City city){
        try {
            var response = cityService.getCityByName(name);
            if (response != null)
                cityService.updateCity(response.getId(),city);
                return new Response<>(true,"City updated",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/{name}")
    public City getCity(@PathVariable String name){
        try {
            var response = cityService.getCityByName(name);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/")
    public List<City> getAllCities(){
        try {
            var response = cityService.getAllCities();
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

}
