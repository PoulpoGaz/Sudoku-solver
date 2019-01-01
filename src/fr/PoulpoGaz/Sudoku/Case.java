package fr.PoulpoGaz.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Case extends JPanel{

    private Block[][] blocks = new Block[3][3];
    private Sudoku sudoku;

    public Case(Block[][] b, Sudoku s) {
        blocks = b;
        sudoku = s;
        setLayout(new GridLayout(3,3));
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                add(blocks[x][y]);
            }
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

    public boolean checkConstraint() {
        ArrayList<Integer> check = new ArrayList<Integer>();
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(blocks[x][y].hasNoPossibility()) {
                    check.add(blocks[x][y].getValue());
                }
            }
        }
        Set set = new TreeSet();
        set.addAll(check);
        if(check.size() != set.size()) {
            return true;
        }

        return false;
    }

    public void paintComponent(Graphics g) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                blocks[x][y].repaint();
            }
        }
    }
}
