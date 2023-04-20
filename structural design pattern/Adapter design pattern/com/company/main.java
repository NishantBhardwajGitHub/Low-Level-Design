package com.company;

public class main {

    public static void main(String[] args) {

        RoundHole hole = new RoundHole(5);
        RoundPeg rp = new RoundPeg(5);


        System.out.println("fits : " + hole.checkFit(rp));


        SquarePeg sq1 = new SquarePeg(5);
        SquarePeg sq2 = new SquarePeg(10);

        RoundPeg adapter1 = new SquarePegAdapter(sq1);
        RoundPeg adapter2 = new SquarePegAdapter(sq2);

        System.out.println("fits : " + hole.checkFit(adapter1));
        System.out.println("fits : " + hole.checkFit(adapter2));






    }
}
