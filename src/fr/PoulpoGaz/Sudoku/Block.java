package fr.PoulpoGaz.Sudoku;

import java.util.ArrayList;

public class Block {

    private int value = 0;
    private ArrayList<Integer> possibility;

    public Block(int v) {
        value = v;
        possibility = new ArrayList<Integer>(0);
    }

    public Block() {
        possibility = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++) {
            possibility.add(i);
        }
    }

    public String toString() {
        if(value == 0) return possibility.toString();
        else return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getPossibility() {
        return possibility;
    }

    public void setPossibility(ArrayList<Integer> possibility) {
        this.possibility = possibility;
    }
}
