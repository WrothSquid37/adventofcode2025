package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileCustomReader {

    public static ArrayList<String> ReadFileToStringArrayList(String filePath) {

        ArrayList<String> lines = new ArrayList<>();

        File file = new File(filePath);

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }

        return lines;
    }

}
