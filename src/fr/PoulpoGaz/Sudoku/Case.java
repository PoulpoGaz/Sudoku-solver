package fr.PoulpoGaz.Sudoku;

public class Case {

    private Block[][] blocks = new Block[3][3];

    public Case(Block[][] b) {
        blocks = b;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               if(blocks[i][j].getValue() != 0) {
                   str += blocks[i][j].toString() + "|";
               } else {
                   str += "X|";
               }
            }
            str += "\n";
        }
        return str;
    }
}
