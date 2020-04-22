package main.model;

import main.interfaces.implementacion.BeberVikingoImp;
import main.interfaces.implementacion.OrinarVikingoImp;

public class Vikingo extends Humano{

    // % de tomarse 2 pintas a la vez y que solo 1 le sume a la vejiga
    private Integer bebedorProfesional;


    public Vikingo(String nombre, Integer peso, Integer edad, Integer bebedorProfesional) {
        super(nombre, peso, edad,new BeberVikingoImp(),new OrinarVikingoImp());
        this.bebedorProfesional = bebedorProfesional;
    }


    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public int beber(){
        setVejiga(getVejiga() + 10);
        System.out.println("ODIN ME HA BENDECIDO CON ESTA CERVECITA FRESCA");
        return super.beber();
    }

    public boolean orinar(){
        if( super.orinar()){
            setVejiga(0);
            setOrino(true);
            System.out.println("YO, "+super.getNombre()+" tuve que mear. DEMONIOS");
            return true;
        }
        else return false;
    }

    public String toString(){

        return super.toString() + "  Bebedor nivel: "+ bebedorProfesional;
    }

    public int getEspecialBeber(){
        return bebedorProfesional;
    }
    public int getEspecialOrinar(){
        return 0;
    }

}
