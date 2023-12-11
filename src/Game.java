import java.util.Objects;
import java.util.Scanner;

public class Game {
    private static final int BOARD_SIZE = 3;        // size of the board, it's a square
    private static final char[] SYMBOLS = {'O','X'};
    char[] board = new char[BOARD_SIZE*BOARD_SIZE];      // the board of the game
    int player1_wins;      // number of wins of player using 'O' if on loop
    int player2_wins;      // number of wins of player using 'X' if on loop

    public Game(){
        this.player1_wins = 0;
        this.player2_wins = 0;
    }
    // checking if the place where you want to place move is valid
    public boolean is_valid_move(int move){
        if(0 > move || move > BOARD_SIZE*BOARD_SIZE-1){
            return false;
        }
        return board[move] == '\0';
    }
    public boolean can_not_play_move(int move, char letter){
        if(is_valid_move(move)){
            board[move] = letter;
            return false;
        }
        return true;
    }
    public String game_string(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < BOARD_SIZE*BOARD_SIZE; i++){
            result.append("|").append(this.board[i]).append("|");
            if(i != 0 && (i+1) % BOARD_SIZE == 0)
                result.append('\n');
        }
        return result.toString();
    }
    public String board_numbers(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < BOARD_SIZE*BOARD_SIZE; i++){
            result.append("|").append(i).append("|");
            if(i != 0 && (i+1) % BOARD_SIZE == 0)
                result.append('\n');
        }
        return result.toString();
    }
    public boolean is_winning_move(){
        for (char symbol : SYMBOLS) {
            if (board[0] == board[1] && board[1] == board[2] && board[2] == symbol) {
                return true;
            }
            if (board[3] == board[4] && board[4] == board[5] && board[5] == symbol) {
                return true;
            }
            if (board[6] == board[7] && board[7] == board[8] && board[8] == symbol) {
                return true;
            }
            if (board[0] == board[3] && board[3] == board[6] && board[6] == symbol) {
                return true;
            }
            if (board[1] == board[4] && board[4] == board[7] && board[7] == symbol) {
                return true;
            }
            if (board[2] == board[5] && board[5] == board[8] && board[8] == symbol) {
                return true;
            }
            if (board[0] == board[4] && board[4] == board[8] && board[8] == symbol) {
                return true;
            }
            if (board[2] == board[4] && board[4] == board[6] && board[6] == symbol) {
                return true;
            }
        }
        return false;
    }
    public String score(){
        return "Scores: \n" +
                "Player1: " + this.player1_wins + "\n" +
                "Player2: " + this.player2_wins;
    }

    public void game_loop(Player player1, Player player2){
        player1.setLetter(SYMBOLS[0]);
        player2.setLetter(SYMBOLS[1]);
        int move;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Board numbers: ");
            System.out.println(board_numbers());
            System.out.println("Current game state:");
            System.out.println(game_string());
            System.out.println(player1.getName() + " move number: ");
            do{
                move = scanner.nextInt();
            }while(can_not_play_move(move, player1.getLetter()));
            if(is_winning_move()){
                System.out.println(player1 + " wins");
                this.player1_wins ++;
                System.out.println(score());
                break;
            }
            System.out.println("Current game state:");
            System.out.println(game_string());
            System.out.println(player2.getName() + " move number: ");
            do{
                move = scanner.nextInt();
            }while(can_not_play_move(move, player2.getLetter()));
            if(is_winning_move()){
                System.out.println(player2 + " wins");
                this.player2_wins ++;
                System.out.println(score());
                break;
            }
        }
        System.out.println("Enter any key to retry!! (q to quit)");
        String choice = scanner.next();
        if(!Objects.equals(choice, "q")){
            game_loop(player1,player2);
        }
    }
}
