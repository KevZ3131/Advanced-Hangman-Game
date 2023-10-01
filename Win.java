import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JComponent implements ActionListener {//Implement action listener
  private JFrame frame;//Initalize varaibles
  private ImageIcon backgroundImage;
  private JLabel background;
  private JButton home;
  private JButton quit;


  Win() {
    frame = new JFrame();// New instance of a frame

    background = new JLabel();// Initalize background
    backgroundImage = new ImageIcon("Images/Win.png");
    background.setBounds(0, 0, 800, 400);

    home = new JButton();//New button
    home.setBounds(400, 300, 300, 60);
    home.setText("Play Again"); // Set text to play again
    home.setBorderPainted(false);// Remove background of Jlabel
    home.setContentAreaFilled(false);
    home.setFocusPainted(false);
    home.setOpaque(false);
    home.setFont(new Font("Comic Sans", Font.BOLD, 32));
    home.setForeground(Color.WHITE);
    home.addActionListener(this);//Add action listener

    quit = new JButton();//New button
    quit.setBounds(100, 300, 300, 60);
    quit.setText("Quit");
    quit.setBorderPainted(false);
    quit.setContentAreaFilled(false);
    quit.setFocusPainted(false);
    quit.setOpaque(false);
    quit.setFont(new Font("Comic Sans", Font.BOLD, 32));
    quit.setForeground(Color.WHITE);
    quit.addActionListener(this);

    Image imgBackground = backgroundImage.getImage();//Scale background image
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    background.setIcon(scaledBackground);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(quit);
    frame.add(home);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  



  public void actionPerformed(ActionEvent e) {//Action performed
    if (e.getSource() == home) {//if user presses home, create a new instance of the main menu

      MainMenu start = new MainMenu();
      frame.dispose();
    }

    else if (e.getSource() == quit) {//Else if the user wants to exit, end the program
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new Main();
  }

}