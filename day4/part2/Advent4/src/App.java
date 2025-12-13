import java.util.ArrayList;

import Helper.ExpandGrid;
import FileHandler.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        int forkliftableRolls = 0;

        ArrayList<String> gridUnformatted = FileCustomReader.ReadFileToStringArrayList("src/input.txt");

        ExpandGrid mainGrid = new ExpandGrid(gridUnformatted);  
        ExpandGrid visualGrid = new ExpandGrid(gridUnformatted);    

        int[][] cps = { 
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0},         {1, 0},
            {-1,-1}, {0,-1}, {1,-1},
        };

        for (int y = 0; y < mainGrid.rows; y++) {
            for (int x = 0; x < mainGrid.cols; x++) {
                int nCount = 0;
                if (mainGrid.getPos(x, y) == '@') {
                    for (int[] si : cps) {
                        
                        if (mainGrid.getPos(x+si[0], y+si[1]) == '@' && mainGrid.getPos(x+si[0], y+si[1]) != '?') {
                            nCount++;
                        }
                    }
                    if (nCount < 4) {
                        forkliftableRolls++;
                    }
                }
            }
        }
        
        System.out.println(forkliftableRolls);
        
    }
}
