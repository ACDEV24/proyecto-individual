package requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import models.Flight;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Flights {

    private JSONArray getAllFlights() {
        
        try {
            
            JSONArray flights = new JSONArray();
            
            final JSONParser parser = new JSONParser();
            
            flights = (JSONArray) parser.parse(new FileReader("flights.json"));
            
            return flights;
        } catch (IOException | ParseException ex) {
            return null;
        }
    }

    public boolean saveFlight(Flight flight) {
        
        final JSONObject flightJson = flight.toJson();
        
        JSONArray jsonArray = this.getAllFlights();
        
        if(jsonArray == null) {
            jsonArray = new JSONArray();
        }
        
        int index = -1;
        
        for (int i = 0; i < jsonArray.size(); i++) {
            
            final Object object = jsonArray.get(i);

            Flight tempFlight = new Flight();

            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            try {
                tempFlight = mapper.readValue(object.toString(), Flight.class);
            } catch (IOException ex) {
                continue;
            }
            
            if((flight.getId() == null ? tempFlight.getId() == null : flight.getId().equals(tempFlight.getId()))) {
                index = i;
            }
        }
        
        if(index != -1) {
            jsonArray.remove(index);
            jsonArray.add(flightJson);
        } else {
            jsonArray.add(flightJson);
        }

        try (FileWriter file = new FileWriter("flights.json")) {

            file.write(jsonArray.toString());
            file.flush();

        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    public DefaultListModel<Flight> getFlights() {        
        
        JSONArray flights = this.getAllFlights();
        
        if(flights == null) return null;
        
        DefaultListModel<Flight> flightsModels = new DefaultListModel<>();
        
        int counter = -1;
        for (Object flightJson : flights) {

            counter++;

            Flight flight = new Flight();
            
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            try {
                flight = mapper.readValue(flightJson.toString(), Flight.class);
            } catch (IOException ex) {
                continue;
            }
            
            flightsModels.add(counter, flight);
        }
        
        return flightsModels;
    }
}
