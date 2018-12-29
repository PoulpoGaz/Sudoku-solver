package fr.PoulpoGaz.Sudoku;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;

public class SudokuSolver {

    public static void main(String[] args) {
        new SudokuSolver();
    }

    private int[][] sudoku = new int[9][9];

    public SudokuSolver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Choississez votre fichier");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("SudokuSolver(ss)","ss"));
        jfc.setCurrentDirectory(new File("C:\\Users\\Valentin\\JavaProject\\Sudoku"));
        jfc.showDialog(null, "Ok");

        String line = "";

        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(jfc.getSelectedFile())));

            line = bis.readLine();

            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (line != null && line.length() != 81) {
            System.err.println("Trop ou pas assez de caractère.");
            System.exit(1);
        }

        Sudoku sudoku = new Sudoku(line);
    }
}