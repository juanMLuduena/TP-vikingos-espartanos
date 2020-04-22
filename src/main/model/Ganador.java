package main.model;

public class Ganador {
    private Integer idGanador;
    private String nombreGanador;
    private Integer bebidaEnCuerpo;

    public Ganador(Integer idGanador, String nombreGanador, Integer bebidaEnCuerpo) {
        this.idGanador = idGanador;
        this.nombreGanador = nombreGanador;
        this.bebidaEnCuerpo = bebidaEnCuerpo;
    }

    public Integer getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(Integer idGanador) {
        this.idGanador = idGanador;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }

    public Integer getBebidaEnCuerpo() {
        return bebidaEnCuerpo;
    }

    public void setBebidaEnCuerpo(Integer bebidaEnCuerpo) {
        this.bebidaEnCuerpo = bebidaEnCuerpo;
    }
}
