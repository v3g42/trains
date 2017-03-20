package com.vivekaditya.trains.test;

/**
 * Created by vivek on 19/3/17.
 */
public class TrainUtil {

    public static int mapCharacter(int c) {
        int  val = Character.getNumericValue(c) - Character.getNumericValue('A');
        return val;
    }

    public static int[] mapString(String r) {
        return r.trim().chars()
                .map(c -> mapCharacter(c))
                .toArray();
    }
}
