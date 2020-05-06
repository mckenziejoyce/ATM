package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class AccountManagementScreen{
  private JFrame frame;

  public AccountManagementScreen(Customer c, Manager m){
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
    JLabel headerMessage = new JLabel("Account Management");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel identityMessage = new JLabel("What would you like to do?");
    identityMessage.setBounds(5,25,200,25);
    panel.add(identityMessage);

    JButton openAccButton = new JButton("Open a new account");
    openAccButton.setBounds(10, 60, 270, 30);
    openAccButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new OpenNewAccountScreen(c, m);
        }});
    panel.add(openAccButton);

    JButton closeAccButton = new JButton("Close a current account");
    closeAccButton.setBounds(10, 90, 270, 30);
    closeAccButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CloseAccountScreen(c, m);
        }});
    panel.add(closeAccButton);

    JButton viewAccButton = new JButton("View current account information");
    viewAccButton.setBounds(10, 120, 270, 30);
    viewAccButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountInfoScreen(c, m);
        }});
    panel.add(viewAccButton);

    JButton viewtransButton = new JButton("View current month transaction history");
    viewtransButton.setBounds(10, 150, 270, 30);
    viewtransButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new MonthlyTransactionsSuccessScreen(c, m);
        }});
    panel.add(viewtransButton);

    JButton accountTransferButton = new JButton("Transfer money bewteen accounts");
    accountTransferButton.setBounds(10, 180, 270, 30);
    accountTransferButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountTransfer(c, m);
        }});
    panel.add(accountTransferButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 65, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c, m);
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 130, 130, 50);
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
