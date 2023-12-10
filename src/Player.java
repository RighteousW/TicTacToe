public class Player {
    private char letter;
    private final String name;

    public String getName() {
        return name;
    }

    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
    public Player(String name){
        this.name = name;
    }
}
