
package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class ManagerWelcomeScreen{
  private JFrame frame;

  public ManagerWelcomeScreen(Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //setUpPage();
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, m);
    frame.setVisible(true);
  }
  private void placeComponents(JPanel panel, Manager m){
    panel.setLayout(null);
    JLabel welcomeMessage = new JLabel("Welcome!");
    welcomeMessage.setBounds(5,5,200,25);
    panel.add(welcomeMessage);

    JLabel identityMessage = new JLabel("What would you like to do?");
    identityMessage.setBounds(5,25,200,25);
    panel.add(identityMessage);

    JButton transactionsButton = new JButton("View Customer Transactions");
    transactionsButton.setBounds(10, 70, 250, 30);
    transactionsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new ManagerTransactionsScreen(m);
        }});
    panel.add(transactionsButton);

    JButton accManButton = new JButton("Check on a Customer");
    accManButton.setBounds(10, 100, 250, 30);
    accManButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CheckOnCustomerSelection(m);
        }});
    panel.add(accManButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(250, 100, 250, 30);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        Customer n = new Customer("Bob");
        new WelcomeScreen(n, m);
        }});
    panel.add(logoutButton);
  }
}
