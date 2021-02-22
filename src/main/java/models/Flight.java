package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.simple.JSONObject;

public final class Flight {

    private String id;
    private String start_country;
    private String start_city;
    private String start_at;
    private String start_airport;
    private String arrive_country;
    private String arrive_city;
    private String arrive_at;
    private int price;
    private String num_passangers;

    @JsonCreator
    public Flight(
        @JsonProperty("id") String id,
        @JsonProperty("start_country") String start_country,
        @JsonProperty("start_city") String start_city,
        @JsonProperty("start_at") String start_at,
        @JsonProperty("start_airport") String start_airport,
        @JsonProperty("arrive_country") String arrive_country,
        @JsonProperty("arrive_city") String arrive_city,
        @JsonProperty("arrive_at") String arrive_at,
        @JsonProperty("price") int price,
        @JsonProperty("num_passangers") String num_passangers
    ){
        this.id = id;
        this.start_country = start_country;
        this.start_city = start_city;
        this.start_at = start_at;
        this.start_airport = start_airport;
        this.arrive_country = arrive_country;
        this.arrive_city = arrive_city;
        this.arrive_at = arrive_at;
        this.price = price;
        this.num_passangers = num_passangers;
    }
    
    public Flight(){}
    
    public JSONObject toJson() {
        
        final JSONObject movie = new JSONObject();
        
        movie.put("id", this.getId());
        movie.put("start_country", this.getStart_country());
        movie.put("start_city", this.getStart_city());
        movie.put("start_at", this.getStart_at());
        movie.put("start_airport", this.getStart_airport());
        movie.put("arrive_country", this.getArrive_country());
        movie.put("arrive_city", this.getArrive_city());
        movie.put("arrive_at", this.getArrive_at());
        movie.put("price", this.getPrice());
        movie.put("num_passangers", this.getNum_passangers());
        
        return movie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum_passangers() {
        return num_passangers;
    }

    public void setNum_passangers(String num_passangers) {
        this.num_passangers = num_passangers;
    }

    public String getStart_country() {
        return start_country;
    }

    public void setStart_country(String start_country) {
        this.start_country = start_country;
    }

    public String getStart_city() {
        return start_city;
    }

    public void setStart_city(String start_city) {
        this.start_city = start_city;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getStart_airport() {
        return start_airport;
    }

    public void setStart_airport(String start_airport) {
        this.start_airport = start_airport;
    }

    public String getArrive_country() {
        return arrive_country;
    }

    public void setArrive_country(String arrive_country) {
        this.arrive_country = arrive_country;
    }

    public String getArrive_city() {
        return arrive_city;
    }

    public void setArrive_city(String arrive_city) {
        this.arrive_city = arrive_city;
    }

    public String getArrive_at() {
        return arrive_at;
    }

    public void setArrive_at(String arrive_at) {
        this.arrive_at = arrive_at;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
