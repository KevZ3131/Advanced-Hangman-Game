import java.awt.Color;//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JComponent implements ActionListener, KeyListener {//Implement action and key listner
  private Game newGame;//Initalize a new game
  private JFrame frame;//Initalize frame
  private Font textFieldFont;//Initalize fonts
  private Font guessedLettersFont;
  private Font letterWordFont;
  private JPanel letterWordPanel; //Initalize letter word
  private JLabel letterWord;
  private JPanel guessedWordsPanel;//Initalize guessed words
  private JLabel guessedWords;
  private JPanel guessPanel;//Initalize guess
  private JTextField guess;
  private JButton enterGuess;//Intialize enter guess button
  private JPanel guessedLettersPanel;//Initalize guessed letters
  private JLabel guessedLetters;
  private ImageIcon backgroundImage;//Initalize background
  private JLabel background;
  private JLabel numGuesses;//Initalize numguesses
  private JLabel character;//Initalize character
  private ImageIcon scaledCharacter15, scaledCharacter14, scaledCharacter13, scaledCharacter12, scaledCharacter11,
      scaledCharacter10, scaledCharacter9, scaledCharacter8, scaledCharacter7, scaledCharacter6, scaledCharacter5,
      scaledCharacter4, scaledCharacter3, scaledCharacter2, scaledCharacter1;//Initalize seperate parts of a character

  GameGUI(Game newGame) {
    this.newGame = newGame;//Create a new instance of game and make it equal to game in previous window
    frame = new JFrame();//Create a new instance of a frame

    if (newGame.getTheme().equals("Winter")) {//Set bacgrkound and characters if theme is winter
      background = new JLabel();
      backgroundImage = new ImageIcon("Images/Christmas.png");
      background.setBounds(0, 0, 800, 400);

      Image characterImage15 = (new ImageIcon("Images/Snowman15.png")).getImage();
      Image imgScaleCharacter15 = characterImage15.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter15 = new ImageIcon(imgScaleCharacter15);

      Image characterImage14 = (new ImageIcon("Images/Snowman14.png")).getImage();
      Image imgScaleCharacter14 = characterImage14.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter14 = new ImageIcon(imgScaleCharacter14);

      Image characterImage13 = (new ImageIcon("Images/Snowman13.png")).getImage();
      Image imgScaleCharacter13 = characterImage13.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter13 = new ImageIcon(imgScaleCharacter13);

      Image characterImage12 = (new ImageIcon("Images/Snowman12.png")).getImage();
      Image imgScaleCharacter12 = characterImage12.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter12 = new ImageIcon(imgScaleCharacter12);

      Image characterImage11 = (new ImageIcon("Images/Snowman11.png")).getImage();
      Image imgScaleCharacter11 = characterImage11.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter11 = new ImageIcon(imgScaleCharacter11);

      Image characterImage10 = (new ImageIcon("Images/Snowman10.png")).getImage();
      Image imgScaleCharacter10 = characterImage10.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter10 = new ImageIcon(imgScaleCharacter10);

      Image characterImage9 = (new ImageIcon("Images/Snowman9.png")).getImage();
      Image imgScaleCharacter9 = characterImage9.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter9 = new ImageIcon(imgScaleCharacter9);

      Image characterImage8 = (new ImageIcon("Images/Snowman8.png")).getImage();
      Image imgScaleCharacter8 = characterImage8.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter8 = new ImageIcon(imgScaleCharacter8);

      Image characterImage7 = (new ImageIcon("Images/Snowman7.png")).getImage();
      Image imgScaleCharacter7 = characterImage7.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter7 = new ImageIcon(imgScaleCharacter7);

      Image characterImage6 = (new ImageIcon("Images/Snowman6.png")).getImage();
      Image imgScaleCharacter6 = characterImage6.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter6 = new ImageIcon(imgScaleCharacter6);

      Image characterImage5 = (new ImageIcon("Images/Snowman5.png")).getImage();
      Image imgScaleCharacter5 = characterImage5.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter5 = new ImageIcon(imgScaleCharacter5);

      Image characterImage4 = (new ImageIcon("Images/Snowman4.png")).getImage();
      Image imgScaleCharacter4 = characterImage4.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter4 = new ImageIcon(imgScaleCharacter4);

      Image characterImage3 = (new ImageIcon("Images/Snowman3.png")).getImage();
      Image imgScaleCharacter3 = characterImage3.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter3 = new ImageIcon(imgScaleCharacter3);

      Image characterImage2 = (new ImageIcon("Images/Snowman2.png")).getImage();
      Image imgScaleCharacter2 = characterImage2.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter2 = new ImageIcon(imgScaleCharacter2);

      Image characterImage1 = (new ImageIcon("Images/Snowman1.png")).getImage();
      Image imgScaleCharacter1 = characterImage1.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter1 = new ImageIcon(imgScaleCharacter1);
      
    } else if (newGame.getTheme().equals("Bunny")) {//Set bacgrkound and characters if theme is Bunny
      background = new JLabel();
      backgroundImage = new ImageIcon("Images/BunnyBackground.png");
      background.setBounds(0, 0, 800, 400);

      Image characterImage15 = (new ImageIcon("Images/Bunny15.png")).getImage();
      Image imgScaleCharacter15 = characterImage15.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter15 = new ImageIcon(imgScaleCharacter15);

      Image characterImage14 = (new ImageIcon("Images/Bunny14.png")).getImage();
      Image imgScaleCharacter14 = characterImage14.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter14 = new ImageIcon(imgScaleCharacter14);

      Image characterImage13 = (new ImageIcon("Images/Bunny13.png")).getImage();
      Image imgScaleCharacter13 = characterImage13.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter13 = new ImageIcon(imgScaleCharacter13);

      Image characterImage12 = (new ImageIcon("Images/Bunny12.png")).getImage();
      Image imgScaleCharacter12 = characterImage12.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter12 = new ImageIcon(imgScaleCharacter12);

      Image characterImage11 = (new ImageIcon("Images/Bunny11.png")).getImage();
      Image imgScaleCharacter11 = characterImage11.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter11 = new ImageIcon(imgScaleCharacter11);

      Image characterImage10 = (new ImageIcon("Images/Bunny10.png")).getImage();
      Image imgScaleCharacter10 = characterImage10.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter10 = new ImageIcon(imgScaleCharacter10);

      Image characterImage9 = (new ImageIcon("Images/Bunny9.png")).getImage();
      Image imgScaleCharacter9 = characterImage9.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter9 = new ImageIcon(imgScaleCharacter9);

      Image characterImage8 = (new ImageIcon("Images/Bunny8.png")).getImage();
      Image imgScaleCharacter8 = characterImage8.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter8 = new ImageIcon(imgScaleCharacter8);

      Image characterImage7 = (new ImageIcon("Images/Bunny7.png")).getImage();
      Image imgScaleCharacter7 = characterImage7.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter7 = new ImageIcon(imgScaleCharacter7);

      Image characterImage6 = (new ImageIcon("Images/Bunny6.png")).getImage();
      Image imgScaleCharacter6 = characterImage6.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter6 = new ImageIcon(imgScaleCharacter6);

      Image characterImage5 = (new ImageIcon("Images/Bunny5.png")).getImage();
      Image imgScaleCharacter5 = characterImage5.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter5 = new ImageIcon(imgScaleCharacter5);

      Image characterImage4 = (new ImageIcon("Images/Bunny4.png")).getImage();
      Image imgScaleCharacter4 = characterImage4.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter4 = new ImageIcon(imgScaleCharacter4);

      Image characterImage3 = (new ImageIcon("Images/Bunny3.png")).getImage();
      Image imgScaleCharacter3 = characterImage3.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter3 = new ImageIcon(imgScaleCharacter3);

      Image characterImage2 = (new ImageIcon("Images/Bunny2.png")).getImage();
      Image imgScaleCharacter2 = characterImage2.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter2 = new ImageIcon(imgScaleCharacter2);

      Image characterImage1 = (new ImageIcon("Images/Bunny1.png")).getImage();
      Image imgScaleCharacter1 = characterImage1.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter1 = new ImageIcon(imgScaleCharacter1);
    }

    else {//Set bacgrkound and characters if theme is cutsom
      background = new JLabel();
      backgroundImage = new ImageIcon("Images/Chalkboard.png");
      background.setBounds(0, 0, 800, 400);

      Image characterImage15 = (new ImageIcon("Images/Stickman15.png")).getImage();
      Image imgScaleCharacter15 = characterImage15.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter15 = new ImageIcon(imgScaleCharacter15);

      Image characterImage14 = (new ImageIcon("Images/Stickman14.png")).getImage();
      Image imgScaleCharacter14 = characterImage14.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter14 = new ImageIcon(imgScaleCharacter14);

      Image characterImage13 = (new ImageIcon("Images/Stickman13.png")).getImage();
      Image imgScaleCharacter13 = characterImage13.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter13 = new ImageIcon(imgScaleCharacter13);

      Image characterImage12 = (new ImageIcon("Images/Stickman12.png")).getImage();
      Image imgScaleCharacter12 = characterImage12.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter12 = new ImageIcon(imgScaleCharacter12);

      Image characterImage11 = (new ImageIcon("Images/Stickman11.png")).getImage();
      Image imgScaleCharacter11 = characterImage11.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter11 = new ImageIcon(imgScaleCharacter11);

      Image characterImage10 = (new ImageIcon("Images/Stickman10.png")).getImage();
      Image imgScaleCharacter10 = characterImage10.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter10 = new ImageIcon(imgScaleCharacter10);

      Image characterImage9 = (new ImageIcon("Images/Stickman9.png")).getImage();
      Image imgScaleCharacter9 = characterImage9.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter9 = new ImageIcon(imgScaleCharacter9);

      Image characterImage8 = (new ImageIcon("Images/Stickman8.png")).getImage();
      Image imgScaleCharacter8 = characterImage8.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter8 = new ImageIcon(imgScaleCharacter8);

      Image characterImage7 = (new ImageIcon("Images/Stickman7.png")).getImage();
      Image imgScaleCharacter7 = characterImage7.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter7 = new ImageIcon(imgScaleCharacter7);

      Image characterImage6 = (new ImageIcon("Images/Stickman6.png")).getImage();
      Image imgScaleCharacter6 = characterImage6.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter6 = new ImageIcon(imgScaleCharacter6);

      Image characterImage5 = (new ImageIcon("Images/Stickman5.png")).getImage();
      Image imgScaleCharacter5 = characterImage5.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter5 = new ImageIcon(imgScaleCharacter5);

      Image characterImage4 = (new ImageIcon("Images/Stickman4.png")).getImage();
      Image imgScaleCharacter4 = characterImage4.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter4 = new ImageIcon(imgScaleCharacter4);

      Image characterImage3 = (new ImageIcon("Images/Stickman3.png")).getImage();
      Image imgScaleCharacter3 = characterImage3.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter3 = new ImageIcon(imgScaleCharacter3);

      Image characterImage2 = (new ImageIcon("Images/Stickman2.png")).getImage();
      Image imgScaleCharacter2 = characterImage2.getScaledInstance(200, 300,
          Image.SCALE_SMOOTH);
      scaledCharacter2 = new ImageIcon(imgScaleCharacter2);

    }

    character = new JLabel();//Initalize character jlabel 
    character.setBounds(520, -100, 200, 500);
    

    letterWordPanel = new JPanel(); //Initalize new jpanel for letter word
    letterWordPanel.setBounds(0, 155, 500, 50);
    letterWordPanel.setBackground(new Color(0, 0, 0, 0));
    
    letterWord = new JLabel((newGame.getArrayWord()));//Initalize new jlabel to the placeholders for the unknown word
    Font letterWordFont = new Font("ComicSans", Font.BOLD, 32);
    letterWord.setForeground(Color.WHITE);
    letterWord.setFont(letterWordFont);

    numGuesses = new JLabel("Guesses Remaining: " + newGame.getNumGuesses());//Initalize new jlabel to num guesses
    numGuesses.setBounds(0, 0, 500, 50);
    numGuesses.setFont(letterWordFont);
    numGuesses.setForeground(Color.BLACK);

    guessPanel = new JPanel(); //Initalize guess panel
    guessPanel.setBounds(0, 330, 500, 60);
    guessPanel.setBackground(new Color(0, 0, 0, 60));
    guessPanel.setLayout(null);


    enterGuess = new JButton();//Initalize enter guess button
    enterGuess.setBounds(500, 330, 80, 47);
    enterGuess.setText("Enter");
    enterGuess.addActionListener(this);

    guessedLettersPanel = new JPanel();//Initalize guessed letters panel
    guessedLettersPanel.setBounds(0, 300, 500, 30);
    guessedLettersPanel.setBackground(new Color(0, 0, 0, 90));
    
    Font guessedLettersFont = new Font("ComicSans", Font.BOLD, 17);// Initalize guessed letters JLabel and set it to already guessed letters list
    guessedLetters = new JLabel();
    guessedLetters.setForeground(Color.WHITE);
    guessedLetters.setText("Letters guessed: " + newGame.getAlreadyGuessedLettersList());
    guessedLetters.setFont(guessedLettersFont);

    guessedWordsPanel = new JPanel();//Initalize guessed words panel
    guessedWordsPanel.setBounds(0, 220, 500, 80);
    guessedWordsPanel.setBackground(new Color(0, 0, 0, 100));

    guessedWords = new JLabel();// Initalize guessed words JLabel and set it to already guessed letters list
    guessedWords.setText("Words guessed: " + newGame.getAlreadyGuessedWordsList());
    guessedWords.setForeground(Color.WHITE);
    guessedWords.setFont(guessedLettersFont);

    Font textFieldFont = new Font("ComicSans", Font.BOLD, 25);//Initalize text field to enter guess
    guess = new JTextField();
    guess.setBounds(0, 0, 500, 45);
    guess.setFont(textFieldFont);
    guess.addKeyListener(this);//Add key listener

    Image imgBackground = backgroundImage.getImage(); //Set iamge
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);
    background.setIcon(scaledBackground);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    guessPanel.add(guess);//Add instances to their panels
    guessedLettersPanel.add(guessedLetters);
    guessedLettersPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    letterWordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    guessedWordsPanel.add(guessedWords);
    guessedWordsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    letterWordPanel.add(letterWord);
    
    frame.add(character);//Add all instances to frame
    frame.add(numGuesses);
    frame.add(letterWordPanel);
    frame.add(guessedLettersPanel);
    frame.add(guessedWordsPanel);
    frame.add(guessPanel);
    frame.add(enterGuess);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    this.displayImage();
  }


  public void keyPressed(KeyEvent e) {
    int n = e.getKeyCode();
    if (e.getKeyText(n).equals("Enter")) {//When user presses key enter

      guess.setText(newGame.checkValid(guess.getText()));//Check if guess is valid and set text to invalid if it isnt

      letterWord.setText((newGame.getArrayWord()));//Replace place holders to letter 
      
      guessedLetters.setText("Letters guessed: " + newGame.getAlreadyGuessedLettersList());//Update already guessed letters JLabel
      
        guessedWords.setText("<html>Words guessed: " + newGame.getAlreadyGuessedWordsList()+"</html>");//Update already guessed words JLabel
      
      numGuesses.setText("Guesses Remaining: " + newGame.getNumGuesses());//Update num guesses

      this.displayImage();//Display the character

      if (newGame.getGameOver().equals("Win")) {//check if game is over
        Win win = new Win();//If the user won, create new window
        frame.dispose();
      } else if (newGame.getGameOver().equals("Loss")) {
        Loss loss = new Loss();//If the user lost, create lost window
        frame.dispose();
      }
      frame.repaint();//Repaint frame

      
    } else if (guess.getText().equals("Invalid Word") || guess.getText().equals("Already Guessed")
        || guess.getText().equals("Required Input") || guess.getText().equals("Invalid Letter")) {//Automatically erase jtextfield if a error message has printed when a key is pressed
      guess.setText("");
    }

  }

  public void keyTyped(KeyEvent e) {//Abstract function for action key listener

  }

  
  public void keyReleased(KeyEvent e) {

  }

  

  public void actionPerformed(ActionEvent e) {//Action performed class
    if (e.getSource() == enterGuess) {////When user presses enter buttob

      guess.setText(newGame.checkValid(guess.getText()));//Check if guess is valid and set text to invalid if it isnt

      letterWord.setText((newGame.getArrayWord()));//Replace place holders to letter 
      
      guessedLetters.setText("Letters guessed: " + newGame.getAlreadyGuessedLettersList());//Update already guessed letters JLabel
      guessedWords.setText("Words guessed: " + newGame.getAlreadyGuessedWordsList());//Update already guessed words JLabel
      numGuesses.setText("Guesses Remaining: " + newGame.getNumGuesses());//Update num guesses

      this.displayImage();//Display character

      if (newGame.getGameOver().equals("Win")) {
        Win win = new Win();//If the user won, create new win window
        frame.dispose();
      } else if ((newGame.getGameOver().equals("Loss"))) {
        Loss loss = new Loss();//If the user lost, create new lost window
        frame.dispose();
      }
      frame.repaint();//Repaint frame
    }
  }

  public void displayImage() {//Display character relative to numguesses
    switch (newGame.getNumGuesses()) {
      case 15:
        character.setIcon(scaledCharacter1);
        break;
      case 14:
          character.setIcon(scaledCharacter2);
        break;
      case 13:
        character.setIcon(scaledCharacter3);
        break;
      case 12:
        character.setIcon(scaledCharacter4);
        break;
      case 11:
        character.setIcon(scaledCharacter5);
        break;
      case 10:
        character.setIcon(scaledCharacter6);
        break;
      case 9:
        character.setIcon(scaledCharacter7);
        break;
      case 8:
        character.setIcon(scaledCharacter8);
        break;
      case 7:
        character.setIcon(scaledCharacter9);
        break;
      case 6:
        character.setIcon(scaledCharacter10);
        break;
      case 5:
        character.setIcon(scaledCharacter11);
        break;
      case 4:
        character.setIcon(scaledCharacter12);
        break;
      case 3:
        character.setIcon(scaledCharacter13);
        break;
      case 2:
        character.setIcon(scaledCharacter14);
        break;
      case 1:
        character.setIcon(scaledCharacter15);
        break;
      case 0:
        break;

    }
  }

  public static void main(String[] args) {
    new Main();
  }

}