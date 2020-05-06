package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;


public class SecurityAccountConfirmationScreen{
    private JFrame frame;

    public SecurityAccountConfirmationScreen(Customer c, Manager m, String money){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, m, money);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, Customer c, Manager m, String money){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Open A New Security Account");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel lineTwo = new JLabel("See account information below");
        lineTwo.setBounds(5,20,300,25);
        panel.add(lineTwo);

        JLabel accType = new JLabel("Account type:");
        JLabel accNum = new JLabel("Account number:");
        JLabel accBalance = new JLabel("Account balance:");
        accType.setBounds(30,40, 200, 25);
        accNum.setBounds(30,65, 200, 25);
        accBalance.setBounds(30,80, 200, 25);
        panel.add(accType);
        panel.add(accNum);
        panel.add(accBalance);

        int value = Integer.parseInt(money);

        // FIgure out how to pull the real info for this
        JLabel type = new JLabel("Security");
        c.makeSecurityAccount(value);
        JLabel num = new JLabel(c.getSaving().getAccountNumber());
        JLabel balance = new JLabel(money);

        type.setBounds(150,40, 200, 25);
        num.setBounds(150,65, 200, 25);
        balance.setBounds(150,80, 200, 25);
        panel.add(type);
        panel.add(num);
        panel.add(balance);

        JLabel lineThree = new JLabel("You will be charged a fee of 5" + " " + c.getCurrency());
        lineThree.setBounds(5,105,300,25);
        panel.add(lineThree);

        JButton confirmButton = new JButton("Confirm and Pay");
        confirmButton.setBounds(50, 125, 200, 25);
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new StockWelcomeScreen(c, m);
            }});
        panel.add(confirmButton);

        // Pull and add account number
    }
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}
