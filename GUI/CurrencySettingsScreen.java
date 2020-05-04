package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class CurrencySettingsScreen{
  private JFrame frame;

  public CurrencySettingsScreen(Customer c){
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

    JLabel headerMessage = new JLabel("Currency Settings");
    headerMessage.setBounds(5,y,300,25);
    panel.add(headerMessage);

    y+= 25;
    JLabel lineOne = new JLabel("Default Currency is USD");
    lineOne.setBounds(5,y,300,25);
    panel.add(lineOne);

    y+= 25;
    JLabel lineTwo = new JLabel("Your current trade/display currency is");
    lineTwo.setBounds(5,y,300,25);
    panel.add(lineTwo);

    // Figure out how to fill this in
    y+= 15;
    JLabel curCurr = new JLabel(c.getCurrency());
    curCurr.setBounds(15,y,300,25);
    panel.add(curCurr);

    y+= 20;
    JLabel lineThree = new JLabel("Choose your trade/display currency");
    lineThree.setBounds(5,y,300,25);
    panel.add(lineThree);

    y+= 20;
    JButton currOneButton = new JButton("USD");
    currOneButton.setBounds(15, y, 150, 25);
    currOneButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
      
        int i = 0;
        while(i<c.getAccounts().size()){
          Account curAccount = c.getAccounts().get(i);
          curAccount.setBalance(Customer.exchangeRate(c.getCurrency(), "USD", curAccount.getBalance()));
          i++;
        }
        c.changeCurrency("USD");
        new CustomerWelcomeScreen(c);
        }});
    panel.add(currOneButton);

    y+= 30;
    JButton currTwoButton = new JButton("EUR");
    currTwoButton.setBounds(15, y, 150, 25);
    currTwoButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        
        int i = 0;
        while(i<c.getAccounts().size()){
          Account curAccount = c.getAccounts().get(i);
          curAccount.setBalance(Customer.exchangeRate(c.getCurrency(), "EUR", curAccount.getBalance()));
          i++;
        }
        c.changeCurrency("EUR");
        new CustomerWelcomeScreen(c);
        }});
    panel.add(currTwoButton);

    y+= 30;
    JButton currThreeButton = new JButton("JPY");
    currThreeButton.setBounds(15, y, 150, 25);
    currThreeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();

        int i = 0;
        while(i<c.getAccounts().size()){
          Account curAccount = c.getAccounts().get(i);
          curAccount.setBalance(Customer.exchangeRate(c.getCurrency(), "JPY", curAccount.getBalance()));
          i++;
        }
        c.changeCurrency("JPY");
        new CustomerWelcomeScreen(c);
        }});
    panel.add(currThreeButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c);
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
