import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public String readFile(String filename) {
        String path = "/Users/theresa/_LABS/SimpleCrypt/" + filename;
        try {
            File file = new File(path);

            Scanner s = new Scanner(file);
            StringBuilder sb = new StringBuilder("");

            while (s.hasNextLine()) {
                sb.append(s.nextLine()).append("\n");
            }
            s.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("That file doesn't exist.");
        }
        return null;

    }

    public void writeToNewFile(String filename, String str) {
        try {
            File file = new File(filename);
            file.createNewFile();
            //System.out.print(file.getAbsolutePath());
            FileWriter w = new FileWriter(filename);
            w.write(str);
            w.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
