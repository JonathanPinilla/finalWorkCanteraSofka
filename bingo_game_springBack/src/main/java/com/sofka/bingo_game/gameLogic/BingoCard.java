package com.sofka.bingo_game.gameLogic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that instantiates a bingo card, its properties and behavior
 * @version 1.0.0 2022-07-06
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
@Data
public class BingoCard {
    private List<Integer> b = new ArrayList<>();
    private List<Integer> i = new ArrayList<>();
    private List<Integer> n = new ArrayList<>();
    private List<Integer> g = new ArrayList<>();
    private List<Integer> o = new ArrayList<>();

    /**
     * Bingo card constructor, instantiates a bingo card
     */
    public BingoCard() {
        for(int i = 0; i < 5; i++){
            this.b = getRandomNonRepeatingIntegers(5,1,15);
            this.i = getRandomNonRepeatingIntegers(5,16,30);
            this.n = getRandomNonRepeatingIntegers(5,31,45);
            this.g = getRandomNonRepeatingIntegers(5,46,60);
            this.o = getRandomNonRepeatingIntegers(5,61,75);
        }
    }

    /**
     * Generate a random int
     * @param min random value
     * @param max random value
     * @return integer random number
     */
    private static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Verifies if the random number is already in the list if so, don't add the number,
     * if it doesn't is in the list then add it to the list
     * @param size of the random list
     * @param min random value
     * @param max random value
     * @return list with random numbers without duplicates
     */
    private static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                                   int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }
}
