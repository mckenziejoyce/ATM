package GUI;
import OOP.*;
import java.util.ArrayList;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoanSuccessScreen {
    private JFrame frame;

    public LoanSuccessScreen(Customer c, Manager m, String aNumber, String money, String action){
        frame = new JFrame("MyATM");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, c, m, aNumber, money, action);
        frame.setVisible(true);
      }

      private void placeComponents(JPanel panel, Customer c, Manager m, String aNumber, String money, String action){
        panel.setLayout(null);
        JLabel headerMessage = new JLabel("Loans");
        headerMessage.setBounds(5,5,200,25);
        panel.add(headerMessage);

        // Figure out how to pull this information
        JLabel lineOne = new JLabel("Your loan was a success!");
        lineOne.setBounds(5,25,300,25);
        panel.add(lineOne);

        JLabel lineTwo = new JLabel("Your current account status is:");
        lineTwo.setBounds(5,45,300,25);
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

        Account curAccount = c.getAccounts().get(Integer.parseInt(aNumber)-1);

        if(action.equals("Pay")){
            curAccount.withdraw(Double.valueOf(money));
            c.payLoan(Double.valueOf(money));
            c.getTransactions().add(new Transactions(curAccount.getType() + " loan payment: -" + money, Double.valueOf(money)));
        }
        else if(action.equals("Apply")){
            curAccount.deposit(Double.valueOf(money));
            c.applyLoan(Double.valueOf(money), 0.12);
            c.getTransactions().add(new Transactions(curAccount.getType() + " loan apply: +" + money, Double.valueOf(money)));
        }

        JLabel type = new JLabel(curAccount.getType());
        JLabel num = new JLabel(curAccount.getAccountNumber());
        JLabel balance = new JLabel(Double.toString(curAccount.getBalance()));
        type.setBounds(150,60, 200, 25);
        num.setBounds(150,75, 200, 25);
        balance.setBounds(150,90, 200, 25);
        panel.add(type);
        panel.add(num);
        panel.add(balance);

        JLabel loanAmount = new JLabel("Loan amount left: " + c.getLoan().getMoney());
        JLabel doa = new JLabel("Date of applying: " + c.getLoan().getMonth() + " " + c.getLoan().getDay() + ", " + c.getLoan().getYear());
        loanAmount.setBounds(30,115, 200, 25);
        doa.setBounds(30,130, 200, 25);
        panel.add(loanAmount);
        panel.add(doa);


        JLabel lineFour = new JLabel("Would you like to continue using the bank app?");
        lineFour.setBounds(5,160,300,25);
        panel.add(lineFour);

        JButton yesButton = new JButton("Yes");
        yesButton.setBounds(10, 195, 200, 25);
        yesButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            frame.dispose();
            new CustomerWelcomeScreen(c, m);
            }});
        panel.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setBounds(10, 225, 200, 25);
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
