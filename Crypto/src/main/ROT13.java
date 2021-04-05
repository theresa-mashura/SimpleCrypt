import java.util.ArrayList;

public class ROT13 {

    Integer shift;

    public ROT13() {
        this.shift = 13;
    }

    public ROT13(char firstChar, char secondChar) {
        this.shift = Math.abs(secondChar - firstChar);
    }

    public String crypt(String s) {
        StringBuilder crypt = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isUpperCase(curr)) {
                crypt.append(this.getShift(curr, 64, 90));
            } else if (Character.isLowerCase(curr)) {
                crypt.append(this.getShift(curr, 96, 122));
            } else {
                crypt.append(curr);
            }
        }

        return crypt.toString();
    }

    public char getShift(char curr, int min, int max) {
        if (curr > (max - this.shift)) {
            return (char) (min + (this.shift - (max - curr)));
        } else {
            return (char) (curr + this.shift);
        }
    }
}
