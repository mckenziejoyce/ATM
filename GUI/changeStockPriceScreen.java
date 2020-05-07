package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class changeStockPriceScreen{
    private JFrame frame;

    public changeStockPriceScreen(Stock s, Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel,s, m);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel, Stock s, Manager m){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Modify stock price");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineOne = new JLabel("You are modifying this stock:");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        //Figure out how to pull from database to display accounts here

        int y = 40;
        JLabel accType = new JLabel("Stock Name:");
        accType.setBounds(30,y, 200, 25);
        JLabel type = new JLabel(s.getName());
        type.setBounds(150,y, 200, 25);
        panel.add(accType);
        panel.add(type);
        y += 15;
        JLabel accNum = new JLabel("Stock Price:");
        accNum.setBounds(30,y, 200, 25);
        panel.add(accNum);
        JLabel num = new JLabel(String.valueOf(s.getPrice()));
        num.setBounds(150,y, 200, 25);
        panel.add(num);
        y += 15;
        JLabel accBalance = new JLabel("Stock Availablility:");
        accBalance.setBounds(30,y, 200, 25);
        panel.add(accBalance);
        String avail = s.available()?"Yes":"No";
        JLabel balance = new JLabel(avail);
        balance.setBounds(150,y, 200, 25);
        panel.add(balance);
        y += 30;

        JLabel line = new JLabel("Enter the new price");
        line.setBounds(5,y,300,25);
        panel.add(line);
        y+=30;

        y+= 20;
        JTextField userText = new JTextField(50);
        userText.setBounds(2,y,280,25);
        panel.add(userText);

        y+= 30;
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(40, y, 150, 25);
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double price = Double.valueOf(userText.getText());
                if (price<=0){
                    userText.setText("");
                    new InvalidEntryPopUp("The price is invalid.");
                }
                else{
                    s.setPrice(price);
                    new modifyStockSuccessScreen(m);
                }
            }});
        panel.add(submitButton);

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

