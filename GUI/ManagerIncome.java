package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ManagerIncome {
    private JFrame frame;

    public ManagerIncome(Customer c, Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, m);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel,Customer c, Manager m){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Manager income");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        // Figure out how to pull this information
        JLabel lineOne = new JLabel("Daily Transaction");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        int y = 60;
        int numOfAccounts = m.getTransactions().size();
        int i = 0;
        while(i < numOfAccounts){
            if(m.getTransactions().get(i).getDay() ==  Calendar.getInstance().DATE){
                JLabel accType = new JLabel(m.getTransactions().get(i).getName());
                accType.setBounds(30,y, 200, 25);
                panel.add(accType);
                i++;
                y+= 15;
            }
        }
        y+= 20;

        JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
        lineThree.setBounds(5,y,300,25);
        panel.add(lineThree);
        y+= 20;

        JButton yesButton = new JButton("Yes");
        yesButton.setBounds(10, y, 200, 25);
        yesButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new CustomerWelcomeScreen(c, m);
            }});
        panel.add(yesButton);
        y+= 35;

        JButton noButton = new JButton("No");
        noButton.setBounds(10, y, 200, 25);
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