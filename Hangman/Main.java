//package dev.m3s.programming2.homework4;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        WordList wordlist = new WordList("words.txt");
        Hangman hangman = new Hangman(wordlist, 5);

        while(!hangman.theEnd() && hangman.guessesLeft() > 0){
            System.out.println("\nThe hidden word...");
            System.out.println(hangman.paljastasanoja());
            System.out.println("Guesses left: " + hangman.guessesLeft());
            System.out.println("Guessed letters: " + hangman.guesses().toString());
            System.out.println("Guess a letter: ");
            String arvaus = keyboard.next().toLowerCase();
            if (arvaus.length() == 1) {
                hangman.guess(arvaus.charAt(0));
            }
        }
        if (hangman.voitto() == true) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!\nThe word was: " + hangman.word());
        }
    }
}