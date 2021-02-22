package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.simple.JSONObject;

public final class Airplane {

    private String id;
    private String plate;
    private String brand;
    private String version;
    private String model;
    private String color;
    private String type;
    private long num_motors;
    private long num_ports;
    private String capacity;
    private String velocity;
    private long num_flights;
    private String miles;
    private String pilot;

    @JsonCreator
    public Airplane(
        @JsonProperty("id") String id,
        @JsonProperty("plate") String plate,
        @JsonProperty("brand") String brand,
        @JsonProperty("version") String version,
        @JsonProperty("model") String model,
        @JsonProperty("color") String color,
        @JsonProperty("type") String type,
        @JsonProperty("num_motors") long num_motors,
        @JsonProperty("num_ports") long num_ports,
        @JsonProperty("capacity") String capacity,
        @JsonProperty("velocity") String velocity,
        @JsonProperty("num_flights") long num_flights,
        @JsonProperty("miles") String miles,
        @JsonProperty("pilot") String pilot
    ){
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.version = version;
        this.model = model;
        this.color = color;
        this.type = type;
        this.num_motors = num_motors;
        this.num_ports = num_ports;
        this.capacity = capacity;
        this.velocity = velocity;
        this.num_flights = num_flights;
        this.miles = miles;
        this.pilot = pilot;
    }
    
    public JSONObject toJson() {
        
        final JSONObject movie = new JSONObject();
        
        movie.put("id", this.getId());
        movie.put("plate", this.getPlate());
        movie.put("brand", this.getBrand());
        movie.put("version", this.getVersion());
        movie.put("model", this.getModel());
        movie.put("color", this.getColor());
        movie.put("type", this.getType());
        movie.put("num_motors", this.getNum_motors());
        movie.put("num_ports", this.getNum_ports());
        movie.put("capacity", this.getCapacity());
        movie.put("velocity", this.getVelocity());
        movie.put("num_flights", this.getNum_flights());
        movie.put("miles", this.getMiles());
        movie.put("pilot", this.getPilot());
        
        return movie;
    }
    
    public Airplane() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNum_motors() {
        return num_motors;
    }

    public void setNum_motors(long num_motors) {
        this.num_motors = num_motors;
    }

    public long getNum_ports() {
        return num_ports;
    }

    public void setNum_ports(long num_ports) {
        this.num_ports = num_ports;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public long getNum_flights() {
        return num_flights;
    }

    public void setNum_flights(long num_flights) {
        this.num_flights = num_flights;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }
}
