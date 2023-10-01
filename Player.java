public class Player{//player class
  private int numGuesses;//initalize varialbes
  private char letterGuess;
  private String wordGuess;
  
  Player(){//Constructor
    numGuesses=15;
    letterGuess=' ';
    wordGuess= " ";
  }

public int getNumGuesses() {//get the number of gueses
	return numGuesses;
}
public String getWordGuess() {//get the word guessed
	return wordGuess;
}

public void setWordGuess(String w) {//set the word guessed
	wordGuess = w;
}


public void setNumGuesses(String t) {//set num guesses depending on difficulty
  if(t.equals("Easy")){
	numGuesses = 15;
  }
  else if(t.equals("Normal")){
	numGuesses = 12;
  }
  else if(t.equals("Hard")){
	numGuesses = 10;
  }
}

public char getLetterGuess() {//get the letter guesses
	return letterGuess;
}

public void setLetterGuess(char l) {//set the letter guessed
	letterGuess = l;
}

public void minusNumGuess(){//minus the number of guesses
  numGuesses-=1;
}
 
  

  
}