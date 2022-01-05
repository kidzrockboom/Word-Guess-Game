package task1;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    int MAX_CHAR = 256;

    // Test if the  string had unique characters
    public boolean uniqueCharacters(String str) {
        // If length is greater than 256,
        // some characters must have been repeated
        if (str.length() > MAX_CHAR) {
            return false;
        }

        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        for (int i = 0; i < str.length(); i++) {
            int index = (int) str.charAt(i);

            /* If the value is already true, string
               has duplicate characters, return false */
            if (chars[index] == true) {
                return false;
            }

            chars[index] = true;
        }

        /* No duplicates encountered, return true */
        return true;
    }

    public static void fakeTable() {
        String[][] swampGrid = new String[5][5];
        for (int row = 0; row < 5; row++) {
            // the row number
            System.out.print((row % 5) + " ");
            for (int column = 0; column < 5; column++) {
                swampGrid[row][column] = "? ";
                System.out.print(swampGrid[row][column]);
            }
            System.out.println();
        }
        // at the end the column
        System.out.print("  ");  // to skip de row number 
        for (int column = 0; column < 5; column++) {
            System.out.print((column % 5) + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int count = 0;
        Game obj = new Game();
        String[] word = new String[5665];

        String fileLocation = System.getProperty("user.dir");

        String dataPath = fileLocation + File.separator + "wordlist.txt";

        /* Read word from file list */
        try {
            File textList = new File(dataPath);
            Scanner scanner = new Scanner(textList);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (obj.uniqueCharacters(data)) {
                    word[count] = data;
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error Occurred, File not found.");
        }
        fakeTable();

    }

}
