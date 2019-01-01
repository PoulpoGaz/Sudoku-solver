package fr.PoulpoGaz.Sudoku;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Series {

    private Block[] blocks = new Block[9];
    private Sudoku sudoku;

    public Series(Block[] b, Sudoku s) {
        blocks = b;
        sudoku = s;
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

    public void removePossibilities() {
        ArrayList<Integer> value = new ArrayList<Integer>();
        for(int x = 0; x < 9; x++) {
            if(blocks[x].hasNoPossibility()) {
                value.add(blocks[x].getValue());
                sudoku.addStep();
            }
        }
        for(int x = 0; x < 9; x++) {
            if(!blocks[x].hasNoPossibility()) {
                for(Integer v:value) {
                    blocks[x].remove(v);
                    sudoku.addStep();
                }
            }
            blocks[x].update();
        }
    }

    public boolean checkConstraint() {
        ArrayList<Integer> check = new ArrayList<Integer>();
        for(int x = 0; x < 9; x++) {
            if(blocks[x].hasNoPossibility()) {
                check.add(blocks[x].getValue());
            }
        }
        Set set = new TreeSet();
        set.addAll(check);
        if(check.size() != set.size()) {
            return true;
        }

        return false;
    }
}
