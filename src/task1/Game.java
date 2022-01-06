package task1;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;


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
    public static String[][] showTable(String[][] table) {
        
        for (int i = 0; i < 5; i++) {
            System.out.print((i % 5) + "  ");
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");  // to skip de row number 
        for (int column = 0; column < 5; column++) {
            System.out.print(" " + (column % 5) + " ");
        }
        System.out.println();
        return table;
    }
    
    public static String randomStrings() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder str = new StringBuilder();
        Random rand = new Random();
        while (str.length() < 27) { // length of the random string.
            int index = (int) (rand.nextFloat() * alphabet.length());
            str.append(alphabet.charAt(index));
        }
        String randomString = str.toString();
        return randomString;

    }
    
    public static String keyWord(){
        String keyWord = "";
        Random rand = new Random();

        int count = 0;
        Game obj = new Game();
        String[] words = new String[5665];

        String fileLocation = System.getProperty("user.dir");

        String dataPath = fileLocation + File.separator + "wordlist.txt";

        /* Read word from file list */
        try {
            File textList = new File(dataPath);
            Scanner scanner = new Scanner(textList);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (obj.uniqueCharacters(data)) {
                    words[count] = data;
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error Occurred, File not found.");
        }
        
        int index = (int) (rand.nextFloat() * words.length);
        keyWord = words[index];
        
        return keyWord;
    }

    public static String[][] buildTable() {
        
        int a = 0, b = 0;
        
        int wordStart = (int) a + b;
        String randomStrings = randomStrings();
        String keyWord = keyWord(); 
        
        String[][] grid = new String[5][5];
        for (int row = 0; row < 5; row++) {
            // the row number
            System.out.print((row % 5) + " ");
            for (int column = 0; column < 5; column++) {
                grid[row][column] = "? ";
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }
        // at the end the column
        System.out.print("  ");  // to skip de row number 
        for (int column = 0; column < 5; column++) {
            System.out.print((column % 5) + " ");
        }
        System.out.println();

        return grid;
    }

    public static void main(String[] args) {
                
        String[][] fakeTable = {{"? ", "? ", "? ", "? ", "? "},
                                {"? ", "? ", "? ", "? ", "? "},
                                {"? ", "? ", "? ", "? ", "? "},
                                {"? ", "? ", "? ", "? ", "? "},
                                {"? ", "? ", "? ", "? ", "? "}
        };
        
        showTable(fakeTable);

    }

}
