package main.model;

import main.interfaces.IBeber;
import main.interfaces.IOrinar;


public class Humano implements Comparable<Humano> {


    private String nombre;
    private Integer peso;
    private Integer edad;
    private Integer vejiga;
    private boolean orino;
    private IBeber strategyBeber;
    private IOrinar strategyOrinar;

    public Humano() {
    }

    public Humano(String nombre, Integer peso, Integer edad) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.vejiga = 0;
        this.orino = false;
    }

    public Humano(String nombre, Integer peso, Integer edad, IBeber strategyBeber, IOrinar strategyOrinar) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.vejiga = 0;
        this.strategyBeber = strategyBeber;
        this.strategyOrinar = strategyOrinar;
    }

    public Humano(String nombre, Integer peso, Integer edad, Integer vejiga, boolean orino, IBeber strategyBeber, IOrinar strategyOrinar) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.vejiga = vejiga;
        this.orino = orino;
        this.strategyBeber = strategyBeber;
        this.strategyOrinar = strategyOrinar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getVejiga() {
        return vejiga;
    }

    public void setVejiga(Integer vejiga) {
        this.vejiga = vejiga;
    }

    public boolean isOrino() {
        return orino;
    }

    public void setOrino(boolean orino) {
        this.orino = orino;
    }

    public int getEspecialBeber(){
        return 0;
    }
    public int getEspecialOrinar(){
        return 0;
    }

    public IBeber getStrategyBeber() {
        return strategyBeber;
    }

    public void setStrategyBeber(IBeber strategyBeber) {
        this.strategyBeber = strategyBeber;
    }

    public IOrinar getStrategyOrinar() {
        return strategyOrinar;
    }

    public void setStrategyOrinar(IOrinar strategyOrinar) {
        this.strategyOrinar = strategyOrinar;
    }

    public int beber() {

        return this.strategyBeber.beber(getEspecialOrinar());

    }

    public boolean orinar() {

        return strategyOrinar.orinar(this.vejiga, getEspecialOrinar());
    }

    /*
    Devuelve 1 si el valor de la clase es mayor al recibido, 0 si son iguales, -1 si es menor, -2 en caso de error
     */
    public int compareTo(Humano h) {

        if (this.edad > h.edad)
            return 1;
        if (this.edad == h.edad)
            return 0;
        else
            return -1;
    }

    public String toString(){
        return "Nombre: "+ this.nombre +  "  Edad: " + this.edad + "  Peso:" + this.edad;
    }
}
