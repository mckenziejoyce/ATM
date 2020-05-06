package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class AccountTransfer{
  private JFrame frame;

  public AccountTransfer(Customer c, Manager m){
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
    JLabel headerMessage = new JLabel("Account Transfer");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("You have the following accounts:");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    //Figure out how to pull from database to display accounts here
    int y = 25;
    //Figure out how to get the real number for this
    int numOfAccounts = c.numOfAccounts();
    int i = 0;
    while(i < numOfAccounts){
      y += 15;
      String acc = "Account "+(i+1)+":";
      JLabel accLabel = new JLabel(acc);
      accLabel.setBounds(19,y,200,25);
      panel.add(accLabel);
      y += 15;
      JLabel accType = new JLabel("Account type:");
      accType.setBounds(30,y, 200, 25);
      JLabel type = new JLabel(c.getAccounts().get(i).getType());
      type.setBounds(150,y, 200, 25);
      panel.add(accType);
      panel.add(type);
      y += 15;
      JLabel accNum = new JLabel("Account number:");
      accNum.setBounds(30,y, 200, 25);
      panel.add(accNum);
      JLabel num = new JLabel(c.getAccounts().get(i).getAccountNumber());
      num.setBounds(150,y, 200, 25);
      panel.add(num);
      y += 15;
      JLabel accBalance = new JLabel("Account balance:");
      accBalance.setBounds(30,y, 200, 25);
      panel.add(accBalance);
      JLabel balance = new JLabel(Double.toString(c.getAccounts().get(i).getBalance()) + " " + c.getCurrency());
      balance.setBounds(150,y, 200, 25);
      panel.add(balance);
      y += 10;
      i++;
    }
    y += 25;

    JLabel lineTwo = new JLabel("Enter the account number you want to transfer from");
    lineTwo.setBounds(5,y,300,25);
    panel.add(lineTwo);

    y += 20;
    JTextField userText = new JTextField(50);
    userText.setBounds(5,y,165,25);
    panel.add(userText);
    y+= 20;

    JLabel lineThree = new JLabel("Enter the account number you want to transfer to");
    lineThree.setBounds(5,y,300,25);
    panel.add(lineThree);
    y+= 20;

    JTextField userText2 = new JTextField(50);
    userText2.setBounds(5,y,165,25);
    panel.add(userText2);
    y += 20;

    JLabel lineFour = new JLabel("Amount of money you want to transfer");
    lineFour.setBounds(5,y,300,25);
    panel.add(lineFour);
    y+= 20;

    JTextField userText3 = new JTextField(50);
    userText3.setBounds(5,y,165,25);
    panel.add(userText3);
    y += 30;

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(40, y, 100, 25);
    submitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String account = userText.getText();
        int accNum = Integer.parseInt(account);
        String account2 = userText2.getText();
        int accNum2 = Integer.parseInt(account2);
        String moneyStr = userText3.getText();
        double money = Double.valueOf(moneyStr);

        ArrayList<Account> acc = c.getAccounts();
        boolean cont = accNum <= acc.size();
        if(cont){
          Account curAccount = c.getAccounts().get(accNum-1);
          frame.dispose();
          new TransferSuccess(c, m, accNum, accNum2, money);
        }
        else{
          userText.setText("");
          new InvalidEntryPopUp("That account does not exist");
        }
        }});
    panel.add(submitButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new TransactionsScreen(c, m);
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 90, 130, 50);
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