package src.week22;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JSONExample {
    public static void main(String[] args) {

        JSONArray array = null;
        try(FileReader obIn = new FileReader("files/jsonData.json")) {

            JSONParser parser = new JSONParser();
            array = (JSONArray) parser.parse(obIn);
            Iterator<JSONObject> dataIterator = array.iterator();

            JSONObject object = dataIterator.next();

//            String value = (String) object.get("key");
//            System.out.printf("key : %s\n", value);

            double value = (double) object.get("key");
            System.out.printf("key : %f\n", value);

            JSONArray jsonArray = (JSONArray) object.get("array");

            JSONObject subObject = (JSONObject) jsonArray.iterator().next();

            String subValue = (String) subObject.get("aVal");
            System.out.printf("aVal : %s\n", subValue);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        JSONObject obj = new JSONObject();
        obj.put("key","value");
        array.add(obj);

        Iterator<JSONObject> iterator = array.iterator();

        try(FileWriter obOut = new FileWriter("files/jsonData.json")) {
            obOut.write(array.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
