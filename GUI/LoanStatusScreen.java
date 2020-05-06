package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class LoanStatusScreen {
    private JFrame frame;

    public LoanStatusScreen(Customer c, Manager m){
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
        JLabel headerMessage = new JLabel("Loan Status");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);
    
        JLabel lineOne = new JLabel("See Loan information below");
        lineOne.setBounds(5,40,300,25);
        panel.add(lineOne);
    
        JLabel loanAmount = new JLabel("Loan amount left: " + c.getLoan().getMoney());
        JLabel doa = new JLabel("Date of applying: " + c.getLoan().getMonth() + " " + c.getLoan().getDay() + ", " + c.getLoan().getYear());
        loanAmount.setBounds(30, 60, 200, 25);
        doa.setBounds(30,75, 200, 25);
        panel.add(loanAmount);
        panel.add(doa);
    
        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 35, 130, 50);
        backButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new LoanScreen(c, m);
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