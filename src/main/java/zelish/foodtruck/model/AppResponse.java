package zelish.foodtruck.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({"data", "msg", "isError","errorMsg"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class AppResponse {

    @JsonProperty("data")
    private Object data;

    @JsonProperty ("msg")
    private String msg;

    @JsonProperty ("isError")
    private boolean isError;

    @JsonProperty ("errorMsg")
    private String errorMsg;


    public AppResponse(){

    }

    @Override
    public String toString(){
        return "AppResponse {" + "msg='" + msg + '\'' + ", isError=" + isError + ", errorMsg='" + errorMsg + '\'' + '}';
    }

}
