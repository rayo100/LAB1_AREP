/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.arep.lab1;

/**
 *
 * @author cv100
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

    private static final String userAgent = "Mozilla/5.0";
    private static String urlGetUrl = "http://www.omdbapi.com/?t=";
    private static final String urlApiKey = "&apikey=b63096b1";

    /**
     * Method that obtains the String of the information of the movie
     * @param title
     * @return title of the movie
     * @throws IOException class exception
     */
    public static String requestTitle(String title) throws IOException {
        //Cache
        Seeker seeker = Seeker.getInstance();
        if(seeker.wasSearched(title)){
            System.out.println("Se uso el cache");
            return seeker.getMovieDescription(title);
        }
        //Connection Api Cinema
        String urlComplete = urlGetUrl + title + urlApiKey;
        URL obj = new URL(urlComplete);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", userAgent);
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String resp = "[" + response.toString() + "]" ;
            seeker.addMovie(title, resp);
            return resp;
        } else {
            System.out.println("GET request not worked");
        }
        return "Failed";
    }

}
     
