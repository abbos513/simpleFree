package com.freelance.dal.Utils;

import java.util.Random;

public class RandonString {

                             //ABCDEFGHIJKLMNOP
                             // QRSTUVWXYZ
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                                     'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
                                     'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                                     'v', 'w', 'x', 'y', 'z'};

    public RandonString(){};

    private char getRandomCharaters(){
        return letters[random(letters.length)];
    }

    private int random(int length){
        return new Random().nextInt(length);
    }

    public String randonString(){
        boolean running = true;
        int count = 0;
        int max = 5;
        StringBuilder sb = new StringBuilder();

        while (running){
            int size  = 10;
            for (int i = 0; i<size; i++){
                sb.append(getRandomCharaters());
            }
            if(count++ == max){
                running = false;
            }
        }

        return sb.toString();
    }
}
