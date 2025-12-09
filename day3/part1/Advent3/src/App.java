import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTable.PrintMode;

import java.util.ArrayList;
import java.util.Collections;

enum PrgmState {
    BEGINSPLIT,
    MIDDLESPLIT,
    ENDSPLIT,
    NONE
}

public class App {

    static ArrayList<Integer> ConvertStringToArray(String str) {

        ArrayList<Integer> nums = new ArrayList<>();

        for (int ind = 0; ind < str.length(); ind++) {
            nums.add(Integer.parseInt(String.valueOf(str.charAt(ind))));
        }

        return nums;
    }

    public static void main(String[] args) throws Exception {
        
        File file = new File("src/input.txt");

        ArrayList<String> lineList = new ArrayList<>();

        PrgmState state = PrgmState.NONE;

        int total = 0;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lineList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
            
        } 

        

        for (String currentString : lineList) {
            
            ArrayList<Integer> numList = ConvertStringToArray(currentString);
            ArrayList<Integer> firstHalfList = new ArrayList<>(), secondHalfList = new ArrayList<>();
            state = PrgmState.NONE;
            
            int firstHighest = Collections.max(numList);

            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) == firstHighest && i == 0) {
                    firstHalfList = new ArrayList<>();
                    secondHalfList = new ArrayList<>(numList.subList(1, numList.size()));
                    state = PrgmState.ENDSPLIT;
                    break;
                }
                else if (numList.get(i) == firstHighest && i == numList.size() - 1) {
                    firstHalfList = new ArrayList<>(numList.subList(0, numList.size()-1));
                    secondHalfList = new ArrayList<>();
                    state = PrgmState.BEGINSPLIT;
                    break;
                }
                else if (numList.get(i) == firstHighest) {
                    firstHalfList = new ArrayList<>(numList.subList(0, i));
                    secondHalfList = new ArrayList<>(numList.subList(i+1, numList.size()));
                    state = PrgmState.MIDDLESPLIT;
                    break;
                }                
            }

            System.out.println("Current: " + currentString + " Split Lists: " + firstHalfList.toString() + " | " + secondHalfList.toString());
            
            if (state == PrgmState.BEGINSPLIT) {
                int highestNum = Collections.max(firstHalfList);
                total += highestNum * 10 + firstHighest;
            }
            else if (state == PrgmState.ENDSPLIT) {
                int highestNum = Collections.max(secondHalfList);
                total += firstHighest * 10 + highestNum;
                
            }
            else if (state == PrgmState.MIDDLESPLIT) {
                int c1 = Collections.max(firstHalfList) * 10 + firstHighest;
                int c2 = firstHighest * 10 + Collections.max(secondHalfList);
                System.out.println("c1: " + c1 + " c2: " + c2);
                if (c1 > c2) {
                    total += c1 ;
                }
                else if (c1 < c2) {
                    total += c2;
                }
                else if (c1 == c2) {
                    throw new ArrayIndexOutOfBoundsException("You fucked it");
                }
            }

        }

        System.out.println("------------------");
        System.out.println("Final Total: " + total);
        System.out.println("------------------");
        

    }
}
