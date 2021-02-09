package utils;

import entities.Genres;

import java.util.Random;

public class RandomGenre {
    public String chooseRandomGenre(){
        int index = new Random().nextInt(Genres.values().length);
        return Genres.values()[index].getValue();
    }
}
