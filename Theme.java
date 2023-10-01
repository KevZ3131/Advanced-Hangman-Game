import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Theme extends JComponent implements MouseListener, ActionListener {
  private Game newGame;

  private JFrame frame;

  private ImageIcon backgroundImage;// Initalize background
  private JLabel background;
  private ImageIcon winterImage;// Initalize image icons
  private ImageIcon jungleImage;
  private ImageIcon customImage;
  private ImageIcon scaledWinterLarge;
  private ImageIcon scaledWinter;
  private ImageIcon scaledJungle;
  private ImageIcon scaledJungleLarge;
  private ImageIcon scaledCustom;
  private ImageIcon scaledCustomLarge;
  private ImageIcon scaledBackground;
  private ImageIcon scaledChristmasBackground;
  private ImageIcon scaledBunnyBackground;
  private ImageIcon scaledChalkboard;
  private JButton winter;// Initalize theme buttons
  private JButton jungle;
  private JButton custom;

  Theme(Game newGame) {

    this.newGame = newGame;// Create an instance of the new game class

    frame = new JFrame();// Create a new instance of a frame

    background = new JLabel();// Initalize background
    backgroundImage = new ImageIcon("Images/MainMenu.png");
    background.setBounds(0, 0, 800, 400);

    winter = new JButton();// Create winter button and set bounds and add action listner
    winter.setBounds(280, 50, 170, 57);
    winterImage = new ImageIcon("Images/winterButton.png");// Initalize winter button image to image icon
    winter.addActionListener(this);

    jungle = new JButton();// Create winter button and set bounds and add action listner
    jungleImage = new ImageIcon("Images/BunnyButton.png");// Initalize bunny button image to image icon
    jungle.setBounds(280, 140, 170, 57);
    jungle.addMouseListener(this);
    jungle.addActionListener(this);

    custom = new JButton();// Create winter button and set bounds and add action listner
    custom.setBounds(280, 230, 168, 57);
    customImage = new ImageIcon("Images/Sickman.png");// Initalize custom image to custom image icon
    custom.setText("Custom");
    custom.addMouseListener(this);
    custom.addActionListener(this);

    Image imgBackground = backgroundImage.getImage();// Scale background
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    scaledBackground = new ImageIcon(imgScaleBackground);

    Image imgBunnyBackground = new ImageIcon("Images/BunnyBackground.png").getImage();// Scale bunny background
    Image imgScaleBunnyBackground = imgBunnyBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    scaledBunnyBackground = new ImageIcon(imgScaleBunnyBackground);

    Image imgChalkboardBackground = new ImageIcon("Images/Chalkboard.png").getImage();// Scale chalkboard background
    Image imgScaleChalkboardBackground = imgChalkboardBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    scaledChalkboard = new ImageIcon(imgScaleChalkboardBackground);

    Image imgChristmasBackground = new ImageIcon("Images/Christmas.png").getImage();// Scale christmas background
    Image imgScaleChristmasBackground = imgChristmasBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    scaledChristmasBackground = new ImageIcon(imgScaleChristmasBackground);

    Image imgWinter = winterImage.getImage(); // Scale winter image button
    Image imgScaleWinter = imgWinter.getScaledInstance(200, 80, Image.SCALE_SMOOTH);
    scaledWinter = new ImageIcon(imgScaleWinter);

    Image imgWinterLarge = winterImage.getImage();// Scale large winter image button
    Image imgScaleWinterLarge = imgWinterLarge.getScaledInstance(230, 130, Image.SCALE_SMOOTH);
    scaledWinterLarge = new ImageIcon(imgScaleWinterLarge);

    Image imgJungle = jungleImage.getImage();// Scale jungle image button
    Image imgScaleJungle = imgJungle.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
    scaledJungle = new ImageIcon(imgScaleJungle);

    Image imgJungleLarge = jungleImage.getImage();// Scale large jungle image button
    Image imgScaleJungleLarge = imgJungleLarge.getScaledInstance(225, 125, Image.SCALE_SMOOTH);
    scaledJungleLarge = new ImageIcon(imgScaleJungleLarge);

    Image imgCustom = customImage.getImage();// Scale custom image button
    Image imgScaleCustom = imgCustom.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    scaledCustom = new ImageIcon(imgScaleCustom);

    Image imgCustomLarge = customImage.getImage();// Scale large sutom image button
    Image imgScaleCustomLarge = imgCustomLarge.getScaledInstance(60, 70, Image.SCALE_SMOOTH);
    scaledCustomLarge = new ImageIcon(imgScaleCustomLarge);

    background.setIcon(scaledBackground); // Set icons
    winter.setIcon(scaledWinter);
    jungle.setIcon(scaledJungle);
    custom.setIcon(scaledCustom);

    custom.setVerticalTextPosition(JButton.CENTER);// Ceneter text in custom button
    custom.setHorizontalTextPosition(JButton.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Add instances to frame
    frame.add(winter);
    frame.add(jungle);
    frame.add(custom);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    winter.addMouseListener(this);
  }

  public void mouseEntered(MouseEvent e) {// Mouse entered action listener
    if (e.getSource() == winter) {// Scale image if the mouse enters button bounds
      winter.setIcon(scaledWinterLarge);
      background.setIcon(scaledChristmasBackground);
    } else if (e.getSource() == jungle) {
      jungle.setIcon(scaledJungleLarge);
      background.setIcon(scaledBunnyBackground);
    } else if (e.getSource() == custom) {

      custom.setIcon(scaledCustomLarge);
      background.setIcon(scaledChalkboard);
    }
    frame.repaint();

  }

  public void mouseExited(MouseEvent e) {// Mouse entered action listener
    if (e.getSource() == winter) {// Scale image if the mouse exits button bounds
      winter.setIcon(scaledWinter);
      background.setIcon(scaledBackground);
    } else if (e.getSource() == jungle) {
      jungle.setIcon(scaledJungle);
      background.setIcon(scaledBackground);
    } else if (e.getSource() == custom) {
      custom.setIcon(scaledCustom);
      background.setIcon(scaledBackground);
    }
    frame.repaint();

  }

  public void mouseReleased(MouseEvent e) {// Abstract class

  }

  public void mouseClicked(MouseEvent e) {

  }

  public void mousePressed(MouseEvent e) {

  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == winter) {// Set theme, unknown word, themed text file and start game
      frame.dispose();
      newGame.setTheme("Winter");
      newGame.setFileName("christmasWords");
      newGame.setUnknownWord();
      GameGUI game = new GameGUI(newGame);

    } else if (e.getSource() == jungle) {
      frame.dispose();
      newGame.setTheme("Bunny");
      newGame.setFileName("jungleWords");
      newGame.setUnknownWord();
      GameGUI game = new GameGUI(newGame);

    } else if (e.getSource() == custom) {
      frame.dispose();
      newGame.setTheme("Customword");
      Customwords menu = new Customwords(newGame);

    }
  }

  public static void main(String[] args) {
    new Main();
  }

}