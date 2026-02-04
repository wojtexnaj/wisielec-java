package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    private List<String> words = List.of("kot", "pies", "programowanie", "javascript");
    String word;
    char[] userWord;
    int lives = 3;
    Boolean startedGame = false;

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        word = words.get(random.nextInt(words.size()));
        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');
        
        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println(!startedGame? "Podaj pierwszą literkę: ": "Podaj kolejną literę: ");
            System.out.println("Pozostał żyć: " + lives);
            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
            if (!startedGame) {
                startedGame = true;
            }
        }

        if (lives == 0) {
            System.out.println("Niestety przegrałeś!");
        } else {
            System.out.println("Gratulacje wygrałeś!");
        }

        scanner.close();
    }

    private void checkLetter(char letter) {
        if (!Character.isLetter(letter)) {
            System.out.println("To nie jest litera!");
            lives --;
        } else {
            Boolean foundLetter = false;
            for (int i=0; i<word.length(); i++) {
                if (word.charAt(i) == letter) {
                    userWord[i] = letter;
                    foundLetter = true;

                }
            }

            if (!foundLetter) {
                System.out.println("Niestety nie ma takiej litery!");
                lives --;
            }
        }

    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }

}

