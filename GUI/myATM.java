import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myATM{
  private JFrame frame;

  public static void main(String[] args){
    setUpFrame();
  }
  private static void setUpFrame(){
    welcomePage firstScreen = new welcomePage();
    firstScreen.setVisible(true);
  }
}
