package main.model;

import main.interfaces.implementacion.BeberVikingoImp;
import main.interfaces.implementacion.OrinarEspartanoImp;

public class Tabernero extends Humano{

    private Integer toleranciaExtra;
    private Integer bebedorProfesional;

    public Tabernero(String nombre, Integer peso, Integer edad,Integer toleranciaExtra, Integer bebedorProfesional) {
        super(nombre, peso, edad,new BeberVikingoImp(),new OrinarEspartanoImp());
        this.bebedorProfesional = bebedorProfesional;
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public int beber(){
        setVejiga(getVejiga() + 10);
        System.out.println("Estoy es muy facil chango, traigan otra pinta");
        return super.beber();
    }

    public boolean orinar(){
        if (super.orinar()){
            setVejiga(0);
            setOrino(true);
            System.out.println("Ay ay ay, esto es una masacre");
            return true;
        }
        else return false;
    }

    public int getEspecialBeber(){
        return bebedorProfesional;
    }
    public int getEspecialOrinar(){
        return toleranciaExtra;
    }


}
