package agh.cs.project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {
    private JSONParser jsonParser = new JSONParser();

    public String readJsonFile(String fileName){

        try (FileReader reader = new FileReader(fileName))
        {
            Object object = jsonParser.parse(reader);

            JSONObject parameters = (JSONObject) object;
            System.out.println(parameters);

            System.out.println(parameters.get("width"));
            System.out.println(parameters.get("height"));
            System.out.println(parameters.get("startEnergy"));
            System.out.println(parameters.get("moveEnergy"));
            System.out.println(parameters.get("plantEnergy"));
            System.out.println(parameters.get("jungleRatio"));

        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        return null;
    }

}
