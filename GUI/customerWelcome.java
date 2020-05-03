import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class customerWelcome{
  private JFrame frame;

  public customerWelcome(){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //setUpPage();
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    panel.setLayout(null);
    JLabel welcomeMessage = new JLabel("Welcome customer!");
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
        new transactionsPage();
        }});
    panel.add(transactionsButton);

    JButton accManButton = new JButton("Account Management");
    accManButton.setBounds(10, 100, 200, 30);
    accManButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new accountManagement();
        }});
    panel.add(accManButton);

    JButton loanButton = new JButton("Apply for a loan");
    loanButton.setBounds(10, 130, 200, 30);
    panel.add(loanButton);

    JButton stocksButton = new JButton("Trade Stocks and Security");
    stocksButton.setBounds(10, 160, 200, 30);
    panel.add(stocksButton);

    JButton currecyButton = new JButton("Currency Settings");
    currecyButton.setBounds(10, 190, 200, 30);
    currecyButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new currencySettings();
        }});
    panel.add(currecyButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(250, 120, 200, 30);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new welcomePage();
        }});
    panel.add(logoutButton);
  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
