/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

import java.util.Random;

/**
 *
 * @author Maria Clara
 */
public class Aviao {

    private Coordenada coord;
    private final double preco = 500;
    private final int tamanho = 4;
    private String posicionamento;
    Random rd = new Random();

    public Coordenada gerarCoordenadaAviao() {
        int x;
        int y;
        Coordenada c = new Coordenada();
        c.setLinha(x = rd.nextInt(20));
        c.setColuna(y = rd.nextInt(20));
        return c;

    }

    public String gerarPosicionamentoAviao() {
        int pos = rd.nextInt(3);
        if (pos % 2 == 0) {
            return "Vertical";
        }
        return "Horizontal";
    }

    public String getPosicionamento() {
        return posicionamento;
    }

    public void setPosicionamento(String posicionamento) {
        this.posicionamento = posicionamento;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

}
