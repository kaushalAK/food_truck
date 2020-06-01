package zelish.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodTruckResponse {

    public enum FoodTruckStatus {
        ADDSUCCESS,
        UPDATESUCCESS,
        DELETESUCCESS,
        GETSUCCESS,
        UPDATEFAILED,
        GETFAILED
    }

    @JsonProperty ("food_truck")
    private Object foodTruck;

    @JsonProperty("status")
    private FoodTruckStatus status;

    public FoodTruckResponse(){}

    @Override
    public String toString() {
        return "FoodTruckAddResponse{" + "status=" + status + '}';
    }
}
