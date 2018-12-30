package fr.PoulpoGaz.Sudoku;

import java.util.ArrayList;

public class Block {

    private int value = 0;
    private ArrayList<Integer> possibilities;
    private String color;
    private Sudoku sudoku;

    public Block(int v, Sudoku s) {
        value = v;
        possibilities = new ArrayList<Integer>();
        color = "";
        sudoku = s;
    }

    public Block(Sudoku s) {
        possibilities = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++) {
            possibilities.add(i);
        }
        color = "\u001b[31m";
        sudoku = s;
    }

    public String toString() {
        if(value == 0) return possibilities.toString();
        else return color + String.valueOf(value) + "\u001b[0m";
    }

    public void update() {
        if(possibilities.size() == 1) {
            value = possibilities.get(0);
            sudoku.addStep();
        }
    }

    public boolean hasNoPossibility() {
        return value != 0;
    }

    public void remove(int nb) {
        possibilities.remove(Integer.valueOf(nb));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getPossibility() {
        return possibilities;
    }

    public void setPossibility(ArrayList<Integer> possibility) {
        this.possibilities = possibility;
    }
}
