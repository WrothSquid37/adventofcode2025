package Helper;

import java.util.ArrayList;

public class ExpandGrid {

    private ArrayList<ArrayList<Character>> grid = new ArrayList<>();

    public int cols = 0, rows = 0;

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
        if (x > cols-1 || x < 0 || y > rows-1 || y < 0) return null;
        return grid.get(x).get(y);
    }

    public void ModifyPos(int x, int y, char character) {
        grid.get(x).set(y, character);
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

}
