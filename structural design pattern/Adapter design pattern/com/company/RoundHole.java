package com.company;

public class RoundHole {

    public double holeradius ;

    public RoundHole(){}

    public RoundHole(double radius){
        this.holeradius=radius;
    }

    public double getRadius(){
        return this.holeradius;
    }
    public boolean checkFit(RoundPeg peg){
        return this.holeradius >= peg.getRadius();

    }

}
