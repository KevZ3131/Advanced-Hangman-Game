import java.awt.Color;//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Loss extends JComponent implements ActionListener {// im plement action listner
  private JFrame frame;//initalize variable
  private ImageIcon backgroundImage;
  private JLabel background;
  private JButton home;
  private JButton quit;


  Loss() {
    frame = new JFrame();// Initalize new frame

    background = new JLabel();// Initalize background
    backgroundImage = new ImageIcon("Images/Loss.png");
    background.setBounds(0, 0, 800, 400);

    home = new JButton(); // New home button
    home.setBounds(400, 300, 300, 60);
    home.setText("Play Again"); // Set text to play again
    home.setBorderPainted(false);// Remove background of Jlabel
    home.setContentAreaFilled(false);
    home.setFocusPainted(false);
    home.setOpaque(false);
    home.setFont(new Font("Comic Sans", Font.BOLD, 32));
    home.setForeground(Color.WHITE);
    home.addActionListener(this);// Add action listener

    quit = new JButton();// New quit button
    quit.setBounds(100, 300, 300, 60);
    quit.setText("Quit");// Set text to quit
    quit.setBorderPainted(false);// Remove background of Jlabel
    quit.setContentAreaFilled(false);
    quit.setFocusPainted(false);
    quit.setOpaque(false);
    quit.setFont(new Font("Comic Sans", Font.BOLD, 32));
    quit.setForeground(Color.WHITE);
    quit.addActionListener(this);// Add action listener

    Image imgBackground = backgroundImage.getImage();//Scale bakground
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    background.setIcon(scaledBackground);//Add icon
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Add instances to frame
    frame.add(quit);
    frame.add(home);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
  }


  public void actionPerformed(ActionEvent e) {//Actionperformed
    if (e.getSource() == home) {//If home button is pressed create a new instance of the main menu

      MainMenu start = new MainMenu();
      frame.dispose();
    }

    else if (e.getSource() == quit) {//Else if the uesr wants to exit, end the progmram
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new Main();
  }

}