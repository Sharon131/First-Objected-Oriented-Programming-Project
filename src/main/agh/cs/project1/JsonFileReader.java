package agh.cs.project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {
    private JSONParser jsonParser = new JSONParser();

    public long mapWidth;
    public long mapHeight;
    public long startEnergy;
    public long moveEnergy;
    public long plantEnergy;
    public long jungleWidth;
    public long jungleHeight;

    public String readJsonFile(String fileName){

        try (FileReader reader = new FileReader(fileName))
        {
            Object object = jsonParser.parse(reader);

            JSONObject parameters = (JSONObject) object;
            System.out.println(parameters);

            this.mapWidth = (Long) parameters.get("width");
            this.mapHeight = (Long) parameters.get("height");
            this.startEnergy = (Long) parameters.get("startEnergy");
            this.moveEnergy = (Long) parameters.get("moveEnergy");
            this.plantEnergy = (Long) parameters.get("plantEnergy");
            double jungleRatio = (Double) parameters.get("jungleRatio");

            System.out.println(mapWidth);
            System.out.println(mapHeight);
            System.out.println(startEnergy);
            System.out.println(moveEnergy);
            System.out.println(plantEnergy);
            System.out.println(jungleRatio);

        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    private void computeJungleSize(double jungleRatio){
        jungleHeight = (long) (mapHeight*jungleRatio);
        jungleWidth = (long) (mapWidth*jungleRatio);
    }

}
