//https://stackoverflow.com/questions/15558202/how-to-resize-image-in-java: used to scaled images 
//Image imgPlay = playImage.getImage(); 
//Image imgScalePlay = imgPlay.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
//scaledPlay = new ImageIcon(imgScalePlay);

import java.awt.Color; //Import java swing and Abstract Window Toolkit
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MainMenu extends JComponent implements MouseListener, ActionListener {//Main class

  private JFrame frame; //Initalize frame
  private ImageIcon backgroundImage;//Initalize background
  private JLabel background;
  private ImageIcon playImage; //Initalize image icons
  private ImageIcon instructionImage;
  private ImageIcon exitImage;
  private ImageIcon scaledPlayLarge;
  private ImageIcon scaledPlay;
  private ImageIcon scaledInstruction;
  private ImageIcon scaledInstructionLarge;
  private ImageIcon scaledExit;
  private ImageIcon scaledExitLarge;
  private JButton play;//Initalize buttons
  private JButton instruction;
  private JButton exit;

  MainMenu() { //Main constructor
    frame = new JFrame(); //Create a new instance of a frame

    background = new JLabel(); //Create a new instance of a background
    backgroundImage = new ImageIcon("Images/MainMenu.png"); //Import a new image icon
    background.setBounds(0, 0, 800, 400);//Set background bounds

    play = new JButton();//Create a new instance of the play button and set bounds
    play.setBounds(280, 50, 170, 67);
    playImage = new ImageIcon("Images/Play.png"); //Import image and add action listener
    play.addActionListener(this);
    play.addMouseListener(this);

    instruction = new JButton(); //Create a new instance of the instruction button and set bounds
    instruction.setBounds(280, 140, 170, 67);
    instructionImage = new ImageIcon("Images/Instruction.png");//Import image and add a action listener
    instruction.addMouseListener(this);
    instruction.addActionListener(this);

    exit = new JButton();//Create a new instance of the exit button and set bounds
    exit.setBounds(280, 230, 170, 67);
    exitImage = new ImageIcon("Images/Exit.png");//Import image and add a action listener
    exit.addMouseListener(this);
    exit.addActionListener(this);

    Image imgBackground = backgroundImage.getImage(); //Scale background image
    Image imgScaleBackground = imgBackground.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledBackground = new ImageIcon(imgScaleBackground);

    Image imgPlay = playImage.getImage();// Scale play button image
    Image imgScalePlay = imgPlay.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledPlay = new ImageIcon(imgScalePlay);

    Image imgPlayLarge = playImage.getImage();// Scale large play button image
    Image imgScalePlayLarge = imgPlayLarge.getScaledInstance(230, 130, Image.SCALE_SMOOTH);
    scaledPlayLarge = new ImageIcon(imgScalePlayLarge);

    Image imgInstruction = instructionImage.getImage();// Scale instruction button image
    Image imgScaleInstruction = imgInstruction.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledInstruction = new ImageIcon(imgScaleInstruction);

    Image imgInstructionLarge = instructionImage.getImage();// Scale large instruction button image
    Image imgScaleInstructionLarge = imgInstructionLarge.getScaledInstance(225, 125, Image.SCALE_SMOOTH);
    scaledInstructionLarge = new ImageIcon(imgScaleInstructionLarge);

    Image imgExit = exitImage.getImage();// Scale exit button image
    Image imgScaleExit = imgExit.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    scaledExit = new ImageIcon(imgScaleExit);

    Image imgExitLarge = exitImage.getImage();// Scale large exit button image
    Image imgScaleExitLarge = imgExitLarge.getScaledInstance(225, 125, Image.SCALE_SMOOTH);
    scaledExitLarge = new ImageIcon(imgScaleExitLarge);

    background.setIcon(scaledBackground); //set icons
    play.setIcon(scaledPlay);
    instruction.setIcon(scaledInstruction);
    exit.setIcon(scaledExit);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Add instances to frame
    frame.add(play);
    frame.add(instruction);
    frame.add(exit);
    frame.add(background);
    frame.setSize(800, 400);
    frame.setLayout(null);
    frame.setVisible(true);
  }


  public void mouseEntered(MouseEvent e) { //Mouse entered event listener
    if (e.getSource() == play) { //If mouse enters the bounds of a button scale the image
      play.setIcon(scaledPlayLarge);
    } else if (e.getSource() == instruction) {
      instruction.setIcon(scaledInstructionLarge);
    } else if (e.getSource() == exit) {
      exit.setIcon(scaledExitLarge);
    }
  }

  public void mouseExited(MouseEvent e) {//Mouse exit event listener
    if (e.getSource() == play) {//If mouse exits the bounds of a button, reset the  scale of the image
      play.setIcon(scaledPlay);
    } else if (e.getSource() == instruction) {
      instruction.setIcon(scaledInstruction);
    } else if (e.getSource() == exit) {
      exit.setIcon(scaledExit);
    }

  }


    public void actionPerformed(ActionEvent e) {//Action performed class
    if (e.getSource() == play) {//If player clicks plays, go to difficulty screen and dispose frame
      frame.dispose();
      Difficulty difficulty = new Difficulty();
    }

    else if (e.getSource() == instruction) {//If player clicks instruction, go to difficulty screen and dispose frame
      frame.dispose();
      Instruction instruction = new Instruction();
    }
    
    else if (e.getSource() == exit) {//If player clicks exit, exit
      System.exit(0);
    }
  }

  
  public void mouseClicked(MouseEvent e) { //Abstract class for mouse

  }

  public void mousePressed(MouseEvent e) {

  }

  public void mouseReleased(MouseEvent e) {

  }


  public static void main(String[] args) {
    new Main();
  }

}