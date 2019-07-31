/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

import static batalhanaval.Jogo.marGuerra2;
import java.util.Iterator;

/**
 *
 * @author Maria Clara
 */
public class JogadorHumano {

    private double dinheiro;
    private boolean errou;

    public boolean isErrou() {
        return errou;
    }

    public void setErrou(boolean errou) {
        this.errou = errou;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Object darTiro(Coordenada c) {
        if (marGuerra2[c.getLinha()][c.getColuna()] == null) {
            System.out.println("SO TEM MAR!");
            return null;
        }
        for (Iterator iterator = marGuerra2[c.getLinha()][c.getColuna()].iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            if (next instanceof Navio) {
                dinheiro += ((Navio) next).getValorParte();
                System.out.println("EXISTE NAVIO");
                return (Navio) next;
            } else {
                break;
            }

        }
        return null;
    }

    public void marcarNavio(Navio n, Coordenada c) {
        if ("Horizontal".equals(n.getPosicionamento())) {
            for (int i = 0; i < n.getPartes().length; i++) {
                if (n.getCoord().getColuna() + i == c.getColuna()) {
                    n.getPartes()[i] = true;
                }
            }
        } else if ("Vertical".equals(n.getPosicionamento())) {
            for (int i = 0; i < n.getPartes().length; i++) {
                if (n.getCoord().getLinha() + i == c.getLinha()) {
                    n.getPartes()[i] = true;
                }
            }
        }

    }

}
