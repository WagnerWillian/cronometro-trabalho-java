package com.wagner.cronometro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cronometro cronometro = new Cronometro();
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

                switch (option) {
                    case 1 -> {
                        if (cronometro.iniciar()) {
                            System.out.println("Iniciando");
                        } else {
                            System.out.println("Sessão já iniciada");
                        }
                    }
                    case 2 -> {
                        if (cronometro.pausar()) {
                            double segundo = converterSegundos(cronometro.getTempoTotal());
                            System.out.printf("Sessão pausada tempo decorrido:  %.2f\n", segundo);
                        } else {
                            System.out.println("Sessão já pausada");
                        }
                    }
                    case 3 -> {
                        if (cronometro.retomar()) {
                            System.out.println("Sessão retomada");
                        } else {
                            System.out.println("Não é possivel retomar");
                        }
                    }
                    case 4 -> {
                        if (cronometro.encerrar()) {
                            double segundo = converterSegundos(cronometro.getTempoTotal());
                            System.out.println("Encerrando a sessão\n");
                            System.out.printf("Sessão encerrada tempo decorrido:  %.2f\n", segundo);
                        } else {
                            System.out.println("Programa encerrado sem sessão");
                        }
                    }
                    case 0 -> {

                        System.out.println("Saindo");
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

        scanner.close();
    }

    private static double converterSegundos(long nanossegundos) {
        return nanossegundos / 1_000_000_000.0;
    }
}
