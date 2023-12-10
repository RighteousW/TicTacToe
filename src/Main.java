import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player1 name: ");
        String name1 = scanner.next();
        System.out.println("Player2 name: ");
        String name2 = scanner.next();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        Game newGame = new Game();
        newGame.game_loop(player1,player2);
    }
}