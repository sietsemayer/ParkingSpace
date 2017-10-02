package nl.estate.parking.amsterdam.temp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class CallUrl {

    // https://data.amsterdam.nl/#?dte=catalogus%2Fapi%2F3%2Faction%2Fpackage_show%3Fid%3D42e270c2-c19d-45c7-a8c7-061633b6bc38&dtfs=T&mpb=topografie&mpz=11&mpv=52.3731081:4.8932945

    public static void main(String[] args) throws JSONException {
        String Callurl = "http://opd.it-t.nl/data/amsterdam/ParkingLocation.json";
        // for(int i = 0; i < 200000; i++){
        StringBuilder sb = new StringBuilder();
        URLConnection urlConnection = null;
        InputStreamReader inputStreamReader = null;

        try {
            URL url = new URL(Callurl);
            urlConnection = url.openConnection();
            if (urlConnection != null)
                urlConnection.setReadTimeout(60 * 1000);
            if (urlConnection != null && urlConnection.getInputStream() != null) {
                inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char)cp);
                    }

                    bufferedReader.close();
                }
            }
            inputStreamReader.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + Callurl, e);
        }
        String JsonOut = sb.toString();
//        System.out.println(sb);
//        Parser.JsonParser(JsonOut);
//        WriteToFile.write(JsonOut);
//        sleep();
//        Split.split(JsonOut, sb);
        JSONObject jsonObj = new JSONObject(sb.toString());
        
        
        
        
  
    }

    // }
    private static void sleep() {
        // try{
        // Thread.sleep(300000);
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        //

    }

}
