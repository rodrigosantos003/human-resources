/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.util.Scanner;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Leitor de Input
 * @author Rodrigo Santos & João Fernnandes
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

    public String getText(String question) {
        showFormattedQuestion(question);

        return scanner.nextLine();
    }
}
