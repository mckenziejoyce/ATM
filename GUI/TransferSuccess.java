package GUI;
import OOP.*;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class TransferSuccess{
  private JFrame frame;

  public TransferSuccess(Customer c, Manager m, int accNum1, int accNum2, double money){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, m, accNum1, accNum2, money);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, Manager m, int accNum1, int accNum2, double money){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Transfer");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    // Figure out how to pull this information
    JLabel lineOne = new JLabel("Your transfer was a success!");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    JLabel lineTwo = new JLabel("Your current account statuses are:");
    lineTwo.setBounds(5,45,300,25);
    panel.add(lineTwo);

    Account curAccount1 = c.getAccounts().get(accNum1 -1);
    Account curAccount2 = c.getAccounts().get(accNum2 -1);

    curAccount1.withdraw(money);
    curAccount2.deposit(money);

    int y = 60;
    JLabel accType = new JLabel("Account type: " + curAccount1.getType());
    JLabel accNum = new JLabel("Account number: " + curAccount1.getAccountNumber());
    JLabel accBalance = new JLabel("Account balance: " + curAccount1.getBalance());
    accType.setBounds(30,y, 200, 25);
    y+=15;
    accNum.setBounds(30,y, 200, 25);
    y+=15;
    accBalance.setBounds(30,y, 200, 25);
    y+=35;
    panel.add(accType);
    panel.add(accNum);
    panel.add(accBalance);

    
    
    JLabel accType2 = new JLabel("Account type: " + curAccount2.getType());
    JLabel acccNum = new JLabel("Account number: " + curAccount2.getAccountNumber());
    JLabel accBalance2 = new JLabel("Account balance: " + curAccount2.getBalance());
    accType2.setBounds(30,y, 200, 25);
    y+=15;
    acccNum.setBounds(30,y, 200, 25);
    y+= 15;
    accBalance2.setBounds(30,y, 200, 25);
    y+=30;
    panel.add(accType2);
    panel.add(acccNum);
    panel.add(accBalance2);

    c.getTransactions().add(new Transactions(curAccount1.getType() + " "+ curAccount1.getAccountNumber() + " transferred "));
    c.getTransactions().add(new Transactions(money + " dollars to " + curAccount2.getType() + " "+ curAccount2.getAccountNumber()));

    JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
    lineThree.setBounds(5,y,300,25);
    panel.add(lineThree);
    y+=25;

    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(10, y, 200, 25);
    yesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c, m);
        }});
    panel.add(yesButton);
    y+=35;

    JButton noButton = new JButton("No");
    noButton.setBounds(10, y, 200, 25);
    yesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        }});
    panel.add(noButton);



  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }  
}