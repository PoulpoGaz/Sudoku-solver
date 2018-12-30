package fr.PoulpoGaz.Sudoku;

import java.util.ArrayList;

public class Case {

    private Block[][] blocks = new Block[3][3];
    private Sudoku sudoku;

    public Case(Block[][] b, Sudoku s) {
        blocks = b;
        sudoku = s;
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

    public void removePossibilities() {
        ArrayList<Integer> value = new ArrayList<Integer>();
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(blocks[x][y].hasNoPossibility()) {
                    value.add(blocks[x][y].getValue());
                    sudoku.addStep();
                }
            }
        }
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(!blocks[x][y].hasNoPossibility()) {
                    for(Integer v:value) {
                        blocks[x][y].remove(v);
                        sudoku.addStep();
                    }
                }
                blocks[x][y].update();
            }
        }
    }
}
