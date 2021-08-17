package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MJDtoDATE {
    public static void main(String[] args) throws FileNotFoundException {

        File out = new File("date_GPS.txt");
        PrintWriter output = new PrintWriter(out);

        File in = new File("C:/Users/Julia Pietrzak/IdeaProjects/MJD/MJD_GPS.txt");
        System.out.println(in.exists());
        Scanner scan = new Scanner(in);
        String[] dane;
        while (scan.hasNextLine()) {
            String linia = scan.nextLine();
            dane = linia.split(" ");
          double  MJD = Double.parseDouble(dane[0]);


            MJD2DATE date = new MJD2DATE(MJD, output);
            output.append(" " + dane[1] + "\n");

        }
        output.close();
    }
}


