/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package batalhanaval;

import Exceptions.EspacoIndisponivelException;
import Exceptions.EspacoInsuficienteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria Clara
 */
public class Jogo {

    private int qtdNaviosMar1;
    private static int qtdNaviosMar2;
    private int qtdMaxNaviosMar1 = 4;
    private int qtdMaxNaviosMar2 = 4;
    public static ArrayList marGuerra[][] = new ArrayList[20][20];
    public static ArrayList marGuerra2[][] = new ArrayList[20][20];

    public int getQtdMaxNaviosMar1() {
        return qtdMaxNaviosMar1;
    }

    public void setQtdMaxNaviosMar1(int qtdMaxNaviosMar1) {
        this.qtdMaxNaviosMar1 = qtdMaxNaviosMar1;
    }

    public int getQtdMaxNaviosMar2() {
        return qtdMaxNaviosMar2;
    }

    public void setQtdMaxNaviosMar2(int qtdMaxNaviosMar2) {
        this.qtdMaxNaviosMar2 = qtdMaxNaviosMar2;
    }

    public int getQtdNaviosMar1() {
        return qtdNaviosMar1;
    }

    public void setQtdNaviosMar1(int qtdNaviosMar1) {
        this.qtdNaviosMar1 = qtdNaviosMar1;
    }

    public int getQtdNaviosMar2() {
        return qtdNaviosMar2;
    }

    public void setQtdNaviosMar2(int qtdNaviosMar2) {
        this.qtdNaviosMar2 = qtdNaviosMar2;
    }

    public static ArrayList[][] getMarGuerra() {
        return marGuerra;
    }

    public static void setMarGuerra(ArrayList[][] marGuerra) {
        Jogo.marGuerra = marGuerra;
    }

    public static ArrayList[][] getMarGuerra2() {
        return marGuerra2;
    }

    public static void setMarGuerra2(ArrayList[][] marGuerra2) {
        Jogo.marGuerra2 = marGuerra2;
    }

