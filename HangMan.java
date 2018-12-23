//Created by Elena Rybalkina
package hangman;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

    public static String [ ] words = { "javascript", "declaration", "object", "class", "failing" };

    public static char[ ] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {

        int guessesNumber = 0; // number of guesses attempted
        int invalidGuessesNumber = 0; // number of invalid guesses
        char[ ] guessedChars = new char[27]; // guessed chars

        String word = getRandomWord(words);
        char[] wordChars = explode(word);

        Scanner sc = new Scanner(System.in);

        do {
            printHangMan(invalidGuessesNumber);
            printAlphabet(guessedChars);
            printGuessedWord(word, guessedChars);
            System.out.println("Guess your character: ");
            String guess = sc.nextLine();
            char[] guessChars = explode(guess);
            if (guessChars.length == 0) {
                continue;
            }
            char guessChar = guessChars[0]; // Only first one matters
            if (!arrayContains(guessChar, alphabet)) {
                System.out.println("Please enter valid alphabet character in lowercase");
                continue;
            }
            guessedChars[guessesNumber] = guessChar;
            guessesNumber++;
            if (!arrayContains(guessChar, wordChars)) {
                invalidGuessesNumber++;
            }
        } while (!userWon(wordChars, guessedChars)  && invalidGuessesNumber < 7);

        if (invalidGuessesNumber >= 7) {
            System.out.println("You lost!");
            printHangMan(invalidGuessesNumber);
        } else {
            System.out.println("Winner-winner, chicken dinner!");
            printGuessedWord(word, guessedChars);
        }

    }

    public static void printHangMan(int invalidGuessesNumber) {
        System.out.println("----------");
        System.out.println("|        |");
        System.out.print("|");
        if (invalidGuessesNumber > 0) {
            System.out.print("        O");
        }
        System.out.println();
        System.out.print("|");

        if (invalidGuessesNumber > 1) {
            System.out.print("       /");
        }

        if (invalidGuessesNumber > 2) {
            System.out.print("|");
        }

        if (invalidGuessesNumber > 3) {
            System.out.print("\\");
        }
        System.out.println();
        System.out.print("|");

        if (invalidGuessesNumber > 4) {
            System.out.print("        |");
        }

        System.out.println();
        System.out.print("|");

        if (invalidGuessesNumber > 5) {
            System.out.print("       /");
        }

        if (invalidGuessesNumber > 6) {
            System.out.print(" \\");
        }

        System.out.println();
        System.out.println("|");
        System.out.println("|");
    }

    public static void printAlphabet(char[] guessedChars) {
        for (char letter: alphabet) {
            if (!arrayContains(letter, guessedChars)) {
                System.out.print(String.valueOf(letter) + ' ');
            }
            else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    public static char[ ] explode(String word) {
        return word.toCharArray();
    }

    public static void printGuessedWord(String word, char[ ] guessedChars) {
         char[] chars = explode(word);
        for (char chr: chars) {
            if (arrayContains(chr, guessedChars)) {
                System.out.print(chr + " ");
            }
            else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }
    
    public static boolean arrayContains(char ch, char[] chars) {
        for (char chr: chars) {
            if (chr == ch) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean userWon(char[] word, char[] guesses) {
        int numberMatches = 0;
        for (char chr: word) {
            if (arrayContains(chr, guesses)) {
                numberMatches++;
            }
        }
        return numberMatches == word.length;
    }

    public static String getRandomWord(String[] words) {
        int rndIndex = new Random().nextInt(words.length);
        return words[rndIndex];
    }
}