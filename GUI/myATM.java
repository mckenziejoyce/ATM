package GUI;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyATM{
  private JFrame frame;

  public static void main(String[] args){
    setUpFrame();
  }
  private static void setUpFrame(){
    WelcomeScreen firstScreen = new WelcomeScreen();
    firstScreen.setVisible(true);
  }
}
