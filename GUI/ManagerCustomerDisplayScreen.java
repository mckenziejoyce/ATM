package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class ManagerCustomerDisplayScreen{
  private JFrame frame;

  public CheckOnCustomerSelection(Customer c){
      frame = new JFrame("MyATM");
      frame.setSize(500, 300);
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      JPanel panel = new JPanel();
      frame.add(panel);
      placeComponents(panel, c);
      frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Customer Details");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("The customer has the following accounts:");
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
    y += 15;
  }
}
