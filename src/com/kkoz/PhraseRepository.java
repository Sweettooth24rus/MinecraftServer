package com.kkoz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class PhraseRepository {
    private static List<String> phrases;
    private static final Random rand = new Random();

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("phrases.txt"))) {
            phrases = List.copyOf(reader.lines().toList());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getPhrase() {
        return phrases.get(rand.nextInt(phrases.size()));
    }
}
