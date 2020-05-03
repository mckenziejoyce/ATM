package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class CurrencySettingsScreen{
  private JFrame frame;

  public CurrencySettingsScreen(){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    int x = 5;
    int y = 5;
    panel.setLayout(null);

    JLabel headerMessage = new JLabel("Currency Settings");
    headerMessage.setBounds(5,y,300,25);
    panel.add(headerMessage);

    y+= 25;
    JLabel lineOne = new JLabel("Default Currency is USD");
    lineOne.setBounds(5,y,300,25);
    panel.add(lineOne);

    y+= 25;
    JLabel lineTwo = new JLabel("Your current trade/display currency is");
    lineTwo.setBounds(5,y,300,25);
    panel.add(lineTwo);

    // Figure out how to fill this in
    y+= 15;
    JLabel curCurr = new JLabel("XXXXXXXXXXXX");
    curCurr.setBounds(15,y,300,25);
    panel.add(curCurr);

    y+= 20;
    JLabel lineThree = new JLabel("Choose your trade/display currency");
    lineThree.setBounds(5,y,300,25);
    panel.add(lineThree);

    y+= 20;
    JButton currOneButton = new JButton("USD");
    currOneButton.setBounds(15, y, 150, 25);
    currOneButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        // FIGURE OUT HOW TO UPDATE CURRENCY
        new CustomerWelcomeScreen();
        }});
    panel.add(currOneButton);

    y+= 30;
    JButton currTwoButton = new JButton("Currency 2");
    currTwoButton.setBounds(15, y, 150, 25);
    currTwoButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        // FIGURE OUT HOW TO UPDATE CURRENCY
        new CustomerWelcomeScreen();
        }});
    panel.add(currTwoButton);

    y+= 30;
    JButton currThreeButton = new JButton("Currency 3");
    currThreeButton.setBounds(15, y, 150, 25);
    currThreeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        // FIGURE OUT HOW TO UPDATE CURRENCY
        new CustomerWelcomeScreen();
        }});
    panel.add(currThreeButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        // FIGURE OUT HOW TO UPDATE CURRENCY
        new CustomerWelcomeScreen();
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 90, 130, 50);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new WelcomeScreen();
        }});
    panel.add(logoutButton);
  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
