package com.sensetime.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RuntimeUtil {

    public static void runCmdline(String command) {
        try {
            Runtime rt = Runtime.getRuntime();
            BufferedReader input = null;
            Process pr = null;

            pr = rt.exec(command);
            input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception e) {

            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
