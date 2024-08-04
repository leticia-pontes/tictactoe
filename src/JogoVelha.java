import java.util.Scanner;

public class JogoVelha {
    private Tabuleiro tabuleiro;
    private Humano jogadorAtual;
    private Humano jogadorX;
    private Humano jogadorO;
    private int pontuacaoX;
    private int pontuacaoO;
    private Scanner scanner;

    public JogoVelha() {
        tabuleiro = new Tabuleiro();
        jogadorX = new Humano('X');
        jogadorO = new Humano('O');
        jogadorAtual = jogadorX;
        pontuacaoX = 0;
        pontuacaoO = 0;
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        System.out.println("\n# JOGO DA VELHA #");

        boolean jogando = true;
        while (jogando) {

            tabuleiro.limparTabuleiro();
            tabuleiro.mostrarTabuleiro();
            boolean partidaAtiva = true;

            while (partidaAtiva) {

                int linha, coluna;

                do {
                    System.out.println("\nJOGADOR " + jogadorAtual.getMarca());
                    linha = jogadorAtual.getLinha();
                    coluna = jogadorAtual.getColuna();
                } while (!tabuleiro.marcar(linha, coluna, jogadorAtual.getMarca()));

                tabuleiro.mostrarTabuleiro();

                if (tabuleiro.verificarVitoria()) {
                    System.out.println("\nVITÓRIA DE " + jogadorAtual.getMarca() + "!");
                    if (jogadorAtual == jogadorX) {
                        pontuacaoX++;
                    } else {
                        pontuacaoO++;
                    }
                    partidaAtiva = false;
                } else if (tabuleiro.estaCheio()) {
                    System.out.println("\nEMPATE!");
                    partidaAtiva = false;
                }

                trocarJogador();
            }

            mostrarPontuacoes();

            System.out.println("\nDeseja jogar outra partida? (s/n): ");
            char resposta = scanner.next().charAt(0);
            if (resposta != 's' && resposta != 'S') {
                jogando = false;
            }
        }
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == jogadorX) ? jogadorO : jogadorX;
    }

    private void mostrarPontuacoes() {
        System.out.println("\nPONTUAÇÕES");
        System.out.println("Jogador X: " + pontuacaoX);
        System.out.println("Jogador O: " + pontuacaoO);
    }
}
