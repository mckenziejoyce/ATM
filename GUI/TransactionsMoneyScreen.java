package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;


public class TransactionsMoneyScreen{
  private JFrame frame;

  public TransactionsMoneyScreen(Customer c, String aNumber, String action, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, aNumber, action, m);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, String aNumber, String action, Manager m){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Transactions");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    // Figure out how to pull this information
    JLabel lineOne = new JLabel("You chose account " + aNumber);
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    // Figure out how to pull and display account info
    JLabel accType = new JLabel("Account type:");
    JLabel accNum = new JLabel("Account number:");
    JLabel accBalance = new JLabel("Account balance:");
    accType.setBounds(30,40, 200, 25);
    accNum.setBounds(30,55, 200, 25);
    accBalance.setBounds(30,70, 200, 25);
    panel.add(accType);
    panel.add(accNum);
    panel.add(accBalance);

    Account curAccount = c.getAccounts().get(Integer.parseInt(aNumber) - 1);
    // FIgure out how to pull the real info for this
    JLabel type = new JLabel(curAccount.getType());
    JLabel num = new JLabel(curAccount.getAccountNumber());
    JLabel balance = new JLabel(Double.toString(curAccount.getBalance()) + " " + c.getCurrency());
    type.setBounds(150,40, 200, 25);
    num.setBounds(150,55, 200, 25);
    balance.setBounds(150,70, 200, 25);
    panel.add(type);
    panel.add(num);
    panel.add(balance);

    JLabel lineTwo = new JLabel("Enter the amount you wish to " + action);
    lineTwo.setBounds(5,95,300,25);
    panel.add(lineTwo);

    JTextField userText = new JTextField(50);
    userText.setBounds(5,120,165,25);
    panel.add(userText);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(35, 145, 100, 25);
    submitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String money = userText.getText();
        int moneyNum = Integer.parseInt(money);
        if(action.compareTo("Withdraw")==0){
          if(curAccount.getBalance()-moneyNum >= 0){
            frame.dispose();
            new TransactionsSuccessScreen(c, m, aNumber, money, action);
          }
          else{
            userText.setText("");
            new InvalidEntryPopUp("You do not have enough funds");
          }
        }
        else{
          new TransactionsSuccessScreen(c, m, aNumber, money, action);
        }
        }});
    panel.add(submitButton);

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
