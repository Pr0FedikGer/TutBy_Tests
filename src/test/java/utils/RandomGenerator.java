package utils;

import entities.Genres;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
    public static String getRandomGenre(){
        int index = new Random().nextInt(Genres.values().length);
        return Genres.values()[index].getValue();
    }
}
