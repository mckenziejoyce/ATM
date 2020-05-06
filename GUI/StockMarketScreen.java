package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class StockMarketScreen{
  private JFrame frame;

  public StockMarketScreen(Customer c, String action, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, m, action);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, Manager m, String action){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel(action + " Stocks");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("You have the following stock options:");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    
    int y = 25;
    ArrayList<Stock> stocks = m.getStocks().getStockList();
    Security sec = c.getSecurity();
    ArrayList<OpeningStock> open = sec.getOpening();

    if(action.equals("Buy")){
        int numOfStocks = stocks.size();
        int i = 0;
        while(i < numOfStocks){
            y += 15;
            JLabel accLabel = new JLabel((i+1) + "Company Name: " + stocks.get(i).getName());
            accLabel.setBounds(19,y,200,25);
            panel.add(accLabel);
            y += 15;
            JLabel accType = new JLabel("Stock Price: ");
            accType.setBounds(30,y, 200, 25);
            JLabel type = new JLabel("" + stocks.get(i).getPrice());
            type.setBounds(150,y, 200, 25);
            panel.add(accType);
            panel.add(type);
            y += 15;
            JLabel accNum = new JLabel("Availability:");
            accNum.setBounds(30,y, 200, 25);
            panel.add(accNum);
            JLabel num = new JLabel(""+stocks.get(i).available());
            num.setBounds(150,y, 200, 25);
            panel.add(num);
            y += 15;
            i++;
        }
    }
    else if(action.equals("Sell")){
      int numOfOpens = open.size();
      int i = 0;
      while(i < numOfOpens){
        y += 15;
        JLabel accLabel = new JLabel((i+1) + "Company Name: " + open.get(i).getName());
        accLabel.setBounds(19,y,200,25);
        panel.add(accLabel);
        y += 15;
        JLabel accType = new JLabel("Sell Price: ");
        accType.setBounds(30,y, 200, 25);
        JLabel type = new JLabel("" + stocks.get(i).getPrice());
        type.setBounds(150,y, 200, 25);
        panel.add(accType);
        panel.add(type);
        y += 15;
        JLabel accNum = new JLabel("Number of shares:");
        accNum.setBounds(30,y, 200, 25);
        panel.add(accNum);
        JLabel num = new JLabel(""+ open.get(i).getShare());
        num.setBounds(150,y, 200, 25);
        panel.add(num);
        y += 15;
        i++;
      }
    }

    y += 15;

    JLabel lineTwo = new JLabel("Enter the stock number you want to " + action);
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
        String stock = userText.getText();
        int sNum = Integer.parseInt(stock);
        ArrayList<Account> acc = c.getAccounts();
        boolean cont = sNum <= stocks.size();
        if(cont){
          
          frame.dispose();
          if(action.equals("Buy")){
            new StockSuccessScreen(c, sNum, action, m);
          }
          else if(action.equals("Sell")){
            new StockSuccessScreen(c, sNum, action, m);
          }
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