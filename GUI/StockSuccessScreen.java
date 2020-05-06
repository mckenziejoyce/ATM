package GUI;
import OOP.*;
import java.util.ArrayList;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class StockSuccessScreen{
  private JFrame frame;

  public StockSuccessScreen(Customer c, int sNumber, int shNumber, String action, Manager m){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, c, sNumber, shNumber, action, m);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Customer c, int sNumber, int shNumber, String action, Manager m){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Stocks");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    // Figure out how to pull this information
    JLabel lineOne = new JLabel("Your Stock transcation was a success!");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    ArrayList<Stock> stocks = m.getStocks().getStockList();
    Security sec = c.getSecurity();
    ArrayList<OpeningStock> open = sec.getOpening();

    if(action.equals("Buy")){
        JLabel lineTwo = new JLabel("Your Stock that you purchased:");
        lineTwo.setBounds(5,45,300,25);
        panel.add(lineTwo);

        JLabel sType = new JLabel("Company name: " + stocks.get(sNumber-1).getName());
        JLabel sNum = new JLabel("Stock Price: " + stocks.get(sNumber-1).getPrice());
        sec.buyStock(stocks.get(sNumber-1), shNumber);
        JLabel sBalance = new JLabel("Account balance: " + c.getSecurity().getBalance());
        sType.setBounds(30,60, 200, 25);
        sNum.setBounds(30,75, 200, 25);
        sBalance.setBounds(30,90, 200, 25);
        panel.add(sType);
        panel.add(sNum);
        panel.add(sBalance);
    }
    else if(action.equals("Buy")){
        JLabel lineTwo = new JLabel("Your Stock that you sold:");
        lineTwo.setBounds(5,45,300,25);
        panel.add(lineTwo);

        JLabel sType = new JLabel("Company name: " + sec.getOpening().get(sNumber-1).getName());
        JLabel sNum = new JLabel("Stock Price: " + sec.getOpening().get(sNumber-1).getPrice());
        sec.sellStock(sNumber, shNumber, sec.getOpening().get(sNumber-1).getPrice());
        JLabel sBalance = new JLabel("Account balance: " + c.getSecurity().getBalance());
        sType.setBounds(30,60, 200, 25);
        sNum.setBounds(30,75, 200, 25);
        sBalance.setBounds(30,90, 200, 25);
        panel.add(sType);
        panel.add(sNum);
        panel.add(sBalance);

        
    }

    JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
    lineThree.setBounds(5,115,300,25);
    panel.add(lineThree);

    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(10, 140, 200, 25);
    yesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen(c, m);
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