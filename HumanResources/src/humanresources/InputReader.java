/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.util.Scanner;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Leitor de
 * Input
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class InputReader {

    private Scanner scanner;

    /**
     * Construtor da classe InputReader
     */
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    private void showFormattedQuestion(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
    }

    /**
     * Leitura de um númeor real
     * @param question Texto a colocar no ecrã
     * @return Valor introduzido
     */
    public double getRealNumber(String question) {
        showFormattedQuestion(question);

        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            showFormattedQuestion(question);
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    /**
     * Leitura de um númeor inteiro
     * @param question Texto a colocar no ecrã
     * @return Valor introduzido
     */
    public int getIntegerNumber(String question) {
        showFormattedQuestion(question);

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            showFormattedQuestion(question);
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    /**
     * Leitura de um texto
     * @param question Texto a colocar no ecrã
     * @return Texto introduzido
     */
    public String getText(String question) {
        showFormattedQuestion(question);

        return scanner.nextLine();
    }
}
