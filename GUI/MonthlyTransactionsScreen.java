package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class MonthlyTransactionsScreen{
  private JFrame frame;

  public MonthlyTransactionsScreen(Customer c){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c){
    int x = 5;
    int y = 5;
    panel.setLayout(null);

    JLabel headerMessage = new JLabel("View Current Month Transaction History");
    headerMessage.setBounds(5,y,300,25);
    panel.add(headerMessage);
    y+= 10;
    // Get real number
    int numOfTransactions = c.numOfAccounts();
    int i = 0;
    while(i < numOfTransactions){
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
      JLabel balance = new JLabel(Double.toString(c.getAccounts().get(i).getBalance()));
      balance.setBounds(150,y, 200, 25);
      panel.add(balance);
      y += 10;
      i++;
    }

    JLabel lineTwo = new JLabel("Enter the account number you want to use");
    lineTwo.setBounds(5,y,300,25);
    panel.add(lineTwo);

    y += 20;
    JTextField userText = new JTextField(50);
    userText.setBounds(5,y,165,25);
    panel.add(userText);

    y += 30;
    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(40, y, 100, 25);
    submitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new MonthlyTransactionsSuccessScreen(c, Integer.parseInt(userText.getText()));
        }});
    panel.add(submitButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountManagementScreen(c);
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 90, 130, 50);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new WelcomeScreen(c);
        }});
    panel.add(logoutButton);

  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
