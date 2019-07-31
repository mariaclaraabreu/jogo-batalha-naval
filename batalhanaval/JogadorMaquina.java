/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

import static batalhanaval.Jogo.marGuerra;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Maria Clara
 */
public class JogadorMaquina extends JogadorHumano {

    private double dinheiro;
    private boolean errou;
    Random rd = new Random();

    @Override
    public boolean isErrou() {
        return errou;
    }

    @Override
    public void setErrou(boolean errou) {
        this.errou = errou;
    }

    @Override
    public double getDinheiro() {
        return dinheiro;
    }

    @Override
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }


    
    public Coordenada gerarCoordenada() {
        int x;
        int y;
        Coordenada c = new Coordenada();

        c.setLinha(x = rd.nextInt(20));
        c.setColuna(y = rd.nextInt(20));
        return c;

    }
    

    
    public String gerarPosicionamento(){
        int pos = rd.nextInt(3);
        if(pos%2==0){
            return "Vertical";
        }
        return "Horizontal";
    }
    @Override
    public Object darTiro(Coordenada c) {
        if (marGuerra[c.getLinha()][c.getColuna()] == null) {
            System.out.println("SO TEM MAR!");
            return null;
        }

        for (Iterator iterator = marGuerra[c.getLinha()][c.getColuna()].iterator(); iterator.hasNext();) {
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

    @Override
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
