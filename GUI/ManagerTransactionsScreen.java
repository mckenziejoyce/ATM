package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class ManagerTransactionsScreen {
    private JFrame frame;

    public ManagerTransactionsScreen(Customer c, Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, m);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, Customer c, Manager m){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Customer Transactions");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);
        int y = 30;
        ArrayList<Transactions> allTrans = new ArrayList<Transactions>();
        Customer[] customers = m.getCustomers();
        int lol = 0;
        if(customers != null){
          lol = customers.length;
        }
        for(int j=0; j < lol; j++){
          allTrans.addAll(customers[j].getTransactions());
        }

        int numOfAccounts = allTrans.size();
        int i = 0;
        while(i < numOfAccounts){
            if(!allTrans.get(i).monthPass()){
                JLabel accType = new JLabel(allTrans.get(i).getName());
                accType.setBounds(30,y, 200, 25);
                panel.add(accType);
                i++;
                y+= 15;
            }
        }
        y+= 20;
        JButton backButton = new JButton("Back");
        backButton.setBounds(330, y, 100, 50);
        backButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new ManagerWelcomeScreen(c, m);
            }});
        panel.add(backButton);
      }

    }
