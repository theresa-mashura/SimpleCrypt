public class CaesarCipher extends ROT13 {

    public CaesarCipher(char firstChar, char secondChar) {
        super(firstChar, secondChar);
    }

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public String decryptCaesar(String s) {
        StringBuilder crypt = new StringBuilder();

        int shiftBack = 26 - this.shift;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isUpperCase(curr)) {
                crypt.append(this.getShift(curr, 64, 90, shiftBack));
            } else if (Character.isLowerCase(curr)) {
                crypt.append(this.getShift(curr, 96, 122, shiftBack));
            } else {
                crypt.append(curr);
            }
        }

        return crypt.toString();
    }

    public char getShift(char curr, int min, int max, int shiftBack) {
        if (curr > (max - shiftBack)) {
            return (char) (min + (shiftBack - (max - curr)));
        } else {
            return (char) (curr + shiftBack);
        }
    }
}
