package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class modifyStockSuccessScreen {
    private JFrame frame;

    public modifyStockSuccessScreen(Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, m);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel,  Manager m){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Modify stock success");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineOne = new JLabel("Now you have the following stocks:");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        //Figure out how to pull from database to display accounts here

        int y = 25;
        //Figure out how to get the real number for this
        int numOfStocks = m.numOfStocks();
        int i = 0;
        while(i < numOfStocks){
            y += 15;
            String acc = "Stock "+(i+1)+":";
            JLabel accLabel = new JLabel(acc);
            accLabel.setBounds(19,y,200,25);
            panel.add(accLabel);
            y += 15;
            JLabel accType = new JLabel("Stock Name:");
            accType.setBounds(30,y, 200, 25);
            JLabel type = new JLabel(m.getStocks().getStockList().get(i).getName());
            type.setBounds(150,y, 200, 25);
            panel.add(accType);
            panel.add(type);
            y += 15;
            JLabel accNum = new JLabel("Stock Price:");
            accNum.setBounds(30,y, 200, 25);
            panel.add(accNum);
            JLabel num = new JLabel(String.valueOf(m.getStocks().getStockList().get(i).getPrice()));
            num.setBounds(150,y, 200, 25);
            panel.add(num);
            y += 15;
            JLabel accBalance = new JLabel("Stock Availablility:");
            accBalance.setBounds(30,y, 200, 25);
            panel.add(accBalance);
            String avail = m.getStocks().getStockList().get(i).available()?"Yes":"No";
            JLabel balance = new JLabel(avail);
            balance.setBounds(150,y, 200, 25);
            panel.add(balance);
            y += 10;
            i++;
        }
        y+=10;

        JButton managerButton = new JButton("Continue manage stocks");
        managerButton.setBounds(10, y, 200, 30);
        managerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new manageStocksScreen(m);
            }});
        panel.add(managerButton);
        y += 30;

        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 35, 130, 50);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ManagerWelcomeScreen(m);
            }});
        panel.add(backButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(300, 90, 130, 50);
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                Customer c = new TestCases().customer1();
                new WelcomeScreen(c, m);
            }});
        panel.add(logoutButton);

    }
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}

