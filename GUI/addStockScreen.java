package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class addStockScreen{
    private JFrame frame;

    public addStockScreen(Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, m);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel, Manager m){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Add a stock");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        int y = 25;

        JLabel lineOne = new JLabel("Enter the stock name you want to add");
        lineOne.setBounds(5,y,300,25);
        panel.add(lineOne);

        y+= 20;
        JTextField userText1 = new JTextField(50);
        userText1.setBounds(2,y,280,25);
        panel.add(userText1);

        y+=30;
        JLabel lineTwo = new JLabel("Enter the stock price you want to add");
        lineTwo.setBounds(5,y,300,25);
        panel.add(lineTwo);

        y+= 20;
        JTextField userText2 = new JTextField(50);
        userText2.setBounds(2,y,280,25);
        panel.add(userText2);

        y+= 30;
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(40, y, 150, 25);
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = String.valueOf(userText1.getText());
                double price = Double.valueOf(userText2.getText());
                if(m.getStocks().getPriceByName(name) >=0){
                    userText1.setText("");
                    userText2.setText("");
                    new InvalidEntryPopUp("That stock already exists");
                }
                else if (price<=0){
                    userText2.setText("");
                    new InvalidEntryPopUp("The price is invalid.");
                }
                else{
                    m.getStocks().addStock(new Stock(name,price));
                    frame.dispose();
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
