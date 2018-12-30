package fr.PoulpoGaz.Sudoku;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class SudokuSolver {

    public static void main(String[] args) {
        new SudokuSolver();
    }

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

        JFileChooser jfc = new JFileChooser("C:/Users/Valentin/JavaProject/Sudoku");
        jfc.setDialogTitle("Choississez votre fichier");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SudokuSolver(ss)", "ss");
        jfc.addChoosableFileFilter(filter);
        jfc.showOpenDialog(null);

        File path = jfc.getSelectedFile();

        String line = "";

        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

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

        new Sudoku(line);
    }
}