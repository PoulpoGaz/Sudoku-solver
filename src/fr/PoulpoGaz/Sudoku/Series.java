package fr.PoulpoGaz.Sudoku;

public class Series {

    private Block[] blocks = new Block[9];

    public Series(Block[] b) {
        blocks = b;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < 9; i++) {
            if(blocks[i].getValue() != 0) {
                str += blocks[i].toString() + "|";
            } else {
                str += "X|";
            }
        }
        str += "\n";
        return str;
    }
}
