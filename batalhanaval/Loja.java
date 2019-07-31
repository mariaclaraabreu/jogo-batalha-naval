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
public class Loja {
    private Aviao aviao;
    private Mina mina;

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Mina getMina() {
        return mina;
    }

    public void setMina(Mina mina) {
        this.mina = mina;
    }
    
    public boolean comprarMina(JogadorHumano jog, Mina m){
        return jog.getDinheiro()>= m.getPreco();
    }
    
    
}
