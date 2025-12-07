import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        File file = new File("src/input.txt");

        ArrayList<String> lineList = new ArrayList<>();

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lineList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
            
        } 

        

    }
}
