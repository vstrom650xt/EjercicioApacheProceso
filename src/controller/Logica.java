package controller;

import java.io.IOException;

public class Logica {


    public static  void startApache(){
        String []command = new String[]{"service", "apache2", "start"};
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void stopApache(){
        String []command = new String[]{"service", "apache2", "start"};
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static  void startSQL(){
        String []command = new String[]{"service", "mariadb", "stop"};
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static  void stopSQL(){
        String []command = new String[]{"service", "mariadb", "stop"};
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
