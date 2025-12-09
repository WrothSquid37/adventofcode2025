import java.util.List;

import helper.utils;

import static helper.utils.*;

public class App {
    public static void main(String[] args) throws Exception {

        

        long partOneAnswer = 0;
        for (String batteries : batteriesList) {
            partOneAnswer += getLargestCombination(batteries, 2);
        }
    }
}
