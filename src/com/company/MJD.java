package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MJD {
    int day, month, year, hour, min;
    double sec;
    PrintWriter output, output1, output2, output3;

    public MJD(int day, int month, int year, int hour, int min, double sec, PrintWriter output, PrintWriter output1, PrintWriter output2, PrintWriter output3) throws IOException {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.output = output;
        this.output1 = output1;
        this.output2 = output2;
        this.output3 = output3;

        int A, B, C, D, M1, MJ, MJDFMDATE;

        if (month < 3) {
            year = year - 1;
            M1 = month + 12;
        } else {
            M1 = month;
        }
        A = Math.abs(year / 100);
        B = 2 - A + Math.abs(A / 4);
        C = (int) (Math.abs(365.25 * year) - 694025);
        D = (int) Math.abs(30.6001 * (M1 + 1));
        MJ = B + C + D + day + 15019;
        MJDFMDATE = Math.abs(MJ);


        double partOfDay = (hour / 24.0) + (min / 24.0 / 60.0) + (sec / 24.0 / 60.0 / 60.0);
        double MJDdateWhour = MJDFMDATE + partOfDay;

        output.append(String.format("%.6f",MJDdateWhour).replace(",","."));
        output1.append(String.format("%.6f",MJDdateWhour).replace(",","."));
        output2.append(String.format("%.6f",MJDdateWhour).replace(",","."));
        output3.append(String.format("%.6f",MJDdateWhour).replace(",","."));

    }
}