package com.company;

import java.security.PublicKey;

public class SquarePegAdapter extends RoundPeg{

    private SquarePeg Squarepeg;

    public SquarePegAdapter(){
        super();
    }

    public SquarePegAdapter(SquarePeg s){
        this.Squarepeg=s;
    }

    public double getradius(){
        return Squarepeg.getSide() * Math.sqrt(2) / 2;
    }









}
