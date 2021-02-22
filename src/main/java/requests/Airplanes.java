package requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import models.Airplane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Airplanes {

    private JSONArray getAllAirplanes() {
        
        try {
            
            JSONArray airplanes = new JSONArray();
            
            final JSONParser parser = new JSONParser();
            
            airplanes = (JSONArray) parser.parse(new FileReader("airplanes.json"));
            
            return airplanes;
        } catch (IOException | ParseException ex) {
            return null;
        }
    }

    public boolean saveAirplane(Airplane airplane) {
        
        final JSONObject airplaneJson = airplane.toJson();
        
        JSONArray jsonArray = this.getAllAirplanes();
        
        if(jsonArray == null) {
            jsonArray = new JSONArray();
        }
        
        int index = -1;
        
        for (int i = 0; i < jsonArray.size(); i++) {
            
            final Object object = jsonArray.get(i);

            Airplane tempAirplane = new Airplane();

            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            try {
                tempAirplane = mapper.readValue(object.toString(), Airplane.class);
            } catch (IOException ex) {
                continue;
            }
            
            if((airplane.getId() == null ? tempAirplane.getId() == null : airplane.getId().equals(tempAirplane.getId()))) {
                index = i;
            }
        }
        
        if(index != -1) {
            jsonArray.remove(index);
            jsonArray.add(airplaneJson);
        } else {
            jsonArray.add(airplaneJson);
        }

        try (FileWriter file = new FileWriter("airplanes.json")) {

            file.write(jsonArray.toString());
            file.flush();

        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    public DefaultListModel<Airplane> getAirplanes() {        
        
        JSONArray airplanes = this.getAllAirplanes();
        
        if(airplanes == null) return null;
        
        DefaultListModel<Airplane> airplanesModels = new DefaultListModel<>();
        
        int counter = -1;
        for (Object airplaneJson : airplanes) {

            counter++;

            Airplane airplane = new Airplane();
            
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            try {
                airplane = mapper.readValue(airplaneJson.toString(), Airplane.class);
            } catch (IOException ex) {
                continue;
            }
            
            airplanesModels.add(counter, airplane);
        }
        
        return airplanesModels;
    }
}
