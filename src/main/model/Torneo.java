package main.model;

import main.dao.DaoGanadores;

import java.util.*;

public class Torneo {
    public List<Vikingo> teamVikingos;
    public List<Espartano> teamEspartanos;
    public Tabernero tabernero;
    public Integer cantPintasRonda;
    public Integer volumenPinta;

    public Torneo(List<Vikingo> teamVikingos, List<Espartano> teamEspartanos, Integer cantPintasRonda, Integer volumenPinta,Tabernero tabernero) {
        this.teamVikingos = teamVikingos;
        this.teamEspartanos = teamEspartanos;
        this.cantPintasRonda = cantPintasRonda;
        this.volumenPinta = volumenPinta;
        this.tabernero=tabernero;
    }

    public List<Vikingo> getTeamVikingos() {
        return teamVikingos;
    }

    public void setTeamVikingos(List<Vikingo> teamVikingos) {
        this.teamVikingos = teamVikingos;
    }

    public List<Espartano> getTeamEspartanos() {
        return teamEspartanos;
    }

    public void setTeamEspartanos(List<Espartano> teamEspartanos) {
        this.teamEspartanos = teamEspartanos;
    }

    public Integer getCantPintasRonda() {
        return cantPintasRonda;
    }

    public void setCantPintasRonda(Integer cantPintasRonda) {
        this.cantPintasRonda = cantPintasRonda;
    }

    public Integer getVolumenPinta() {
        return volumenPinta;
    }

    public void setVolumenPinta(Integer volumenPinta) {
        this.volumenPinta = volumenPinta;
    }

    public void iniciarTorneo() {
        Humano perdedor = new Humano();
        Humano ganador = new Humano();

        List<Vikingo> copiaTV = teamVikingos;
        List<Espartano> copiaTE = teamEspartanos;
        int contador = 0;
        this.mostrarEquipos();
        Vikingo vikingoActual = elegirCombatientesVikingo(copiaTV);
        Espartano espartanoActual = elegirCombatientesEspartano(copiaTE);

        while (vikingoActual != null && espartanoActual != null) {
            perdedor = this.combatir(vikingoActual, espartanoActual);

            if (perdedor instanceof Vikingo) {
                System.out.println(vikingoActual.getNombre()+" perdio, "+espartanoActual.getNombre()+" prevalecio.");
                copiaTV.remove(vikingoActual);
            } else {
                System.out.println(espartanoActual.getNombre()+" perdio, "+vikingoActual.getNombre()+" prevalecio.");
                copiaTE.remove(espartanoActual);
            }
            vikingoActual = elegirCombatientesVikingo(copiaTV);
            espartanoActual = elegirCombatientesEspartano(copiaTE);
        }
        if(copiaTV.isEmpty()){
            System.out.println("GANARON LOS ESPARTANOS");
            ganador= (Humano) this.elegirCombatientesEspartano(copiaTE);
        }
        if(copiaTE.isEmpty()){
            System.out.println("GANARON LOS VIKINGOS");
            ganador = (Humano) this.elegirCombatientesVikingo(copiaTV);
        }

        System.out.println("RONDA FINAL CONTRA EL TABERNERO");
        perdedor = this.combatir(ganador,tabernero);

        if(perdedor.equals(ganador)){
            ganador=tabernero;
        }

        System.out.println(ganador.getNombre()+" es el glorioso campeon del torneo de pintas!!");
        DaoGanadores dao = new DaoGanadores();
        dao.agregarGanador(ganador);
    }

    public void ordenarEquiposEdad() {
        Collections.sort(this.teamEspartanos);
        Collections.sort(this.teamVikingos);
    }

    public void mostrarEquipos() {

        this.ordenarEquiposEdad();
        System.out.println("TEAM VIKINGOS:");
        for (Vikingo v : teamVikingos) {

            System.out.println(v.toString());

        }
        System.out.println("TEAM ESPARTANOS:");
        for (Espartano e : teamEspartanos) {

            System.out.println(e.toString());

        }
    }

    //TODO Estoy seguro que esta funcion TIENE que ser generica, tener 2 funciones que solo devuelven un elemento de un arreglo esta mal teoricamente, preguntar despues
    public Humano elegirCombatientes(List<Humano> tv) {
        int size = tv.size();
        if (size > 0) {
            Random r = new Random(System.currentTimeMillis());
            return tv.get(r.nextInt(size));
        } else return null;
    }


    public Vikingo elegirCombatientesVikingo(List<Vikingo> tv) {
        int size = tv.size();
        if (size > 0) {
            Random r = new Random(System.currentTimeMillis());
            return tv.get(r.nextInt(size));
        } else return null;
    }

    public Espartano elegirCombatientesEspartano(List<Espartano> te) {
        int size = te.size();
        if (size > 0) {
            Random r = new Random(System.currentTimeMillis());
            return te.get(r.nextInt(size));
        } else return null;
    }


    //devuelve el perdedor porque asi me es mas facil despues sacarlo del array de equipo
    public Humano combatir(Humano h1, Humano h2) {

        System.out.println(h1.getNombre() + " se enfrenta a: "+h2.getNombre());
        Integer pintas = this.cantPintasRonda;
        Integer pintasH1 = 0;
        Integer pintasH2 = 0;
        Integer aux = 0;

        //mientras todavia queden píntas en la ronda y ninguno haya orinado
        while (pintas > 0 && (!h1.isOrino() && !h2.isOrino())) {

            aux = h1.beber();
            pintas -= aux;
            pintasH1 += aux;
            h1.orinar();

            if (pintas > 0) {
                aux = h2.beber();
                pintas -= aux;
                pintasH2 += aux;
                h2.orinar();
            }
        }
        //TODO emprolijar esta funcion
        //Aca algo me esta haciendo ruido, se que hay una forma de que solo haya 2 returns pero no me di cuenta todavia
        if (h1.isOrino()) {
            return  h1;
        }
        if (h2.isOrino()) {
            return  h2;
        }
        if (pintasH2 >= pintasH1) {
            return h1;
        } else return  h1;
    }

}