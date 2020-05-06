package GUI;

import OOP.Customer;
import OOP.OpeningStock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewProfit {
    private JFrame frame;

    public ViewProfit(Customer c){
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
        JLabel headerMessage = new JLabel("View Profit");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineOne = new JLabel("Your profit information is listed below:");
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
            JLabel balance = new JLabel("Cash balance is:");
            balance.setBounds(30,y, 200, 25);
            JLabel value = new JLabel(String.valueOf(c.getSecurity().getBalance()));
            value.setBounds(150,y, 200, 25);
            panel.add(balance);
            panel.add(value);
            y += 15;
            JLabel profitLabel = new JLabel("Total profit is:");
            profitLabel.setBounds(30,y, 200, 25);
            panel.add(profitLabel);
            JLabel tprofit= new JLabel(String.valueOf(c.getSecurity().getTotalProfit()));
            tprofit.setBounds(150,y, 200, 25);
            panel.add(tprofit);
            y += 15;
            JLabel rprofitLabel = new JLabel("Realized profit is:");
            rprofitLabel.setBounds(30,y, 200, 25);
            panel.add(rprofitLabel);
            JLabel rprofit= new JLabel(String.valueOf(c.getSecurity().getTotalProfit()));
            rprofit.setBounds(150,y, 200, 25);
            panel.add(rprofit);
            y += 15;
            JLabel uprofitLabel = new JLabel("Unrealized profit is:");
            uprofitLabel.setBounds(30,y, 200, 25);
            panel.add(uprofitLabel);
            JLabel uprofit= new JLabel(String.valueOf(c.getSecurity().getTotalProfit()));
            uprofit.setBounds(150,y, 200, 25);
            panel.add(uprofit);
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
