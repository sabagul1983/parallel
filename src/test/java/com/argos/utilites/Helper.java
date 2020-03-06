package com.argos.utilites;

import java.util.Random;

public class Helper {

    public int generateRandomNumber(int size){
        return new Random().nextInt(size-1);
    }
}
