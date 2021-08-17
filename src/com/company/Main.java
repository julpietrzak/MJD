package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int day, m, y;
        int h, min;
        double sec;

        File in = new File("C:/Users/Julia Pietrzak/IdeaProjects/MJD/src/com/company/wynikaos6d.txt");
        System.out.println(in.exists());
        Scanner scan = new Scanner(in);
        String[] dane;

        File out = new File("MJD_GPS.txt");
       PrintWriter output = new PrintWriter(out);

        File out1 = new File("MJD_GALILEO.txt");
        PrintWriter output1 = new PrintWriter(out1);

        File out2 = new File("MJD_GLONASS.txt");
        PrintWriter output2 = new PrintWriter(out2);

        File out3 = new File("MJD_BEIDOU.txt");
        PrintWriter output3 = new PrintWriter(out3);
        while (scan.hasNextLine()) {
            String linia = scan.nextLine();
            dane = linia.split(" ");
            String date = dane[0];
            String[] date1 = date.split("-");
            y = Integer.parseInt(date1[0]) + 2000;
            m = Integer.parseInt(date1[1]);
            day = Integer.parseInt(date1[2]);

            String hour = dane[1];
            String[] time = hour.split(":");
            h = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);
            sec = Double.parseDouble(time[2]);


            MJD MJ = new MJD(day, m, y, h, min, sec, output,output1,output2,output3);
            output.append(" " + dane[2] + "\n");
            output1.append(" " + dane[3] + "\n");
            output2.append(" " + dane[4] + "\n");
            output3.append(" " + dane[6] + "\n");



        }
        output.close();
        output1.close();
        output2.close();
        output3.close();


    }
}