    public void InserirNavio(Navio n, int escolhaMar) {
        if ("Vertical".equals(n.getPosicionamento())) {
            try {
                InserirNavioVertical(n, escolhaMar);
            } catch (EspacoIndisponivelException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EspacoInsuficienteException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Horizontal".equals(n.getPosicionamento())) {
            try {
                InserirNavioHorizontal(n, escolhaMar);
            } catch (EspacoIndisponivelException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EspacoInsuficienteException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void InserirNavioVertical(Navio n, int escolhaMar) throws EspacoIndisponivelException, EspacoInsuficienteException {
        if (escolhaMar == 1) {
            boolean verificar = verificarEspacoVertical(n, escolhaMar);
            if (verificar != false) {
                for (int i = 0; i < n.getQtdPartes(); i++) {
                    if (marGuerra[n.getCoord().getLinha() + i][n.getCoord().getColuna()] == null) {
                        marGuerra[n.getCoord().getLinha() + i][n.getCoord().getColuna()] = new ArrayList();
                    } else {

                        throw new EspacoIndisponivelException("ESPAÇO JA OCUPADO");
                    }
                    marGuerra[n.getCoord().getLinha() + i][n.getCoord().getColuna()].add(n);

                }

            } else {
                throw new EspacoInsuficienteException("NAVIO NAO INSERIDO. NAO CABE!");
            }
            qtdNaviosMar1++;

        } else if (escolhaMar == 2) {
            boolean verificar = verificarEspacoVertical(n, escolhaMar);
            if (verificar != false) {
                for (int i = 0; i < n.getQtdPartes(); i++) {
                    if (marGuerra2[n.getCoord().getLinha() + i][n.getCoord().getColuna()] == null) {
                        marGuerra2[n.getCoord().getLinha() + i][n.getCoord().getColuna()] = new ArrayList();
                    } else {

                        throw new EspacoIndisponivelException("ESPAÇO JA OCUPADO");
                    }
                    marGuerra2[n.getCoord().getLinha() + i][n.getCoord().getColuna()].add(n);

                }

            } else {
                throw new EspacoInsuficienteException("NAVIO NAO INSERIDO. NAO CABE!");
            }
            qtdNaviosMar2++;

        }

    }

    public void InserirNavioHorizontal(Navio n, int escolhaMar) throws EspacoIndisponivelException, EspacoInsuficienteException {
        if (escolhaMar == 1) {
            boolean verificar = verificarEspacoHorizontal(n, escolhaMar);
            if (verificar != false) {
                for (int i = 0; i < n.getQtdPartes(); i++) {
                    if (marGuerra[n.getCoord().getLinha()][n.getCoord().getColuna() + i] == null) {
                        marGuerra[n.getCoord().getLinha()][n.getCoord().getColuna() + i] = new ArrayList();
                    } else {

                        throw new EspacoIndisponivelException("ESPAÇO JA OCUPADO");

                    }
                    marGuerra[n.getCoord().getLinha()][n.getCoord().getColuna() + i].add(n);
                }
            } else {
                throw new EspacoInsuficienteException("NAVIO NAO INSERIDO. NAO CABE!");
            }
            qtdNaviosMar1++;
        } else if (escolhaMar == 2) {
            boolean verificar = verificarEspacoHorizontal(n, escolhaMar);
            if (verificar != false) {
                for (int i = 0; i < n.getQtdPartes(); i++) {
                    if (marGuerra2[n.getCoord().getLinha()][n.getCoord().getColuna() + i] == null) {
                        marGuerra2[n.getCoord().getLinha()][n.getCoord().getColuna() + i] = new ArrayList();
                    } else {

                        throw new EspacoIndisponivelException("ESPAÇO JA OCUPADO");
                    }
                    marGuerra2[n.getCoord().getLinha()][n.getCoord().getColuna() + i].add(n);
                }
            } else {
                throw new EspacoInsuficienteException("NAVIO NAO INSERIDO. NAO CABE!");
            }
            qtdNaviosMar2++;
        }

    }

    public boolean verificarEspacoVertical(Navio n, int escolha) {
        if ("Vertical".equals(n.getPosicionamento())) {
            if (escolha == 1) {
                if (n.getCoord().getLinha() + (n.getQtdPartes() - 1) < marGuerra.length) {
                    return true;
                }
            } else if (escolha == 2) {
                if (n.getCoord().getLinha() + (n.getQtdPartes() - 1) < marGuerra2.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarEspacoHorizontal(Navio n, int escolha) {
        if ("Horizontal".equals(n.getPosicionamento())) {
            if (escolha == 1) {
                if (n.getCoord().getColuna() + (n.getQtdPartes() - 1) < marGuerra.length) {
                    return true;
                }
            } else if (escolha == 2) {
                if (n.getCoord().getColuna() + (n.getQtdPartes() - 1) < marGuerra2.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public void inserirMina(Mina m, int escolhaMar) {
        if (escolhaMar == 1) {
            if (marGuerra[m.getCoord().getLinha()][m.getCoord().getColuna()] == null) {
                marGuerra[m.getCoord().getLinha()][m.getCoord().getColuna()] = new ArrayList();
            }
            marGuerra[m.getCoord().getLinha()][m.getCoord().getColuna()].add(m);
        } else if (escolhaMar == 2) {
            if (marGuerra2[m.getCoord().getLinha()][m.getCoord().getColuna()] == null) {
                marGuerra2[m.getCoord().getLinha()][m.getCoord().getColuna()] = new ArrayList();
            }
            marGuerra2[m.getCoord().getLinha()][m.getCoord().getColuna()].add(m);
        }
    }

    public void lancarAviao(Aviao av, int escolhaMar) {
        
    }

    public void imprimirMar(int escolha) {
        Mar mar = new Mar();
        if (escolha == 1) {
            for (int i = 0; i < marGuerra.length; i++) {
                for (int j = 0; j < marGuerra[i].length; j++) {
                    if (marGuerra[i][j] != null) {
                        for (Iterator iterator = marGuerra[i][j].iterator(); iterator.hasNext();) {
                            Object next = iterator.next();
                            if (next instanceof Navio) {
                                System.out.print(((Navio) next).getMarcador() + " ");
                            } else if (next instanceof Mina) {
                                System.out.println(((Mina) next).getMarcador() + " ");
                            }
                        }
                    } else {
                        System.out.print(mar.getMarcador() + " ");
                    }
                }
                System.out.println(" ");
            }
        } else if (escolha == 2) {
            for (int i = 0; i < marGuerra2.length; i++) {
                for (int j = 0; j < marGuerra2[i].length; j++) {
                    if (marGuerra2[i][j] != null) {
                     
                        for (Iterator iterator = marGuerra2[i][j].iterator(); iterator.hasNext();) {
                            Object next = iterator.next();
                            if (next instanceof Navio) {
                                System.out.print(((Navio) next).getMarcador() + " ");
                            } else if (next instanceof Mina) {
                                System.out.println(((Mina) next).getMarcador() + " ");
                            }
                        }
                    } else {
                        System.out.print(mar.getMarcador() + " ");
                    }
                }
                System.out.println(" ");
            }
        }

    }
}
