package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class LoanScreen {
    private JFrame frame;

    public LoanScreen(Customer c, Manager m){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, m);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, Customer c, Manager m){
        int x = 5;
        int y = 5;
        panel.setLayout(null);
    
        JLabel headerMessage = new JLabel("Select your loan option");
        headerMessage.setBounds(5,y,300,25);
        panel.add(headerMessage);
        y+= 10;
       
    
        JButton applyButton = new JButton("Apply for loan");
        applyButton.setBounds(10, 70, 200, 30);
        applyButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.dispose();
            new LoanAccountScreen(c, m, "Apply");
            }});
        panel.add(applyButton);
    
        y += 20;

        JButton payButton = new JButton("Pay loan");
        payButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.dispose();
            new LoanAccountScreen(c, m, "Pay");
            }});
        payButton.setBounds(10, 100, 200, 30);
        panel.add(payButton);

        JButton statusButton = new JButton("Loan status");
        statusButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.dispose();
            new LoanStatusScreen(c, m);
            }});
        statusButton.setBounds(10, 130, 200, 30);
        panel.add(statusButton);
    
        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 35, 130, 50);
        backButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new AccountManagementScreen(c, m);
            }});
        panel.add(backButton);
    
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(300, 90, 130, 50);
        logoutButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new WelcomeScreen(c, m);
            }});
        panel.add(logoutButton);
    
    }
    
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}
    
