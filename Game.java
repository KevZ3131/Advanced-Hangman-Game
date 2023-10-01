import java.io.*;//Imports
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import javax.swing.JFrame;

public class Game {
  private String difficulty;// Initalize difficulty String
  private String unknownWord;// Initalize unknown word String
  private char[] alreadyGuessedLettersList = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
      ' ' };// Initalize a already guessed letters list
  private char[] arrayWordList;
  private String[] alreadyGuessedWordsList = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
      " " };// Initalize an already guessed words list
  private boolean isLetterInWord; // Initalize boolean to check if letter is in word
  private boolean isWordAnswer;// Initalize boolean to check if word entered is the unknown word
  private int numLetterGuessed;// inialize variables
  private int numWordsGuessed;
  private String alreadyGuessed;
  private Player player;
  private int top;
  private int bottom;
  private String gameOver;
  private String theme;
  private String fileName;
  private int maxLetters;
  private int minLetters;

  Game() {// Main constructor
    player = new Player();// create player class
    gameOver = "";
    unknownWord = "";
    numLetterGuessed = 0;
    numWordsGuessed = 0;
  }

  // Creates the game

  public void setDifficulty(String d) {// Set difficulty
    difficulty = d;
    player.setNumGuesses(d);
  }

  public void setTheme(String t) {// set theme
    theme = t;
  }

  public String getTheme() {// get theme
    return theme;
  }

  public void setFileName(String f) {// set file name
    fileName = f + ".txt";
  }

  public void minusNumGuess() {// Remove number of guesses by 1
    player.minusNumGuess();
    if (player.getNumGuesses() == 0) {// If numguesses is 0 call lose function
      this.gameOver("Loss");
    }
  }

  public int getNumGuesses() {// Get num guessed
    return player.getNumGuesses();
  }

  public void setUnknownWord() {// Set unknown word
    Random rand = new Random();
    boolean gotWord = false;
    if (this.difficulty.equals("Easy")) {// Set min and max letters allowed in the word dependent on difficulty
      minLetters = 0;
      maxLetters = 5;
    } else if (this.difficulty.equals("Normal")) {
      minLetters = 5;
      maxLetters = 8;
    } else if (this.difficulty.equals("Hard")) {
      minLetters = 8;
      maxLetters = 15;
    }

    try {

      while (gotWord == false) {// While got word is false
        if (theme.equals("Winter")) { // Get a random word in the themed text file
          unknownWord = Files.readAllLines(Paths.get(fileName)).get(rand.nextInt(0, this.getNumLines()));
        }

        else if (theme.equals("Bunny")) {
          unknownWord = Files.readAllLines(Paths.get(fileName)).get(rand.nextInt(0, this.getNumLines()));
        } else {
          unknownWord = Files.readAllLines(Paths.get(fileName)).get(rand.nextInt(0, this.getNumLines()));
          minLetters = 0;// remove min and max bounds for custom words
          maxLetters = 100;
        }

        if (minLetters < unknownWord.length() && unknownWord.length() < maxLetters) {// If the unknown word is larger
                                                                                     // and less than set bounds set got
                                                                                     // word to true
          gotWord = true;
        }
      }

    } catch (IOException e) {

    }

    arrayWordList = new char[unknownWord.length()]; // Set place holder for the letters in the unknown word
    for (int i = 0; i < unknownWord.length(); i++) {
      arrayWordList[i] = '_';
    }
  }

  public String getUnknownWord() {// Get unknown word
    return unknownWord;
  }

  public void setArrayWord() {// Set array word
    for (int l = 0; l < unknownWord.length(); l++) {// If the letter is in the unknown word
      if (unknownWord.charAt(l) == player.getLetterGuess()) {
        arrayWordList[l] = player.getLetterGuess();// Replace the place holder with the letter at the same index
      }
    }
  }

  public String getArrayWord() {// Get array word as a string
    String arrayWord = "";
    for (int j = 0; j < arrayWordList.length; j++) {
      arrayWord += (arrayWordList[j] + " ");
    }
    return arrayWord;
  }

  // User input

  public void enterGuess(String g) {// Eneter guess
    if (g.length() > 1) {// If the guess is more than a word
      this.setWordGuess(g);// Call set word guess function
    } else {
      this.setLetterGuess(g.charAt(0));// Else set letter function
    }
  }

  public void isLetterInWord() { // Check if letter is in unknown word
    String l = Character.toString(player.getLetterGuess());
    if (unknownWord.contains(l)) {
      this.setArrayWord();// Replace place holder with letter
    } else {
      this.setalreadyGuessedLettersList();// If the letter is not in the word, minus a guess and add to already guessed
                                          // letters list
      this.minusNumGuess();
    }

  }

  public void setWordGuess(String w) {// Set word to guess
    player.setWordGuess(w);
    this.isWordAnswer();// check if the word is the answer
  }

  public void setLetterGuess(char l) {// Set letter guess
    player.setLetterGuess(l);// Set the player guess
    this.isLetterInWord();// Check if the letter is in wird
  }

  // Checks if game is over

  public void gameOver(String g) {// set gameover
    gameOver = g;
  }

  public String getGameOver() {// get game over
    return gameOver;
  }

  public void isWordAnswer() {// Check if the guess is the unknwon word
    if (unknownWord.equals(player.getWordGuess())) {
      this.gameOver("Win");// set Win if the user guessed the right word
    } else {
      this.setAlreadyGuessedWordsList();// else add the word to already guessed list and minus a guess
      this.minusNumGuess();

    }
  }

  // Already guessed functions

  public void setalreadyGuessedLettersList() {// Add a letter to already guessed letter list
    char l = player.getLetterGuess();
    alreadyGuessedLettersList[numLetterGuessed] = l;
    numLetterGuessed += 1;
  }

  public void setAlreadyGuessedWordsList() {// Add a word to already guessed words list
    String w = player.getWordGuess();
    alreadyGuessedWordsList[numWordsGuessed] = w;
    numWordsGuessed += 1;
  }

  public String getAlreadyGuessedLettersList() {// Get already guessed letters
    alreadyGuessed = "";
    for (int j = 0; j < alreadyGuessedLettersList.length; j++) {
      if (alreadyGuessedLettersList[j] != ' ') {
        alreadyGuessed += (alreadyGuessedLettersList[j] + " ");
      }
    }
    return alreadyGuessed;
  }

  public String getAlreadyGuessedWordsList() {// Get already guessed words as a string
    boolean newLine1 = false;
    boolean newLine2 = false;
    alreadyGuessed = "";
    for (int j = 0; j < alreadyGuessedWordsList.length; j++) {
      if (!alreadyGuessedWordsList[j].equals(" ")) {
        alreadyGuessed += (alreadyGuessedWordsList[j] + " ");
        if (alreadyGuessed.length() > 24 && newLine1 == false && newLine2 == false) {// new line 1
          newLine1 = true;
          alreadyGuessed += "<br/>";
        } else if (alreadyGuessed.length() > 78 && newLine2 == false && newLine1 == true) { // new line 2
          newLine2 = true;
          alreadyGuessed += "<br/>";
        }
      }
    }
    return alreadyGuessed;

  }

  // Check validity of guess

  public boolean isWord(String g) {// Check if the guess is a word: Binary search taken from previous lesson slide
    try {
      FileReader fr = new FileReader("words.txt");
      BufferedReader br = new BufferedReader(fr);
      int min = 0;
      int max = 10000;
      int mid;
      while (min <= max) {// Binaty search for word

        mid = (min + max) / 2;

        if (g.equals(Files.readAllLines(Paths.get("words.txt")).get(mid))) {
          return true;// Return true if word is found
        } else if (g.compareTo(Files.readAllLines(Paths.get("words.txt")).get(mid)) > 0) {// if the word is greater than
                                                                                          // the middle value, set min
                                                                                          // to mid
          min = mid + 1;
        } else {// else if the word is smaller set max to mid
          max = mid - 1;
        }
      }
      br.close();
      return false;// REturn false if word is not found
    } catch (IOException e) {
      return false;
    }
  }

  public boolean isLetterAlphabet(char c) {// Check if the letter is in the alphabet
    if (c >= 'a' && c <= 'z') {
      return false;
    } else {
      return true;
    }
  }

  public boolean isLetterAlreadyGuessed(char c) {// Check if the letter has already been guessed
    for (int j = 0; j < alreadyGuessedLettersList.length; j++) {
      if (alreadyGuessedLettersList[j] == c) {
        return true;
      }
    }
    return false;
  }

  public boolean isWordAlreadyGuessed(String w) {// Check if the word had already been guessed
    for (int j = 0; j < alreadyGuessedLettersList.length; j++) {
      if (alreadyGuessedWordsList[j].equals(w)) {
        return true;
      }
    }
    return false;
  }

  public String checkEmpty(String g) {// Check if there was user input
    if (g.length() == 0) {
      return "Invalid";
    } else {
      return "";
    }
  }

  public String isLetterOrWord(String g) {// Check if the guess is letter or a word
    if (g.length() > 1) {
      return ("word");
    } else {
      return ("letter");
    }

  }

  public String checkValid(String g) {// Check if the guess is valid
    if (!this.checkEmpty(g).equals("Invalid")) {// Check if guess is empty
      if (this.isLetterOrWord(g).equals("letter")) {// Check if the guess is a letter
        if (this.isLetterAlphabet(g.charAt(0))) {// Check if the letter is a letter
          return "Invalid Letter";
        } else if (this.isLetterAlreadyGuessed(g.charAt(0))) {// Check if letter has already been guessed
          return "Already Guessed";
        } else {
          this.enterGuess(g);// Enter guess
          return "";
        }
      } else {
        if (this.isWord(g) == false) {// Else check if the guess is a word
          return "Invalid Word";
        } else if (this.isWordAlreadyGuessed(g)) {// Check if word has already been guessed
          return "Already Guessed";
        } else {
          this.enterGuess(g);// Enter guess
          return "";
        }
      }
    } else {// Return required input
      return "Required Input";
    }

  }

  public int getNumLines() throws IOException {// Get num lines in a txt file https://stackoverflow.com/questions/1277880/how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way
    LineNumberReader reader = null; // set line reader
    try {
      reader = new LineNumberReader(new FileReader(fileName));
      while ((reader.readLine()) != null)
        ;// return num lines
      return reader.getLineNumber();
    } catch (Exception ex) {
      return -1;
    } finally {
      if (reader != null)
        reader.close();// close reader
    }
  }

}