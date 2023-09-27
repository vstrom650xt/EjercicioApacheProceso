package controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logica {
    public static Process executeProcess(JButton btn, String... command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(process.pid());
            return process;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static long showOutPut(Process process) {
        if (process.pid()== 0)
            return 0;

        return process.pid();

    }







}
