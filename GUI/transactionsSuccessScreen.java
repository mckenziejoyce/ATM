package GUI;
import OOP.*;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class TransactionsSuccessScreen{
  private JFrame frame;

  public TransactionsSuccessScreen(Customer c, String aNumber, String money, String action){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, aNumber, money, action);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, String aNumber, String money, String action){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Transactions");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    // Figure out how to pull this information
    JLabel lineOne = new JLabel("Your transcation was a success!");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    JLabel lineTwo = new JLabel("Your current account status is:");
    lineTwo.setBounds(5,45,300,25);
    panel.add(lineTwo);

    JLabel accType = new JLabel("Account type:");
    JLabel accNum = new JLabel("Account number:");
    JLabel accBalance = new JLabel("Account balance:");
    accType.setBounds(30,60, 200, 25);
    accNum.setBounds(30,75, 200, 25);
    accBalance.setBounds(30,90, 200, 25);
    panel.add(accType);
    panel.add(accNum);
    panel.add(accBalance);

    Account curAccount = c.getAccounts().get(Integer.parseInt(aNumber)-1);

    if(action.equals("Withdraw")){
      curAccount.withdraw(Double.valueOf(money));
      c.getTransactions().add(new Transactions(curAccount.getType() + " withdraw: -" + money + " " + c.getCurrency(), Double.valueOf(money)));
    }
    else if(action.equals("Deposit")){
      curAccount.deposit(Double.valueOf(money));
      c.getTransactions().add(new Transactions(curAccount.getType() + " deposit: +" + money + " " + c.getCurrency(), Double.valueOf(money)));
    }
    // FIgure out how to pull the real info for this
    JLabel type = new JLabel(curAccount.getType());
    JLabel num = new JLabel(curAccount.getAccountNumber());
    JLabel balance = new JLabel(Double.toString(curAccount.getBalance()) + " " + c.getCurrency());
    type.setBounds(150,60, 200, 25);
    num.setBounds(150,75, 200, 25);
    balance.setBounds(150,90, 200, 25);
    panel.add(type);
    panel.add(num);
    panel.add(balance);
    // Figure out how to pull and display account info

    JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
    lineThree.setBounds(5,115,300,25);
    panel.add(lineThree);

    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(10, 140, 200, 25);
    yesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c);
        }});
    panel.add(yesButton);

    JButton noButton = new JButton("No");
    noButton.setBounds(10, 175, 200, 25);
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
