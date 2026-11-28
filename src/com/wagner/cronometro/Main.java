package com.wagner.cronometro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.StructureViolationException;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cronometro cronometro = new Cronometro();
        List<SessaoTrabalho> sessoes = new ArrayList<>();

        String nomeSessao = null;
        int option = -1;


        while (option != 0) {
            exibirMenu();

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
                            System.out.println("Sessão já iniciada!" + nomeSessao);

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
                            var tempoSessao = cronometro.getTempoTotal();
                            double segundo = converterSegundos(tempoSessao);
                            System.out.println("Encerrando a sessão\n");
                            sessoes.add(new SessaoTrabalho(nomeSessao, tempoSessao));
                            System.out.printf("Sessão %s encerrada tempo decorrido:  %.2f\n", nomeSessao, segundo);

                        } else {
                            System.out.println("Não existe sessão ativa para encerrar.");
                        }
                    }
                    case 5 -> {
                        mostrarHistorico(sessoes);
                    }
                    case 0 -> {
                        if (!(encerramentoPrograma(scanner, cronometro))) {
                            option = -1;
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
        mostrarHistorico(sessoes);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("====CRONOMETRO====");
        System.out.println("=                =");
        System.out.println("= 1 - INICIAR    =");
        System.out.println("= 2 - PAUSAR     =");
        System.out.println("= 3 - RETOMAR    =");
        System.out.println("= 4 - ENCERRAR   =");
        System.out.println("= 5 - HISTÓRICO  =");
        System.out.println("= 0 - SAIR       =");
        System.out.println("=                =");
        System.out.println("==================");
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

    private static void mostrarHistorico(List<SessaoTrabalho> sessoes) {
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão registrada.");
        } else {
            System.out.println("===============Histórico===============");
            for (SessaoTrabalho sessao : sessoes) {
                System.out.printf("  %-10.10s        Tempo:%10.2fs  \n", sessao.nome(), converterSegundos(sessao.tempoNanos()));
            }
            System.out.println("=======================================");
        }
    }

    private static double converterSegundos(long nanossegundos) {
        return nanossegundos / 1_000_000_000.0;
    }

    private static boolean encerramentoPrograma(Scanner scanner, Cronometro cronometro) {
        if (cronometro.isSessaoAtiva()) {
            int opt;
            while (true) {
                System.out.println("Sair sem salvar? 0 - Sim / 1 - Não");
                if (scanner.hasNextInt()) {
                    opt = scanner.nextInt();
                    scanner.nextLine();
                    if (opt == 1) {
                        System.out.println("Retornando ao menu!");
                        return false;
                    } else if (opt == 0) {
                        System.out.println("Saindo");
                        return true;
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
            return true;

        }

    }

}

