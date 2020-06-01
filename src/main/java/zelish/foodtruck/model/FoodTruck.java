package zelish.foodtruck.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Table(name = "food_truck_master")
public class FoodTruck {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "location_id")
    @JsonProperty("location_id")
    private long locationId;


    @Column (name = "applicant")
    @JsonProperty ("applicant")
    private String applicant;

    @Column (name = "facility_type")
    @JsonProperty ("facility_type")
    private String facility_type;


    @Column (name = "cnn")
    @JsonProperty ("cnn")
    private long cnn;

    @Column (name = "location_description")
    @JsonProperty ("location_description")
    private String location_description;



    @Column (name = "blocklot")
    @JsonProperty ("blocklot")
    private String blocklot;

    @Column (name = "block")
    @JsonProperty ("block")
    private String block;



    @Column (name = "lot")
    @JsonProperty ("lot")
    private String lot;

    @Column (name = "permit")
    @JsonProperty ("permit")
    private String permit;



    @Column (name = "status")
    @JsonProperty ("status")
    private String status;

    @Column (name = "food_items")
    @JsonProperty ("food_items")
    private String food_items;



    @Column (name = "latitude")
    @JsonProperty ("latitude")
    private BigDecimal latitude;

    @Column (name = "longitude")
    @JsonProperty ("longitude")
    private BigDecimal longitude;

    @Column (name = "X")
    @JsonProperty ("X")
    private BigDecimal X;

    @Column (name = "Y")
    @JsonProperty ("Y")
    private BigDecimal Y;

    @Column (name = "schedule")
    @JsonProperty ("schedule")
    private String schedule;

    @Column (name = "dayshours")
    @JsonProperty ("dayshours")
    private String dayshours;



    @Column (name = "noi_sent")
    @JsonProperty ("noi_sent")
    private Timestamp noi_sent;

    @Column (name = "approved")
    @JsonProperty ("approved")
    private Timestamp approved;



    @Column (name = "received")
    @JsonProperty ("received")
    private String received;

    @Column (name = "prior_permit")
    @JsonProperty ("prior_permit")
    private long prior_permit;



    @Column (name = "expiration_date")
    @JsonProperty ("expiration_date")
    private Timestamp expiration_date;

    @Column (name = "location")
    @JsonProperty ("location")
    private String location;



}
