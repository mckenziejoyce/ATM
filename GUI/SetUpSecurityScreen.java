package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class SetUpSecurityScreen{
    private JFrame frame;

    public SetUpSecurityScreen(Customer c){
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
        JLabel headerMessage = new JLabel("Open a security account");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        JLabel identityMessage = new JLabel("<html>Congratulations! You qualify for trading stocks.<br/>You only need to transfer 1000 USD from your savings account." +
                "<br/>Do you want to open seciroty account and transfer 1000 USD right now?</html>");
        identityMessage.setBounds(5,35,450,75);
        panel.add(identityMessage);


        JButton withdrawButton = new JButton("Yes");
        withdrawButton.setBounds(10, 120, 200, 30);
        withdrawButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                c.makeSecurity();
                frame.dispose();
                new StockWelcomeScreen(c);
            }});
        panel.add(withdrawButton);

        JButton depositButton = new JButton("No");
        depositButton.setBounds(10, 150, 200, 30);
        depositButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new CustomerWelcomeScreen(c);
            }});
        panel.add(depositButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(330, 120, 100, 50);
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