import javax.swing.JFrame;//imports
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JComponent implements MouseListener, ActionListener {//implements action and mouse listener
  
  private JFrame frame;//initalize variables
  private ImageIcon backgroundImage;
  private JLabel background;
  private JLabel instructions;
  private JButton home;
  private ImageIcon homeImage;
  private ImageIcon scaledHomeLarge;
  private ImageIcon scaledHome;
  


  Instruction() {
    frame = new JFrame();//create a new frame

    background = new JLabel();//set background
    backgroundImage = new ImageIcon("Images/MainMenu.png");
    background.setBounds(0, 0, 800, 400);

    home = new JButton();//set home button
    home.setBounds(590, 300, 170, 60);
    homeImage = new ImageIcon("Images/Home.png");
    home.addActionListener(this);

    //set instructions to a jlabel
    instructions = new JLabel("<html>Buildman: Depending on the difficulty, you will have either 15, 12, or 10 <br/>guesses and words get harder. There are two themes, winter theme and jungle theme. Words, background, and character are all themed. <br/> Keep this in mind because this may help in guesses the word. If you want to make your own words, use custom words. You can either add more words to an already exitisng list, or create your own list. Then, you can choose which file to play with.</html>");
    instructions.setFont(new Font("ComicSans", Font.BOLD, 17));
    instructions.setBounds(10,-20,800,400);


    Image imgBackground = backgroundImage.getImage(); //scaled background images 
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    Image imgHome = homeImage.getImage();//set home button image
    Image imgScaleHome = imgHome.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledHome = new ImageIcon(imgScaleHome);

    Image imgHomeLarge = homeImage.getImage();//scale home button image
    Image imgScaleHomeLarge = imgHomeLarge.getScaledInstance(230, 130, Image.SCALE_SMOOTH);
    scaledHomeLarge = new ImageIcon(imgScaleHomeLarge);


    background.setIcon(scaledBackground);//set icons
    home.setIcon(scaledHome);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add instances to frame
    frame.add(home);
    frame.add(instructions);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    home.addMouseListener(this);
  }


  public void mouseEntered(MouseEvent e) {
    if (e.getSource() == home) {//If mouse enters the bounds of the home button, largen it
      home.setIcon(scaledHomeLarge);
    } 

  }

  public void mouseExited(MouseEvent e) {
    if (e.getSource() == home) {//If mouse exits the bounds of the home button, set it back to normal
      home.setIcon(scaledHome);
    }

  }

  public void mouseClicked(MouseEvent e) {//empty abstract class 

  }

  public void mousePressed(MouseEvent e) {

  }

  public void mouseReleased(MouseEvent e) {

  }

  public void actionPerformed(ActionEvent e) {//Action performed
    if (e.getSource() == home) {//If user wants to exit, create a new instance of the main menu
      frame.dispose();
        MainMenu start= new MainMenu();
    }
  }

  public static void main(String[] args) {
    new Main();
  }

}