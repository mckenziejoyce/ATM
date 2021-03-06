package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class OpenNewAccountScreen{
  private JFrame frame;

  public OpenNewAccountScreen(Customer c, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, m);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, Manager m){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Open a New Account");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel identityMessage = new JLabel("What type of account would you like to open?");
    identityMessage.setBounds(5,25,300,25);
    panel.add(identityMessage);

    JButton withdrawButton = new JButton("Checking");
    withdrawButton.setBounds(10, 70, 200, 30);
    withdrawButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new NewAccountConfirmationScreen("c", c, m);
        }});
    panel.add(withdrawButton);

    JButton depositButton = new JButton("Savings");
    depositButton.setBounds(10, 100, 200, 30);
    depositButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new NewAccountConfirmationScreen("s", c, m);
        }});
    panel.add(depositButton);

    if(c.getRich()){
      JButton securityButton = new JButton("Security");
      securityButton.setBounds(10, 130, 200, 30);
      securityButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new NewAccountConfirmationScreen("sc", c, m);
        }});
      panel.add(securityButton);
    }

    JButton backButton = new JButton("Back");
    backButton.setBounds(330, 35, 100, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountManagementScreen(c, m);
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(330, 90, 100, 50);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new WelcomeScreen(c, m);
        }});
    panel.add(logoutButton);
  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
