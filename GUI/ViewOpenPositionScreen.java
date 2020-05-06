package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewOpenPositionScreen{
    private JFrame frame;

    public ViewOpenPositionScreen(Customer c){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel, Customer c){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("View Open Position");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineOne = new JLabel("You have the following stocks:");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        //Figure out how to pull from database to display accounts here

        int y = 25;
        //Figure out how to get the real number for this
        ArrayList<OpeningStock> opening = c.getSecurity().getOpening();
        int numOfStocks = c.getSecurity().numOfStocks();
        int i = 0;
        while(i < numOfStocks){
            y += 15;
            String stock = "Stock "+(i+1)+":";
            JLabel stockLabel = new JLabel(stock);
            stockLabel.setBounds(19,y,200,25);
            panel.add(stockLabel);
            y += 15;
            JLabel stockName = new JLabel("Stock name:");
            stockName.setBounds(30,y, 200, 25);
            JLabel name = new JLabel(opening.get(i).getName());
            name.setBounds(150,y, 200, 25);
            panel.add(stockName);
            panel.add(name);
            y += 15;
            JLabel stockPrice = new JLabel("Average Price:");
            stockPrice.setBounds(30,y, 200, 25);
            panel.add(stockPrice);
            JLabel price= new JLabel(String.valueOf(opening.get(i).getPrice()));
            price.setBounds(150,y, 200, 25);
            panel.add(price);
            y += 15;
            JLabel stockShare = new JLabel("Shares:");
            stockShare.setBounds(30,y, 200, 25);
            panel.add(stockShare);
            JLabel balance = new JLabel(Double.toString(opening.get(i).getShare()));
            balance.setBounds(150,y, 200, 25);
            panel.add(balance);
            y += 10;
            i++;
        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 35, 130, 50);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new StockWelcomeScreen(c);
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
