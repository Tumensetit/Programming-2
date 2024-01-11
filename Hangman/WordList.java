//package dev.m3s.programming2.homework4;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordList {

    private List<String> sanat = new ArrayList<>();
    private List<String> muunnetutsanat = new ArrayList<>();

    public WordList(String name) {
        try {
            Files.lines(Paths.get(name), Charset.forName("UTF-8")).forEach(line -> sanat.add(line));
        } catch (IOException e) {
            System.out.println("virhe");
        }
    }
    

    public List<String> giveWords(){
        for (String word : sanat) {
            muunnetutsanat.add(word.toLowerCase());
        }
        return muunnetutsanat;
    }
}