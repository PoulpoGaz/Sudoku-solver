package fr.PoulpoGaz.Sudoku;

import javax.management.openmbean.SimpleType;

public class Sudoku {

    private Case[][] cases = new Case[3][3];

    private Series[] cols = new Series[9];
    private Series[] rows = new Series[9];

    public Sudoku(String line) {
        Block[][] blocks = new Block[9][9];

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int index = x*9 + y;
                if(line.charAt(index) == 'X') {
                    blocks[x][y] = new Block();
                    //Si le caractère à l'index "index" est superieur au caractère 0
                    //et inferieur au caractère 9 ALORS
                } else if(line.charAt(index) > '0' && line.charAt(index) <= '9') {
                    //On ajoute au tableau la valeur du caractère à l'index "index" convertit en entier.
                    blocks[x][y] = new Block(line.charAt(index) - '0');
                } else {
                    System.err.println("Un caractère ne contient pas un chiffre, un X ou est vide.");
                    System.exit(1);
                }
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                Block[][] c = new Block[3][3];
                for(int x = 0; x < 3; x++) {
                    System.arraycopy(blocks[x + i], j, c[x], 0, 3);
                }
                cases[i/3][j/3] = new Case(c);
            }
        }

        for(int i = 0; i < 9; i++) {
            Block[] col = new Block[9];
            Block[] row = new Block[9];
            for(int j = 0; j < 9; j++) {
                col[j] = blocks[j][i];
                row[j] = blocks[i][j];
            }
            cols[i] = new Series(col);
            rows[i] = new Series(row);
        }

        System.out.println("CASE");
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                System.out.println(cases[a][b].toString());
            }
        }

        System.out.println("\nCOLONNE");
        for(int a = 0; a < 9; a++) {
            System.out.println(cols[a]);

        }

        System.out.println("\nLIGNE");
        for(int a = 0; a < 9; a++) {
            System.out.println(rows[a]);

        }
    }
}
