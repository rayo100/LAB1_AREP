/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import edu.escuelaing.app.arep.lab1.*;
import java.io.IOException;

/**
 *
 * @author cv100
 */

public class ConcurrentTest extends Thread{

    private final String title;
    private String response;

    public ConcurrentTest(String title){
        super();
        this.title = title;
    }

    @Override
    public void run(){
        try {
            response = HttpConnection.requestTitle(title);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle(){
        return title;
    }
   
    public String getResponse(){
        return response;
    }

}
