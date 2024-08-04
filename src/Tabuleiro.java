public class Tabuleiro {

    private static final int TAMANHO = 3;
    private EstadoCelula[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new EstadoCelula[TAMANHO][TAMANHO];
        limparTabuleiro();
    }

    public void limparTabuleiro() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                tabuleiro[i][j] = EstadoCelula.VAZIO;
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.println();

        System.out.print("   ");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print(" " + (i + 1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < TAMANHO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO; j++) {
                if (tabuleiro[i][j] == EstadoCelula.VAZIO) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + tabuleiro[i][j] + " ");
                }
                if (j < TAMANHO - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < TAMANHO - 1) {
                System.out.print("  ");
                System.out.println("---+---+---");
            }
        }
    }

    public boolean estaCheio() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if (tabuleiro[i][j] == EstadoCelula.VAZIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verificarVitoria() {
        return (verificarLinhas() || verificarColunas() || verificarDiagonais());
    }

    private boolean verificarLinhas() {
        for (int i = 0; i < TAMANHO; i++) {
            if (verificarTresIguais(tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarColunas() {
        for (int i = 0; i < TAMANHO; i++) {
            if (verificarTresIguais(tabuleiro[0][i], tabuleiro[1][i], tabuleiro[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarDiagonais() {
        return ((verificarTresIguais(tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2])) ||
                (verificarTresIguais(tabuleiro[0][2], tabuleiro[1][1], tabuleiro[2][0])));
    }

    private boolean verificarTresIguais(EstadoCelula c1, EstadoCelula c2, EstadoCelula c3) {
        return ((c1 != EstadoCelula.VAZIO) && (c1 == c2) && (c2 == c3));
    }

    public boolean marcar(int linha, int coluna, char marca) {
        if (linha >= 0 && linha < TAMANHO && coluna >= 0 && coluna < TAMANHO) {
            if (tabuleiro[linha][coluna] == EstadoCelula.VAZIO) {
                tabuleiro[linha][coluna] = EstadoCelula.valueOf(String.valueOf(marca));
                return true;
            }
        }
        return false;
    }
}
