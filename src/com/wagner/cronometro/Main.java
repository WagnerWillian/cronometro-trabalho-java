package com.wagner.cronometro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cronometro cronometro = new Cronometro();
        List<SessaoTrabalho> sessoes = new ArrayList<>();

        String nomeSessao = null;
        long tempoSessao;
        int option = -1;


        while (option != 0) {
            System.out.println("====CRONOMETRO====");
            System.out.println("=                =");
            System.out.println("= 1 - INICIAR    =");
            System.out.println("= 2 - PAUSAR     =");
            System.out.println("= 3 - RETOMAR    =");
            System.out.println("= 4 - ENCERRAR   =");
            System.out.println("= 0 - SAIR       =");
            System.out.println("=                =");
            System.out.println("==================");

            if (scanner.hasNextInt()) {

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        if (!cronometro.isSessaoAtiva()) {
                            nomeSessao = solicitarNomeSessao(scanner);
                            if (cronometro.iniciar()) {
                                System.out.println(nomeSessao + " iniciado.");
                            }
                        } else {
                            System.out.println("Sessão já iniciada! " + nomeSessao);

                        }

                    }
                    case 2 -> {
                        if (cronometro.pausar()) {
                            double segundo = converterSegundos(cronometro.getTempoTotal());
                            System.out.printf("Sessão pausada tempo decorrido:  %.2f\n", segundo);
                        } else if (!cronometro.isSessaoAtiva()) {
                            System.out.println("Sessão ainda não iniciada");
                        } else {
                            System.out.println("Sessão já pausada");
                        }
                    }
                    case 3 -> {
                        if (cronometro.retomar()) {
                            System.out.println("Sessão retomada");
                        } else if (!cronometro.isSessaoAtiva()) {
                            System.out.println("Não existe sessão ativa para retomar");
                        } else {
                            System.out.println("Sessão já em andamento!");
                        }
                    }
                    case 4 -> {
                        if (cronometro.encerrar()) {
                            tempoSessao = cronometro.getTempoTotal();
                            double segundo = converterSegundos(tempoSessao);
                            System.out.println("Encerrando a sessão\n");
                            sessoes.add(new SessaoTrabalho(nomeSessao, tempoSessao));
                            System.out.printf("Sessão %s encerrada tempo decorrido:  %.2f\n", nomeSessao, segundo);

                        } else {
                            System.out.println("Não existe sessão ativa para encerrar.");
                        }
                    }
                    case 0 -> {
                        if (cronometro.isSessaoAtiva()) {
                            int opt = -1;
                            while (opt != 0 && opt != 1) {
                                System.out.println("Sair sem salvar? 0 - Sim / 1 - Não");
                                if (scanner.hasNextInt()) {
                                    opt = scanner.nextInt();
                                    scanner.nextLine();
                                    if (opt == 1) {
                                        option = -1;
                                        System.out.println("Retornando ao menu!");
                                    } else if (opt == 0) {
                                        System.out.println("Saindo");
                                    } else {
                                        System.out.println("Opção invalida");
                                    }

                                } else {
                                    System.out.println("opção invalida digite somente números");
                                    scanner.nextLine();
                                }
                            }
                        } else {
                            System.out.println("Saindo");
                        }
                    }
                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            } else {
                System.out.println("Entrada inválida digite apenas numeros!");
                scanner.nextLine();
            }

        }
        sessoes.forEach(System.out::println);
        scanner.close();
    }

    private static String solicitarNomeSessao(Scanner scanner) {
        String nome;
        while (true) {
            System.out.println("Digite um nome para esta sessão:");
            nome = scanner.nextLine();

            if (nome.isBlank()) {
                System.out.println("Precisa conter informação no nome");
            } else {
                break;
            }
        }
        return nome;
    }

    private static double converterSegundos(long nanossegundos) {
        return nanossegundos / 1_000_000_000.0;
    }
}

