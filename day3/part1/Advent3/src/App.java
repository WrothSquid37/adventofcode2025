import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    static int[] ConvertStringToArray(String str) {

        int[] nums = new int[str.length()];

        for (int ind = 0; ind < str.length(); ind++) {
            nums[ind] = Integer.parseInt(String.valueOf(str.charAt(ind)));
        }

        return nums;
    }

    public static void main(String[] args) throws Exception {
        
        File file = new File("src/input.txt");

        ArrayList<String> lineList = new ArrayList<>();

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
            
            int[] parsedNums = ConvertStringToArray(currentString);
            int firstHighest, secondHighest, firstHighestIndex, secondHighestIndex, endOfHighest;
            
            firstHighest = -1;
            secondHighest = -1;
            
            firstHighestIndex = -1;
            secondHighestIndex= -1;

            for (int i = 0; i < parsedNums.length; i++) {
                if (firstHighest < parsedNums[i]) {
                    firstHighest = parsedNums[i];
                    firstHighestIndex = i;
                }
            }
            //Check for edge case of where the higheset is in the end of the array
            System.out.println(firstHighestIndex+1 + " : " + parsedNums.length);
            if (firstHighestIndex+1 == parsedNums.length) {
                for (int j = 0; j < parsedNums.length-1; j++) {
                    for (int i = 1; i < 10; i++) {
                        if (parsedNums[j] == ) {
                            firstHighest = parsedNums[j];
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < parsedNums.length; i++) {
                if (secondHighest < parsedNums[i] && i != firstHighestIndex) {
                    secondHighest = parsedNums[i];
                    secondHighestIndex = i;
                }
            }
            // if () {

            // }

            

            System.out.println(firstHighest + " : " + secondHighest);
            
            int calcNum = firstHighest * 10 + secondHighest;

            System.out.println("Calculated Num: " + calcNum);

            total += calcNum;

        }

        System.out.println(total);

    }
}
