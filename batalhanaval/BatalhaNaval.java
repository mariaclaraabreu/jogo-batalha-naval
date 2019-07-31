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
import java.util.Scanner;

public class BatalhaNaval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        Jogo jogo = new Jogo();
        Loja loja = new Loja();
        JogadorHumano jog1 = new JogadorHumano();
        JogadorMaquina jog2 = new JogadorMaquina();
        jogo.imprimirMar(1);

        System.out.println("*********************************************************************");
        System.out.println("*********************************************************************");
        System.out.println("***************************BATALHA NAVAL*****************************");
        System.out.println("*********************************************************************");
        System.out.println("*********************************************************************");
        System.out.println("[1] INICIAR");
        int iniciar = sc.nextInt();
        if (iniciar == 1) {
            while (jogo.getQtdNaviosMar1() < jogo.getQtdMaxNaviosMar1()) {
                System.out.println("INSERIR NAVIO MAR JOGADOR");
                Navio navio = new Navio();
                System.out.println("DÊ AS COORDENADAS:");
                Coordenada cN = new Coordenada();
                System.out.print("LINHA: ");
                cN.setLinha(sc.nextInt() - 1);
                System.out.print("COLUNA: ");
                cN.setColuna(sc.nextInt() - 1);
                navio.setCoord(cN);
                System.out.print("POSICIONAMENTO(Vertical/Horizontal):");
                navio.setPosicionamento(sc.next());
                jogo.InserirNavio(navio, 1);
                jogo.imprimirMar(1);
            }
            while (jogo.getQtdNaviosMar2() < jogo.getQtdMaxNaviosMar2()) {
                System.out.println("INSERIR NAVIO MAR MAQUINA");
                Navio navio2 = new Navio();
                navio2.setCoord(jog2.gerarCoordenada());
                navio2.setPosicionamento(jog2.gerarPosicionamento());
                jogo.InserirNavio(navio2, 2);
                jogo.imprimirMar(2);
            }

            System.out.println("MAR JOGADOR");
            jogo.imprimirMar(1);
            System.out.println("MAR MAQUINA");
            jogo.imprimirMar(2);

            System.out.println("[1] JOGAR");
            System.out.println("[2] SAIR");
            int jogar = sc.nextInt();
            if (jogar == 1) {
                do {

                    
                    System.out.println("[1] COMPRAR MINA");
                    System.out.println("[2] DAR TIRO");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            Mina mina = new Mina();
                            boolean confereDin = loja.comprarMina(jog1, mina);
                            if(confereDin != false){
                            
                            System.out.println("DÊ AS COORDENADAS:");
                            Coordenada cM = new Coordenada();
                            System.out.print("LINHA: ");
                            cM.setLinha(sc.nextInt() - 1);
                            System.out.println("COLUNA: ");
                            cM.setColuna(sc.nextInt() - 1);
                            mina.setCoord(cM);
                            jogo.inserirMina(mina, 1);
                            jogo.imprimirMar(1);
                            }else{
                                System.out.println("DINHEIRO INSUFICIENTE");
                            }
                            break;

                        case 2:
                            //FAZER A ESCOLHA DE JOGADOR AQUI
                            //while jog1.errous!=true
                            int continuar;
                            System.out.println("[1] START");
                            continuar=sc.nextInt();
                            while (continuar == 1) {
                                System.out.print("JOGADOR 1:");
                                int jogador = 1;
                                jog1.setErrou(false);
                                jog2.setErrou(false);
                                if (jogador == 1) {
                                    while (jog1.isErrou() != true) {
                                        Coordenada cT = new Coordenada();
                                        System.out.println("LINHA: ");
                                        cT.setLinha(sc.nextInt() - 1);
                                        System.out.println("COLUNA: ");
                                        cT.setColuna(sc.nextInt() - 1);
                                        Object verificarObjeto = jog1.darTiro(cT);
                                        if (verificarObjeto instanceof Navio) {
                                            Navio nav = (Navio) verificarObjeto;
                                            jog1.marcarNavio(nav, cT);
                                            jogo.imprimirMar(2);
                                        } else {
                                            jog1.setErrou(true);
                                        }
                                    }
                                    System.out.println("DINHEIRO ATUAL JOGADOR 1: " + jog1.getDinheiro());
                                    jogo.imprimirMar(2);
                                    System.out.println("JOGADOR 2:");
                                    jogador = 2;
                                }
                                if (jogador == 2) {
                                    while (jog2.isErrou() != true) {
                                        System.out.println("MAQUINA JOGANDO");
                                        Coordenada cTM = jog2.gerarCoordenada();
                                        Object verificarObjeto = jog2.darTiro(cTM);
                                        if (verificarObjeto instanceof Navio) {
                                            Navio nav = (Navio) verificarObjeto;
                                            jog2.marcarNavio(nav, cTM);
                                            jogo.imprimirMar(1);
                                        } else {
                                            jog2.setErrou(true);
                                        }
                                    }
                                    System.out.println("DINHEIRO ATUAL JOGADOR 2: " + jog2.getDinheiro());
                                    jogo.imprimirMar(1);
                                    jogador = 1;

                                }
                               System.out.println("[1] para continuar...");
                               System.out.println("[2] para opções...");
                               continuar=sc.nextInt();
                               break;
                            }
                        }
                    }
                    while (escolha != 5);
                }
            
            }

        }

    }
