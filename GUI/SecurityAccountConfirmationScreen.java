package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;


public class SecurityAccountConfirmationScreen{
    private JFrame frame;

    public SecurityAccountConfirmationScreen(String account, Customer c){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, account, c);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, String account, Customer c){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Open a New Account");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineOne = new JLabel("Confirm you would like to open a new account");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        JLabel lineTwo = new JLabel("See account information below");
        lineTwo.setBounds(5,40,300,25);
        panel.add(lineTwo);

        JLabel accType = new JLabel("Account type:");
        JLabel accNum = new JLabel("Account number:");
        JLabel accBalance = new JLabel("Account balance:");
        accType.setBounds(30,60, 200, 25);
        accNum.setBounds(30,75, 200, 25);
        accBalance.setBounds(30,90, 200, 25);
        panel.add(accType);
        panel.add(accNum);
        panel.add(accBalance);

        // FIgure out how to pull the real info for this
        JLabel type = new JLabel("xxxxxxxxxxxx");
        JLabel num = new JLabel("xxxxxxxxxxxx");
        JLabel balance = new JLabel("0.00");

        if(account.equals("c")){
            type = new JLabel("Checking");
            c.makeCheckingAccount(0);
            num = new JLabel(c.getChecking().getAccountNumber());
        }
        else if(account.equals("s")){
            type = new JLabel("Saving");
            c.makeSavingAccount(0);
            num = new JLabel(c.getSaving().getAccountNumber());
        }
        else if(account.equals("sc")){
            type = new JLabel("Security");
            c.makeSavingAccount(0);
            num = new JLabel(c.getSaving().getAccountNumber());
        }

        type.setBounds(150,60, 200, 25);
        num.setBounds(150,75, 200, 25);
        balance.setBounds(150,90, 200, 25);
        panel.add(type);
        panel.add(num);
        panel.add(balance);

        JLabel lineThree = new JLabel("You will be charged a fee of 5" + " " + c.getCurrency());
        lineThree.setBounds(5,115,300,25);
        panel.add(lineThree);

        JButton confirmButton = new JButton("Confirm and Pay");
        confirmButton.setBounds(50, 145, 200, 25);
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new AccountManagementScreen(c);
            }});
        panel.add(confirmButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(330, 35, 100, 50);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new OpenNewAccountScreen(c);
            }});
        panel.add(backButton);

        // Pull and add account number
    }
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}
