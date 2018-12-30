package fr.PoulpoGaz.Sudoku;

public class Sudoku {

    private Block[][] blocks = new Block[9][9];
    private Case[][] cases = new Case[3][3];
    private Series[] cols = new Series[9];
    private Series[] rows = new Series[9];

    private int step;

    public Sudoku(String line) {
        Block[][] b = new Block[9][9];

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int index = x*9 + y;
                if(line.charAt(index) == 'X') {
                    b[x][y] = new Block(this);
                    //Si le caractère à l'index "index" est superieur au caractère 0
                    //et inferieur au caractère 9 ALORS
                } else if(line.charAt(index) > '0' && line.charAt(index) <= '9') {
                    //On ajoute au tableau la valeur du caractère à l'index "index" convertit en entier.
                    b[x][y] = new Block(line.charAt(index) - '0', this);
                } else {
                    System.err.println("Un caractère ne contient pas un chiffre, un X ou est vide.");
                    System.exit(1);
                }
            }
        }
        blocks = b;

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                Block[][] c = new Block[3][3];
                for(int x = 0; x < 3; x++) {
                    System.arraycopy(blocks[x + i], j, c[x], 0, 3);
                }
                cases[i/3][j/3] = new Case(c,this);
            }
        }

        for(int i = 0; i < 9; i++) {
            Block[] col = new Block[9];
            Block[] row = new Block[9];
            for(int j = 0; j < 9; j++) {
                col[j] = blocks[j][i];
                row[j] = blocks[i][j];
            }
            cols[i] = new Series(col,this);
            rows[i] = new Series(row,this);
        }

        System.out.println(toString());
        solve();
    }

    public void solve() {
        step = 0;
        System.out.println("POSSIBILITÉE:\n" + blockToString() + "\n\n\n\n\n");

        while(!check()) {
            for(int x = 0; x < 3; x++) {
                for(int y = 0; y < 3; y++) {
                    cases[x][y].removePossibilities();
                }
            }

            for(int x = 0; x < 9; x++) {
                cols[x].removePossibilities();
            }

            for(int x = 0; x < 9; x++) {
                rows[x].removePossibilities();
            }
        }
        System.out.println(toString());
        System.out.println("SOLVE\nin " + step + " steps");
    }

    public String toString() {
        String str = "CASE";
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                str += "\n" + cases[a][b].toString();
            }
        }

        str += "\n\nCOLONNE";
        for(int a = 0; a < 9; a++) {
            str += "\n" + cols[a].toString();
        }

        str += "\n\nLIGNE\n";
        for(int a = 0; a < 9; a++) {
            str += rows[a].toString();
        }

        return str;
    }

    public String blockToString() {
        String str = "";
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                str += blocks[x][y] + "\n";
            }
        }
        return str;
    }

    public boolean check() {
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                if(!blocks[x][y].hasNoPossibility()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addStep() {
        step++;
        if(step%1000==0) {
            System.out.println("POSSIBILITÉE:\n" + blockToString());
        }
    }
}
