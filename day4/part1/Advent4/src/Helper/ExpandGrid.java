package Helper;

import java.util.ArrayList;

public class ExpandGrid {

    private ArrayList<ArrayList<Character>> grid = new ArrayList<>();

    public ExpandGrid(ArrayList<String> gridStringInput) {

        for (String line : gridStringInput) {

            ArrayList<Character> charList = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {

                charList.add(line.charAt(i));

            }

            grid.add(charList);

        }

    }

    public Character getPos(int x, int y) {
        return grid.get(y).get(x);
    }

}
