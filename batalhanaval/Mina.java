/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

/**
 *
 * @author Maria Clara
 */
public class Mina {
    private boolean explodida;
    private Coordenada coord;
    private final double preco = 200;
    private String marcador = "***";
    
    
    public Mina(){}

    public double getPreco() {
        return preco;
    }

    public String getMarcador() {
        return marcador;
    }
    

    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }
    
 

   
    public boolean isExplodida() {
        return explodida;
    }

    public void setExplodida(boolean explodida) {
        this.explodida = explodida;
    }
    
    
    
    
}
