package agh.cs.project1;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JsonFileReader {
    //private JSONParser jsonParser = new JSONParser();

    public String readJsonFile(String fileName){

        try (FileReader reader = new FileReader("employees.json"))
        {
            //Read JSON file
            //Object obj = jsonParser.parse(reader);

            //JSONArray employeeList = (JSONArray) obj;
            //System.out.println(employeeList);

            //Iterate over employee array
            //employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException ex) {
            System.out.println(ex);;
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ParseException e) {
            e.printStackTrace();
        }*/

        return null;
    }

}
