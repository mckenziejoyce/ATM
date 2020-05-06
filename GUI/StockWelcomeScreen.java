package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class StockWelcomeScreen{
    private JFrame frame;

    public  StockWelcomeScreen(Customer c){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //setUpPage();
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, Customer c){


        panel.setLayout(null);
        JLabel welcomeMessage = new JLabel("You can now trade stocks");
        welcomeMessage.setBounds(5,5,200,25);
        panel.add(welcomeMessage);

        JLabel identityMessage = new JLabel("What would you like to do?");
        identityMessage.setBounds(5,25,200,25);
        panel.add(identityMessage);

        JButton transactionsButton = new JButton("Trade");
        transactionsButton.setBounds(10, 70, 200, 30);
        transactionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new TransactionsScreen(c);
            }});
        panel.add(transactionsButton);

        JButton accManButton = new JButton("View Account Profit");
        accManButton.setBounds(10, 100, 200, 30);
        accManButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new ViewProfit(c);
            }});
        panel.add(accManButton);

        int y = 130;
        JButton loanButton = new JButton("View Open Position");
        loanButton.setBounds(10, y, 200, 30);
        loanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new ViewOpenPositionScreen(c);
            }});
        panel.add(loanButton);
        y+=30;

        JButton stocksButton = new JButton("View Trade History");
        stocksButton.setBounds(10, y, 200, 30);
        stocksButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new StockWelcomeScreen(c);
            }});
        panel.add(stocksButton);
        y+=30;

        JButton manageButton = new JButton("Manage Security Account");
        manageButton.setBounds(10, y, 200, 30);
        manageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new CurrencySettingsScreen(c);
            }});
        panel.add(manageButton);
        y+=30;

        JButton currecyButton = new JButton("Close Security Account");
        currecyButton.setBounds(10, y, 200, 30);
        currecyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new CurrencySettingsScreen(c);
            }});
        panel.add(currecyButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(330, 35, 100, 50);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new CustomerWelcomeScreen(c);
            }});
        panel.add(backButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(330, 90, 100, 50);
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new WelcomeScreen(c);
            }});
        panel.add(logoutButton);

        //Checks if month has passed to increase the loan
        if(c.getLoan() != null && c.getLoan().monthPass()){
            c.getLoan().increaseLoan();
        }

    }
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}