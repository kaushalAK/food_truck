package zelish.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zelish.foodtruck.model.AppResponse;
import zelish.foodtruck.model.FoodTruckAddRequest;
import zelish.foodtruck.model.FoodTruckResponse;
import zelish.foodtruck.model.FoodTruckUpdateRequest;
import zelish.foodtruck.service.FoodTruckService;

public class FoodTruckAPI {
    private static final String FOODTRUCK_ADD_API_URL = "/api/zelish/truck/add";
    private static final String FOODTRUCK_UPDATE_API_URL = "/api/zelish/truck/update";
    private static final String FOODTRUCK_DELETE_API_URL = "/api/zelish/truck/update";
    private static final String GETEXPIREDTRUCKS = "/api/zelish/truck/expired";
    private static final String GETDATA = "/api/zelish/truck/getdata";
    private static final String GETLOCATION = "/api/zelish/truck/getlocation";


    @Autowired
    FoodTruckService foodTruckService;

    @GetMapping(value ="/print")
    public void justPrint(){
        System.out.println("printed");
    }

    @PostMapping(value = FOODTRUCK_ADD_API_URL)
    public ResponseEntity addFoodTruck(@RequestBody FoodTruckAddRequest foodTruckAddRequest){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.addFoodTruckDetails(foodTruckAddRequest);
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }


    @PostMapping(value = FOODTRUCK_UPDATE_API_URL)
    public ResponseEntity updateFoodTruck(@RequestBody FoodTruckUpdateRequest foodTruckUpdateRequest){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.updateFoodTruckDetails(foodTruckUpdateRequest);
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = FOODTRUCK_DELETE_API_URL)
    public ResponseEntity deleteFoodTruckAPI(@RequestHeader ("location_id") Long locationid){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.deleteFoodTruckEntry(locationid);
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }

    @GetMapping(value= GETEXPIREDTRUCKS)
    public ResponseEntity expiredFoodTruckAPI(){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.getExpiredFoodTruckEntry();
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }

    @GetMapping(value = GETDATA)
    public ResponseEntity getDataAPI(@RequestHeader ("key") String key, @RequestHeader ("value") String value){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.getData(key, value);
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }


    @GetMapping(value = GETLOCATION)
    public ResponseEntity getLocationDataAPI(@RequestHeader ("latitude") String latitude, @RequestHeader ("longitude") String longitude){
        AppResponse appResponse = new AppResponse();
        FoodTruckResponse foodTruckResponse = foodTruckService.getLocationData(latitude, longitude);
        appResponse.setData(foodTruckResponse);
        appResponse.setMsg(foodTruckResponse.getStatus().toString());
        return new ResponseEntity(appResponse, HttpStatus.OK);
    }




}
