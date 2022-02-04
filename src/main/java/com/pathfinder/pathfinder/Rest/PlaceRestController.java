package com.pathfinder.pathfinder.Rest;

import com.pathfinder.pathfinder.Entity.Place;
import com.pathfinder.pathfinder.Entity.Response;
import com.pathfinder.pathfinder.Service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Places")
public class PlaceRestController {
    PlaceService placeService;

    public PlaceRestController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/")
    public Response<Place> addPlace(@RequestBody Place place){
        try {
            var response = placeService.addPlace(place);
            return new Response<>(true,"Place added",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @DeleteMapping("/{name}")
    public Response<Boolean> deletePlace(@PathVariable String name){
        try {
            var response = placeService.getPlaceByName(name);
            if (response != null)
                placeService.deletePlace(response);
                return new Response<>(true,"Place deleted",true);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),false);
        }
    }

    @PutMapping("/{name}")
    public Response<Place> updatePlace(@PathVariable String name, @RequestBody Place place){
        try {
            var response = placeService.getPlaceByName(name);
            if (response != null)
                placeService.updatePlace(response.getId(),place);
                return new Response<>(true,"Place updated",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/{name}")
    public Response<Place> getPlaceByName(@PathVariable String name){
        try {
            var response = placeService.getPlaceByName(name);
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"Place not found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/")
    public Response<List<Place>> getAllPlaces(){
        try {
            var response = placeService.getAllPlaces();
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"No Place Found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }
}
