import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;


public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("src/input.txt");

        String unparsedNumber;
        int parsedNum = 0;

        int rotation = 50;

        int click = 0;

        int total = 0;

        ArrayList<String> lineList = new ArrayList<String>();

        // Read the file and then close the file
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lineList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }


        
        for (String s : lineList) {
            char operator = s.charAt(0);
            unparsedNumber = s.substring(1);
            parsedNum = Integer.parseInt(unparsedNumber);
            if (operator == 'L') {
                rotation -= parsedNum;
                click = click % 100;
            }
            else if (operator == 'R') {
                rotation += parsedNum;
                click = click % 100;
            }
            System.out.println(Math.floor(parsedNum / 100));
            total += Math.floor(parsedNum / 100);
            if (click == 0) {
                total++;
            }
        }

        System.out.println(total);


    
    }
}
