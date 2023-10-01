import javax.swing.*;//imports
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Customwords extends JComponent implements ActionListener, KeyListener {// implements action listner and key
                                                                                    // listnener

  private Game newGame;// inialize variables
  private JFrame frame;
  private JLabel newWords;
  private JLabel oldWords;
  private Font textFieldFont;
  private Font letterWordFont;
  private JButton playButton;
  private JTextField name, fileName, words;
  private ImageIcon backgroundImage;
  private JLabel background;
  private File validWords, christmasWords, jungleWords;

  Customwords(Game newGame) {

    this.newGame = newGame;// Pass new game
    frame = new JFrame();// Create a new instance of a frame

    File validWords = new File("words.txt");// Set files
    File christmasWords = new File("christmasWords.txt");
    File jungleWords = new File("jungleWords.txt");

    validWords.setWritable(false);// Set files to unwrittable
    christmasWords.setWritable(false);
    jungleWords.setWritable(false);

    newWords = new JLabel();// Create a Jlabel to display new words
    newWords.setBounds(100, 30, 300, 47);
    newWords.setFont(new Font("ComicSans", Font.BOLD, 25));
    newWords.setText("New Words");

    oldWords = new JLabel();// Create a Jlabel to display old words
    oldWords.setBounds(400, 30, 300, 47);
    oldWords.setText("Play File");
    oldWords.setFont(new Font("ComicSans", Font.BOLD, 25));

    playButton = new JButton();// Create a jbutton to start game
    playButton.setBounds(650, 100, 100, 47);
    playButton.setText("Play");
    playButton.addActionListener(this);

    Font textFieldFont = new Font("ComicSans", Font.BOLD, 25);// Create Jtextfield to enter name of file
    name = new JTextField();
    name.setBounds(100, 100, 250, 45);
    name.setText("Filename");
    name.setFont(textFieldFont);

    words = new JTextField();// Create Jtextfield to enter words
    words.setBounds(100, 160, 250, 45);
    words.setText("Words (Press Enter)");
    words.setFont(textFieldFont);

    fileName = new JTextField();// Create Jtextfield to enter play file
    fileName.setBounds(400, 100, 250, 45);
    fileName.setText("Filename");
    fileName.setFont(textFieldFont);

    background = new JLabel();// Set background
    backgroundImage = new ImageIcon("Images/Chalkboard.png");
    background.setBounds(0, 0, 800, 400);

    Image imgBackground = backgroundImage.getImage();
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    background.setIcon(scaledBackground);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Add instances to frame
    frame.add(name);
    frame.add(fileName);
    frame.add(words);
    frame.add(newWords);
    frame.add(oldWords);
    frame.add(playButton);
    frame.add(background);

    frame.setSize(800, 400);// Set frane
    frame.setLayout(null);
    frame.setVisible(true);
    words.addKeyListener(this);

  }

  public void keyTyped(KeyEvent e) {// Abstrac class

  }

  public void keyPressed(KeyEvent e) {
    int n = e.getKeyCode();// Get key code
    if (e.getKeyText(n).equals("Enter")) {// If the keycode is equal to enter run
      try {
        if (isWord(words.getText()) == true) {// Check if the word is a word

          FileWriter fw = new FileWriter(name.getText() + ".txt", true);// Set a text file
          PrintWriter pw = new PrintWriter(fw);

          pw.println(words.getText());// Print the word to the text file
          words.setText("");
          pw.close();
        } else {
          words.setText("Invalid Input");
        }
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }

    else if (words.getText().equals("Invalid Input") || (words.getText().equals("Words (Press Enter)"))) {// Automatically
                                                                                                          // replace if
                                                                                                          // a key is
                                                                                                          // pressed
      words.setText("");
    }

  }

  public void keyReleased(KeyEvent e) {

  }

  public boolean isWord(String g) {// isWord function
    try {
      FileReader fr = new FileReader("words.txt");
      BufferedReader br = new BufferedReader(fr);

      int min = 0;
      int max = 10163;
      int mid;
      while (min <= max) {// Binary search to find the word

        mid = (min + max) / 2;

        if (g.equals(Files.readAllLines(Paths.get("words.txt")).get(mid))) {
          if (g.length() > 2) {
            return true;
          } else {
            return false;
          }
        } else if (g.compareTo(Files.readAllLines(Paths.get("words.txt")).get(mid)) > 0) {
          min = mid + 1;
        } else {
          max = mid - 1;
        }
      }
      br.close();

      return false;
    } catch (IOException e) {
      return false;
    }
  }

  public void actionPerformed(ActionEvent e) {// If play is pressed, set unknown word abd start gane
    if (e.getSource() == playButton) {
      try {
        FileReader fr = new FileReader(fileName.getText() + ".txt");
        newGame.setFileName(fileName.getText());
        newGame.setUnknownWord();
        GameGUI game = new GameGUI(newGame);

        frame.dispose();
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }

  public static void main(String[] args) {
    new Main();
  }

}