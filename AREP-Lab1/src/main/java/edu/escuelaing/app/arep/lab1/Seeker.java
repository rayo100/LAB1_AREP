/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.arep.lab1;

/**
 *
 * @author cv100
 */
import java.util.concurrent.ConcurrentHashMap;

public class Seeker {

    private static Seeker instance;
    private static ConcurrentHashMap<String, String> seeker;

    /**
     * Constructor Class
     */
    public Seeker(){
        seeker = new ConcurrentHashMap<String, String>();
    }

    /**
     * True if the movie was searhed, false otherwise
     * @param title title of the movie
     * @return Boolean
     */
    public boolean wasSearched(String title){
        return seeker.containsKey(title);
    }

    /**
     * Add movie to list
     * @param title title of the movie
     * @param json movie information
     */
    public void addMovie(String title, String json){
        seeker.put(title, json);
    }

    /**
     * Description of the movie
     * @param title title of the movie
     * @return String movie information
     */
    public String getMovieDescription(String title){
        return seeker.get(title);
    }

    /**
     * Searched movies list size
     * @return int list size
     */
    public int size(){
        return seeker.size();
    }

    /**
     * Clean list movies
     */
    public void clear(){
        seeker.clear();
    }
    
    /**
     * Initializer class
     * @return instance class
     */
    public static Seeker getInstance() {
        if(instance == null){
            instance = new Seeker();
        }
        return instance;
    }
}
