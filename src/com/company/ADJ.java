package com.company;

public class ADJ {
    double N;
    public ADJ(double N){
        this.N=N;
        if(N<0){
            N=N-1;
        }
    }
}
