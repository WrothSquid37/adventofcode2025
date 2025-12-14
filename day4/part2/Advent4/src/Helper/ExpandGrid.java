package Helper;

import java.util.ArrayList;

public class ExpandGrid {

    private ArrayList<ArrayList<Character>> grid = new ArrayList<>();

    public int cols = 0, rows = 0;

    int[][] cps = { 
        {-1, 1}, {0, 1}, {1, 1},
        {-1, 0},         {1, 0},
        {-1,-1}, {0,-1}, {1,-1},
    };

    public ExpandGrid(ArrayList<String> gridStringInput) {

        for (String line : gridStringInput) {

            ArrayList<Character> charList = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {

                charList.add(line.charAt(i));

            }

            grid.add(charList);

        }

        cols = grid.get(0).size();
        rows = grid.size();

    }

    public Character getPos(int x, int y) {
        if (x > cols-1 || x < 0 || y > rows-1 || y < 0) return '?';
        return grid.get(y).get(x);
    }

    public void ModifyPos(int x, int y, char character) {
        grid.get(y).set(x, character);
    }   

    public void PrintOutGrid() {
        for (ArrayList<Character> l : grid) {
            for (Character c : l) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void PrintOutDimens() {
        System.out.println("Cols: " + cols + " Rows: " + rows);
    }

    public int countNeighbors(int x, int y, char requiredChar) {

        int count = 0;
        
        if (getPos(x, y) != requiredChar) return -1;

        for (int[] si : cps) {              
            if (getPos(x+si[0], y+si[1]) == '@' && getPos(x+si[0], y+si[1]) != '?') {
                count++;
            }
        }  

        return count;
    }

    public void CopyOverSelf(ExpandGrid tGrid) {
        grid = tGrid.grid;
    }
}
