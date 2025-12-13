import java.util.ArrayList;

import Helper.ExpandGrid;
import FileHandler.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        int forkliftableRolls = 0;

        ArrayList<String> gridUnformatted = FileCustomReader.ReadFileToStringArrayList("src/input.txt");

        ExpandGrid mainGrid = new ExpandGrid(gridUnformatted);  
        ExpandGrid visualGrid = new ExpandGrid(gridUnformatted);    

        mainGrid.PrintOutGrid();

        for (int x = 0; x < mainGrid.cols; x++) {
            for (int y = 0; y < mainGrid.rows; y++) {
                int neighbors = 0;
                if (mainGrid.getPos(x, y) == '@') {
                    System.out.println(mainGrid.getPos(x, y));
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i != 0 && j != 0) {                               
                                try {
                                    if (mainGrid.getPos(x+i, y+j) == '@') {
                                        neighbors++;
                                    }
                                }
                                catch (NullPointerException e) {
                                    //System.out.println("Nonexistent point");
                                }   
                            }
                        }   
                    }
                }
                System.out.println("Neighbors: " + neighbors);
                if (neighbors < 4 && mainGrid.getPos(x, y) == '@') {
                    System.out.println("x: " + x + " y: " + y);
                    forkliftableRolls++;
                    visualGrid.ModifyPos(x, y, 'x');
                    visualGrid.PrintOutGrid();
                }
            }
        }
        System.out.println("Printing out grid...");
        visualGrid.PrintOutGrid();
        System.out.println("Liftable Rolls: " + forkliftableRolls);

        System.out.println("Grid at 0, 3: " + mainGrid.getPos(0, 3));
    }
}
