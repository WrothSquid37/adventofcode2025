import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("src/input.txt");

        int clicks = 0;

        int currentClickedScaled = 0;

        ArrayList<String> lineList = new ArrayList<String>();

        // Read the file and then close the file
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
                lineList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        for (String s : lineList) {
            char operator = s.charAt(0);
            if (operator == 'L') {
                System.out.println(s.split("L"));
            }
            else if (operator == 'R') {

            }
        }


    
    }
}
