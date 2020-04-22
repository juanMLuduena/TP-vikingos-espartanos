package main.model;

import main.interfaces.IBeber;
import main.interfaces.IOrinar;
import main.interfaces.implementacion.BeberEspartanoImp;
import main.interfaces.implementacion.OrinarEspartanoImp;

public class Espartano extends Humano{

    // menos chances de mear 0-100 %
    private Integer toleranciaExtra;

    public Espartano(String nombre, Integer peso, Integer edad, Integer toleranciaExtra) {
        super(nombre, peso, edad,new BeberEspartanoImp(),new OrinarEspartanoImp());
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    public int beber(){
        setVejiga(getVejiga() + 10);
        System.out.println("Dioses, denme fuerza para seguir con esta lucha");
        return super.beber();
    }

    public boolean orinar(){
        if (super.orinar()){
            setVejiga(0);
            setOrino(true);
            System.out.println("Perdi, no me mires asi, yo no queria luchar, yo solo queria ser panadero");
            return true;
        }
        else return false;
    }

    public String toString(){

        return super.toString() + "  Nivel de tolerancia: "+toleranciaExtra;
    }

    public int getEspecialBeber(){
        return 0;
    }
    public int getEspecialOrinar(){
        return toleranciaExtra;
    }

}
