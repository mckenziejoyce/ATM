package GUI;
import OOP.*;

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
    Customer c = new Customer("Anthony"); //Test customer
    WelcomeScreen firstScreen = new WelcomeScreen(c);
    firstScreen.setVisible(true);
  }
}
