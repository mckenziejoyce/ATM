package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class CustomerWelcomeScreen{
  private JFrame frame;

  public CustomerWelcomeScreen(Customer c, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //setUpPage();
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, m);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, Manager m){
    c.isRich(); //Checks if customer is rich to open up options

    panel.setLayout(null);
    JLabel welcomeMessage = new JLabel("Welcome " + c.getName() + "!");
    welcomeMessage.setBounds(5,5,200,25);
    panel.add(welcomeMessage);

    JLabel identityMessage = new JLabel("What would you like to do?");
    identityMessage.setBounds(5,25,200,25);
    panel.add(identityMessage);

    JButton transactionsButton = new JButton("Transactions");
    transactionsButton.setBounds(10, 70, 200, 30);
    transactionsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new TransactionsScreen(c, m);
        }});
    panel.add(transactionsButton);

    JButton accManButton = new JButton("Account Management");
    accManButton.setBounds(10, 100, 200, 30);
    accManButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountManagementScreen(c, m);
        }});
    panel.add(accManButton);

    int y = 130;
    JButton loanButton = new JButton("Loan Options");
    loanButton.setBounds(10, y, 200, 30);
    loanButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new LoanScreen(c, m);
        }});
    panel.add(loanButton);
    y+=30;

    if(c.getRich() || c.gethasSecurity()){
      JButton stocksButton = new JButton("Trade Stocks and Security");
      stocksButton.setBounds(10, y, 200, 30);
      stocksButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          frame.dispose();
          new StockWelcomeScreen(c, m);
          }});
      panel.add(stocksButton);
      y+=30;
    }
    

    JButton currecyButton = new JButton("Currency Settings");
    currecyButton.setBounds(10, y, 200, 30);
    currecyButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CurrencySettingsScreen(c, m);
        }});
    panel.add(currecyButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(250, 120, 200, 30);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new WelcomeScreen(c, m);
        }});
    panel.add(logoutButton);

    //Checks if month has passed to increase the loan
    if(c.getLoan() != null && c.getLoan().monthPass()){
      c.getLoan().increaseLoan();
    }

  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
