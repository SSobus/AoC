package AoC2020.Day2;

public class PasswordInformation {

    int min;
    int max;
    char character;
    String password;

    public PasswordInformation() {
    }

    public PasswordInformation(int min, int max, char character, String password) {
        this.min = min;
        this.max = max;
        this.character = character;
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
