package com.epam.factsAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class FactsAPI {

	String res;
    public String fetchFacts() {
        try {

            URL url = null;
            try {
                url = new URL("https://api.aakhilv.me/fun/facts");
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                conn.setRequestMethod("GET");
            } catch (ProtocolException ex) {
                ex.printStackTrace();
            }
            try {
                conn.connect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //Getting the response code
            int responsecode = 0;
            try {
                responsecode = conn.getResponseCode();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = null;
                try {
                    scanner = new Scanner(url.openStream());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                JSONArray obj = new JSONArray();
                obj.add(inline);
                //Get the required data using its key
                 res= (String) (obj.get(0));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return res;
    }

}
