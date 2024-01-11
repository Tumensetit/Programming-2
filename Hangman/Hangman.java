//package dev.m3s.programming2.homework4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    private Random rand = new Random();
    private int guessesLeft;
    private String word;
    private List<Character> guessess = new ArrayList<>();

    public Hangman(WordList wordList, int guesses) {
        this.guessesLeft = guesses;
        List<String> words = wordList.giveWords();
        word = words.get(rand.nextInt(words.size()));
    }
    
    public boolean guess(Character c){
        c = Character.toLowerCase(c);
        if(!guessess.contains(c)){
            guessess.add(c);
        }
        if (word.contains(Character.toString(c))){
            return true;
        } else {
            guessesLeft -= 1;
        }
        return false;
    }

    public List<Character> guesses(){
        return this.guessess;
    }

    public int guessesLeft(){
        return this.guessesLeft;
    }

    public String word(){
        return this.word;
    }

    public boolean theEnd(){
        if (guessesLeft() <= 0) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!guessess.contains(c)) {
                return false;
            }
        }       
        return true;
    }

    public boolean voitto(){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!guessess.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String paljastasanoja(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (guessess.contains(c)) {
                sb.append(this.word.charAt(i));
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }
}