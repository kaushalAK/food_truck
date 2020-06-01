package zelish.foodtruck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zelish.foodtruck.model.FoodTruck;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FoodTruckRepo extends JpaRepository<FoodTruck,Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * from food_truck_master where expiration_date < now()",nativeQuery = true)
    List<FoodTruck> getExpiredEntries();


    @Transactional
    @Modifying
    @Query(value = "SELECT * from food_truck_master where applicant =:applicantName ",nativeQuery = true)
    List<FoodTruck> getApplicantData(@Param("applicantName") String applicantName);

    @Transactional
    @Modifying
    @Query(value = "SELECT * from food_truck_master where facility_type =:facilityType ",nativeQuery = true)
    List<FoodTruck> getFacilityData(@Param("facilityType") String facilityType);

    @Transactional
    @Modifying
    @Query(value = "SELECT * from food_truck_master where food_items =:foodItems ",nativeQuery = true)
    List<FoodTruck> getFoodItemsData(@Param("foodItems") String foodItems);

    @Transactional
    @Modifying
    @Query(value = "SELECT * from food_truck_master where received =:received ",nativeQuery = true)
    List<FoodTruck> getReceivedData(@Param("received") String received);



    @Transactional
    @Modifying
    @Query(value = "SELECT location_description from food_truck_master where latitude =:latitude and longitude =:longitude and facility_type = 'Truck'",nativeQuery = true)
    String getLocationData(@Param("latitude") String latitude, @Param("longitude") String longitude);



}
