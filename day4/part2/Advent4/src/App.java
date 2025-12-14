import java.util.ArrayList;
import java.util.Scanner;

import Helper.ExpandGrid;
import FileHandler.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        int forkliftableRolls = 0;

        Scanner input = new Scanner(System.in);

        ArrayList<String> gridUnformatted = FileCustomReader.ReadFileToStringArrayList("src/input.txt");

        ExpandGrid nextGrid = new ExpandGrid(gridUnformatted);
        ExpandGrid mainGrid = new ExpandGrid(gridUnformatted);  

        boolean state = true;

        int amountRemoved = -1, total = 0;
    
        
        while (amountRemoved != 0) {
            amountRemoved = 0;
            for (int y = 0; y < mainGrid.rows; y++) {
                for (int x = 0; x < mainGrid.cols; x++) {
                    if (mainGrid.countNeighbors(x, y, '@') < 4) {
                        nextGrid.ModifyPos(x, y, '.');
                        total += 1;
                        amountRemoved += 1;
                    }
                }
            }

            System.out.println(amountRemoved);
            mainGrid.CopyOverSelf(nextGrid);

            System.out.println("--------Main Grid Pre.-----------");
            mainGrid.PrintOutGrid();
            System.out.println("--------Next Grid Pre------------");
            nextGrid.PrintOutGrid();
            System.out.println("-------------END-----------------");

            input.nextLine();
        }
        
        System.out.println(total);
        
    }
}
