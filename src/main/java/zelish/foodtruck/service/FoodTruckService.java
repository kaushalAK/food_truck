package zelish.foodtruck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zelish.foodtruck.model.FoodTruck;
import zelish.foodtruck.model.FoodTruckAddRequest;
import zelish.foodtruck.model.FoodTruckResponse;
import zelish.foodtruck.model.FoodTruckUpdateRequest;
import zelish.foodtruck.repository.FoodTruckRepo;

@Service
public class FoodTruckService {

    private static final String applicant = "applicant";
    private static final String received = "received";
    private static final String foodItems = "fooditems";
    private static final String facilityType = "facilitytype";

    @Autowired
    FoodTruckRepo foodTruckRepo;

    public FoodTruckResponse addFoodTruckDetails(FoodTruckAddRequest foodTruckAddRequest){

        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();
        FoodTruck foodTruck = prepareFoodTruckAddObject(foodTruckAddRequest);


        FoodTruck fdresponse = foodTruckRepo.save(foodTruck);
        if(fdresponse.getId() >0){
            foodTruckResponse.setStatus(FoodTruckResponse.FoodTruckStatus.ADDSUCCESS);
        }
        return foodTruckResponse;
    }

    public FoodTruckResponse updateFoodTruckDetails(FoodTruckUpdateRequest foodTruckUpdateRequest){

        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();
        FoodTruck foodTruck = prepareFoodTruckUpdateObject(foodTruckUpdateRequest);

        Long productId  = foodTruckRepo.save(foodTruck).getLocationId();

        if(productId != 0){
            foodTruckResponse.setStatus(FoodTruckResponse.FoodTruckStatus.UPDATESUCCESS);
        }
        return foodTruckResponse;
    }

    public FoodTruckResponse deleteFoodTruckEntry(Long locationId){
        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();
        foodTruckRepo.deleteById(locationId);
        foodTruckResponse.setStatus(FoodTruckResponse.FoodTruckStatus.DELETESUCCESS);
        return foodTruckResponse;
    }



    private FoodTruck prepareFoodTruckUpdateObject(FoodTruckUpdateRequest foodTruckUpdateRequest) {
        FoodTruck fd = new FoodTruck();
        fd.setLocationId(foodTruckUpdateRequest.getLocationId());
        fd.setLocation(foodTruckUpdateRequest.getLocation());
        fd.setApplicant(foodTruckUpdateRequest.getApplicant());
        fd.setApproved(foodTruckUpdateRequest.getApproved());
        fd.setBlock(foodTruckUpdateRequest.getBlock());
        fd.setBlocklot(foodTruckUpdateRequest.getBlocklot());
        fd.setCnn(foodTruckUpdateRequest.getCnn());
        fd.setDayshours(foodTruckUpdateRequest.getDayshours());
        fd.setExpiration_date(foodTruckUpdateRequest.getExpiration_date());
        fd.setFacility_type(foodTruckUpdateRequest.getFacility_type());
        fd.setFood_items(foodTruckUpdateRequest.getFood_items());
        fd.setLatitude(foodTruckUpdateRequest.getLatitude());
        fd.setLocation_description(foodTruckUpdateRequest.getLocation_description());
        fd.setLongitude(foodTruckUpdateRequest.getLongitude());
        fd.setLot(foodTruckUpdateRequest.getLot());
        fd.setNoi_sent(foodTruckUpdateRequest.getNoi_sent());
        fd.setPermit(foodTruckUpdateRequest.getPermit());
        fd.setPrior_permit(foodTruckUpdateRequest.getPrior_permit());
        fd.setReceived(foodTruckUpdateRequest.getReceived());
        fd.setSchedule(foodTruckUpdateRequest.getSchedule());
        fd.setStatus(foodTruckUpdateRequest.getStatus());
        fd.setX(foodTruckUpdateRequest.getX());
        fd.setY(foodTruckUpdateRequest.getY());
        return fd;
    }


    private FoodTruck prepareFoodTruckAddObject(FoodTruckAddRequest foodTruckAddRequest) {
        FoodTruck fd = new FoodTruck();
        fd.setLocation(foodTruckAddRequest.getLocation());
        fd.setApplicant(foodTruckAddRequest.getApplicant());
        fd.setApproved(foodTruckAddRequest.getApproved());
        fd.setBlock(foodTruckAddRequest.getBlock());
        fd.setBlocklot(foodTruckAddRequest.getBlocklot());
        fd.setCnn(foodTruckAddRequest.getCnn());
        fd.setDayshours(foodTruckAddRequest.getDayshours());
        fd.setExpiration_date(foodTruckAddRequest.getExpiration_date());
        fd.setFacility_type(foodTruckAddRequest.getFacility_type());
        fd.setFood_items(foodTruckAddRequest.getFood_items());
        fd.setLatitude(foodTruckAddRequest.getLatitude());
        fd.setLocation_description(foodTruckAddRequest.getLocation_description());
        fd.setLongitude(foodTruckAddRequest.getLongitude());
        fd.setLot(foodTruckAddRequest.getLot());
        fd.setNoi_sent(foodTruckAddRequest.getNoi_sent());
        fd.setPermit(foodTruckAddRequest.getPermit());
        fd.setPrior_permit(foodTruckAddRequest.getPrior_permit());
        fd.setReceived(foodTruckAddRequest.getReceived());
        fd.setSchedule(foodTruckAddRequest.getSchedule());
        fd.setStatus(foodTruckAddRequest.getStatus());
        fd.setX(foodTruckAddRequest.getX());
        fd.setY(foodTruckAddRequest.getY());
        return fd;
    }


    public FoodTruckResponse getExpiredFoodTruckEntry() {
        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();
        foodTruckResponse.setFoodTruck(foodTruckRepo.getExpiredEntries());
        foodTruckResponse.setStatus(FoodTruckResponse.FoodTruckStatus.GETSUCCESS);
        return foodTruckResponse;
    }

    public FoodTruckResponse getData(String key, String value){
        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();

        switch (key){
            case applicant:
                foodTruckResponse.setFoodTruck(foodTruckRepo.getApplicantData(value));
                break;
            case foodItems:
                foodTruckResponse.setFoodTruck(foodTruckRepo.getFoodItemsData(value));
                break;
            case facilityType:
                foodTruckResponse.setFoodTruck(foodTruckRepo.getFacilityData(value));
                break;
            case received:
                foodTruckResponse.setFoodTruck(foodTruckRepo.getReceivedData(value));
                break;
        }


        return foodTruckResponse;
    }

    public FoodTruckResponse getLocationData(String latitude, String longitude){
        FoodTruckResponse foodTruckResponse = new FoodTruckResponse();
        foodTruckResponse.setFoodTruck(foodTruckRepo.getLocationData(latitude,longitude));
        return foodTruckResponse;
    }
}
