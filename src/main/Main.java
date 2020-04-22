package main;

import main.model.Espartano;
import main.model.Tabernero;
import main.model.Torneo;
import main.model.Vikingo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    System.out.println("HOLA MUNDO");

        Espartano e0 = new Espartano("Leonidas",85,25,10);
        Espartano e1 = new Espartano("Dilios",90,27,10);
        Espartano e2 = new Espartano("Theron",70,30,0);
        Espartano e3 = new Espartano("Stelios",100,35,15);
        Espartano e4 = new Espartano("Artemis",60,20,5);

        Vikingo v0 = new Vikingo("Ragnar",80,38,15);
        Vikingo v1 = new Vikingo("Rollo",85,35,20);
        Vikingo v2 = new Vikingo("Floki",65,37,35);
        Vikingo v3 = new Vikingo("Bjorn",95,18,5);
        Vikingo v4 = new Vikingo("Bodoque",120,30,50);

        List<Espartano> teamEsp = new ArrayList<>();
        List<Vikingo> teamVik= new ArrayList<>();
        teamEsp.add(e0);
        teamEsp.add(e1);
        teamEsp.add(e2);
        teamEsp.add(e3);
        teamEsp.add(e4);

        teamVik.add(v0);
        teamVik.add(v1);
        teamVik.add(v2);
        teamVik.add(v3);
        teamVik.add(v4);

        Tabernero t0 = new Tabernero("Bianca",50,21,24,25);


        Torneo torneo= new Torneo(teamVik,teamEsp,25,1,t0);

       torneo.iniciarTorneo();



    }
}
