import java.util.Scanner;

public class Humano implements Jogador {
    private char marca;
    private Scanner scanner;

    public Humano(char marca) {
        this.marca = marca;
        scanner = new Scanner(System.in);
    }

    @Override
    public char getMarca() {
        return marca;
    }

    @Override
    public int getLinha() {
        System.out.print("[Linha]: ");
        return scanner.nextInt() - 1;
    }

    @Override
    public int getColuna() {
        System.out.print("[Coluna]: ");
        return scanner.nextInt() - 1;
    }
}
