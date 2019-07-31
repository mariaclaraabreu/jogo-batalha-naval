/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

/**
 *
 * @author Maria Clara
 */


public class Navio {

    private int qtdPartes = 4;
    private final boolean partes[] = new boolean[qtdPartes];
    private String posicionamento;
    private int valorParte=100;
    Coordenada coord;
    private String marcador = "-- ";

    public String getMarcador() {
        return marcador;
    }
    
    
    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public int getValorParte() {
        return valorParte;
    }

    public void setValorParte(int valorParte) {
        this.valorParte = valorParte;
    }

    
    public boolean[] getPartes() {
        return partes;
    }

    public int getQtdPartes() {
        return qtdPartes;
    }

    public void setQtdPartes(int qtdPartes) {
        this.qtdPartes = qtdPartes;
    }

    public String getPosicionamento() {
        return posicionamento;
    }

    public void setPosicionamento(String posicionamento) {
        this.posicionamento = posicionamento;
    }

  
    public Navio() {
    }

}
