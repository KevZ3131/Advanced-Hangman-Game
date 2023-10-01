import javax.swing.JPanel;//imports
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty extends JComponent implements MouseListener, ActionListener {//implement mouse and action listnener
  private Game newGame; //Initalize game
  private ImageIcon backgroundImage; //Initalize image icon
  private JFrame frame;//Initalize frame
  private JLabel background;//Initalize background
  private ImageIcon easyImage;//Initalize image icons
  private ImageIcon normalImage;
  private ImageIcon hardImage;
  private ImageIcon scaledEasyLarge;
  private ImageIcon scaledEasy;
  private ImageIcon scaledNormal;
  private ImageIcon scaledNormalLarge;
  private ImageIcon scaledHard;
  private ImageIcon scaledHardLarge;
  private JButton easy;//Initalize easy, normal hard
  private JButton normal;
  private JButton hard;

  Difficulty() {

    newGame = new Game();//Create instance of a new game

    frame = new JFrame();//Create instance of a frame

    background = new JLabel();//Set background
    backgroundImage = new ImageIcon("Images/MainMenu.png");
    background.setBounds(0, 0, 800, 400);

    easy = new JButton();//Create a new instance of the play button and set bounds
    easy.setBounds(280, 50, 170, 57);
    easyImage = new ImageIcon("Images/Easy.png");// Set new image icon for the easy button and add action listeners
    easy.addMouseListener(this);
    easy.addActionListener(this);

    normal = new JButton();//Create a new instance of the normal button and set bounds
    normal.setBounds(280, 140, 170, 57); 
    normalImage = new ImageIcon("Images/Normal.png");// Set a new image icon for the normal button and add action listeners
    normal.addMouseListener(this);
    normal.addActionListener(this);

    hard = new JButton();//Create a new instance of the hard button and set bounds
    hard.setBounds(280, 230, 168, 57);
    hardImage = new ImageIcon("Images/Hard.png");// Set  a new image icon for the hard button and add action listeners
    hard.addMouseListener(this);
    hard.addActionListener(this);

    Image imgBackground = backgroundImage.getImage();//Scale background
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    Image imgEasy = easyImage.getImage();//Scale easy image
    Image imgScaleEasy = imgEasy.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledEasy = new ImageIcon(imgScaleEasy);

    Image imgEasyLarge = easyImage.getImage();//Scale large easy image
    Image imgScaleEasyLarge = imgEasyLarge.getScaledInstance(230, 130, Image.SCALE_SMOOTH);
    scaledEasyLarge = new ImageIcon(imgScaleEasyLarge);

    Image imgNormal = normalImage.getImage();//Scale normal image
    Image imgScaleNormal = imgNormal.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledNormal = new ImageIcon(imgScaleNormal);

    Image imgNormalLarge = normalImage.getImage();//Scale large normal image
    Image imgScaleNormalLarge = imgNormalLarge.getScaledInstance(225, 125, Image.SCALE_SMOOTH);
    scaledNormalLarge = new ImageIcon(imgScaleNormalLarge);

    Image imgHard = hardImage.getImage();//Scale hard image
    Image imgScaleHard = imgHard.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledHard = new ImageIcon(imgScaleHard);

    Image imgHardLarge = hardImage.getImage();//Scale large hard image
    Image imgScaleHardLarge = imgHardLarge.getScaledInstance(225, 125, Image.SCALE_SMOOTH);
    scaledHardLarge = new ImageIcon(imgScaleHardLarge);

    background.setIcon(scaledBackground); //Set icons
    easy.setIcon(scaledEasy);
    normal.setIcon(scaledNormal);
    hard.setIcon(scaledHard);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Add instances to frame
    frame.add(easy);
    frame.add(normal);
    frame.add(hard);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);

  }


  public void mouseEntered(MouseEvent e) {//Mouse entered
    if (e.getSource() == easy) {//If mouse enters the bounds of a button, scale the image button
      easy.setIcon(scaledEasyLarge);
    } else if (e.getSource() == normal) {
      normal.setIcon(scaledNormalLarge);
    } else if (e.getSource() == hard) {

      hard.setIcon(scaledHardLarge);
    }

  }

  public void mouseExited(MouseEvent e) {//Mouse exit
    if (e.getSource() == easy) {//If mouse exits the bounds of a button, reset the  scale of the image
      easy.setIcon(scaledEasy);
    } else if (e.getSource() == normal) {
      normal.setIcon(scaledNormal);
    } else if (e.getSource() == hard) {
      hard.setIcon(scaledHard);
    }

  }

  public void mouseReleased(MouseEvent e) {//Abstract methods for mouse listener

  }
  
  public void mouseClicked(MouseEvent e) {

  }

  public void mousePressed(MouseEvent e) {

  }

  public void actionPerformed(ActionEvent e) {//Action performed
    if (e.getSource() == easy) {//Set the difficulty and create a new window
      frame.dispose();
      newGame.setDifficulty("Easy");
      Theme theme = new Theme(newGame);

    } else if (e.getSource() == normal) {
      frame.dispose();
      newGame.setDifficulty("Normal");
      Theme theme = new Theme(newGame);

    } else if (e.getSource() == hard) {
      frame.dispose();
      newGame.setDifficulty("Hard");
      Theme theme = new Theme(newGame);

    }
  }

  public static void main(String[] args) {
    new Main();
  }

}