package controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logica {
    public static Process executeProcess(JButton btn, String... command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            return process;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public static int getPid(String processName) throws IOException, InterruptedException {

        // Busca el PID del proceso usando pgrep o pidof
        ProcessBuilder processBuilder = new ProcessBuilder("pgrep", processName);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        process.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = reader.readLine();
        if (line != null && !line.isEmpty()) {
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;  // El proceso no está en ejecución o no se encontró
    }

}
