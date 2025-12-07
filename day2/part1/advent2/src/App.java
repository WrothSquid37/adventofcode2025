import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        long count = 0;

        File file = new File("src/input.txt");

        String entireTextString = "";

        // Read the file and then close the file (try-with-resources)
        try (Scanner reader = new Scanner(file)) {
            entireTextString = reader.next();      
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }

        String[] rangeStr = entireTextString.split(",");
        for (String unit : rangeStr) {

            String[] indivdualNums = unit.split("-");

            long firstnum = Long.parseLong(indivdualNums[0]);
            long lastnum = Long.parseLong(indivdualNums[1]);

            for (long i = firstnum; i < lastnum; i++) {
                
                int midpoint = Long.toString(i).length() / 2;

                String firstHalf = Long.toString(i).substring(0, midpoint);
                String lastHalf = Long.toString(i).substring(midpoint, Long.toString(i).length());

                // System.out.print("First Half: " + firstHalf + " Last Half: " + lastHalf);
                // System.out.println(" Current Num: " + i);

                if (firstHalf.equals(lastHalf)) {
                    count += i;
                }

            }

        }

        System.out.println(count);

    }
}
