import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class App {

    static ArrayList<String> get_every_nth_chunk (String s, int n) {

        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < s.length(); i += n) {
            int endIndex = Math.min(s.length(), i+n);
            tempList.add(s.substring(i, endIndex));
        }

        return tempList;

    }

    static boolean check_if_nth_duplicates (ArrayList<String> strs) {

        HashSet<String> set = new HashSet<>();

        for (String ivs : strs) {

            set.add(ivs);

        }

        return set.size() == 1;

    }

    public static void main(String[] args) throws Exception {
        
        long count = 0;
        boolean foundTwo = false;

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
                
                String numStr = Long.toString(i);

                for (int c = 1; c <= numStr.length()/2; c++) {

                    ArrayList<String> splitStrings = get_every_nth_chunk(numStr, c);
 
                    if (check_if_nth_duplicates(splitStrings)) {
                        count += i;
                        break;
                    }

                }

            }

        }

        System.out.println(count);

    }
}
