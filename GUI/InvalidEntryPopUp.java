package GUI;
import javax.swing.*;
import java.awt.event.*;

public class InvalidEntryPopUp{
  private JFrame frame;
  private String errorMessage;
  private String tryAgain;


  public InvalidEntryPopUp(){
    frame = new JFrame("MyATM");
    frame.setSize(300, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    errorMessage = "Invalid Entry";
    tryAgain = "Please try again";
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);

  }
  public InvalidEntryPopUp(String message){
    frame = new JFrame("MyATM");
    frame.setSize(300, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    errorMessage = message;
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    panel.setLayout(null);

    JLabel lineOne = new JLabel(errorMessage);
    lineOne.setBounds(100,30,200,25);
    panel.add(lineOne);

    JLabel lineTwo = new JLabel(tryAgain);
    lineTwo.setBounds(90,45,200,25);
    panel.add(lineTwo);

    JButton okButton = new JButton("OK");
    okButton.setBounds(110, 70, 50, 25);
    okButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          frame.dispose();
      }});
    panel.add(okButton);
  }

}
