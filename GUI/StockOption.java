package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class StockOption {
    private JFrame frame;

  public StockOption(Customer c, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, m);
    frame.setVisible(true);
  }
  private void placeComponents(JPanel panel, Customer c, Manager m){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Trade Stocks");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel identityMessage = new JLabel("What would you like to do?");
    identityMessage.setBounds(5,25,200,25);
    panel.add(identityMessage);

    JButton withdrawButton = new JButton("Buy");
    withdrawButton.setBounds(10, 70, 200, 30);
    withdrawButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new StockMarketScreen(c, "Buy", m);
        }});
    panel.add(withdrawButton);

    JButton depositButton = new JButton("Sell");
    depositButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(c.getSecurity().getOpening()== null){
          new InvalidEntryPopUp("You don't have stock to sell.");
        }
        else{
          frame.dispose();
          new StockMarketScreen(c, "Sell", m);
        }

        }});
    depositButton.setBounds(10, 100, 200, 30);
    panel.add(depositButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(330, 35, 100, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c, m);
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
