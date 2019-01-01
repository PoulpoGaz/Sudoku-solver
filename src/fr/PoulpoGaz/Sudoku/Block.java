package fr.PoulpoGaz.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Block extends JPanel {

    private int value = 0;
    private ArrayList<Integer> possibilities;
    private String color = "";
    private Sudoku sudoku;
    private boolean canBeModified;

    public Block(int v, Sudoku s) {
        value = v;
        possibilities = null;
        sudoku = s;
        canBeModified = false;
        init();
    }

    public Block(Sudoku s) {
        possibilities = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++) {
            possibilities.add(i);
        }
        color = "\u001b[31m";
        sudoku = s;
        canBeModified = true;
        init();
    }

    public void init() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(50, 50));
    }

    public String toString() {
        if(value == 0) return color + possibilities.toString() + "\u001b[0m";
        else return color + String.valueOf(value) + "\u001b[0m";
    }

    public void update() {
        if(possibilities != null) {
            if(possibilities.size() == 1) {
                value = possibilities.get(0);
                sudoku.addStep();
                sudoku.sleepAndRepaint();
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if(value!= 0) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("arial", Font.BOLD, 20));
            if(isCanBeModified()) {
                g2d.setColor(Color.RED);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString(String.valueOf(value), 19, 31);
        }
    }

    public boolean hasNoPossibility() {
        return value != 0;
    }

    public void remove(int nb) {
        if(possibilities != null) {
            possibilities.remove(Integer.valueOf(nb));
        }
    }

    public boolean isCanBeModified() {
        return canBeModified;
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
        possibilities = possibility;
    }
}
