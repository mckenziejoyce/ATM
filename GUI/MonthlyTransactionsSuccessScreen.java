package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class MonthlyTransactionsSuccessScreen {
    private JFrame frame;

    public MonthlyTransactionsSuccessScreen(Customer c, int aNumber){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, aNumber);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, Customer c, int aNumber){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Transactions");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);
    
        // Figure out how to pull this information
        JLabel lineOne = new JLabel("Monthly Transactions");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);
    
        int y = 60;
        int numOfAccounts = c.getTransactions().size();
        int i = 0;
        while(i < numOfAccounts){
            JLabel accType = new JLabel(c.getTransactions().get(aNumber-1));
            accType.setBounds(30,y, 200, 25);
            panel.add(accType);
            i++;
            y+= 15;
        }
        

        // Figure out how to pull and display account info
    
        JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
        lineThree.setBounds(5,115,300,25);
        panel.add(lineThree);
    
        JButton yesButton = new JButton("Yes");
        yesButton.setBounds(10, 140, 200, 25);
        yesButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new CustomerWelcomeScreen(c);
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


