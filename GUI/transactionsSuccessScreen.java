import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class transactionsSuccessScreen{
  private JFrame frame;

  public transactionsSuccessScreen(){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Transactions");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    // Figure out how to pull this information
    JLabel lineOne = new JLabel("Your transcation was a success!");
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

    // FIgure out how to pull the real info for this
    JLabel type = new JLabel("xxxxxxxxxx");
    JLabel num = new JLabel("xxxxxxxxxxx");
    JLabel balance = new JLabel("xxxxxxxxxxxx");
    type.setBounds(150,60, 200, 25);
    num.setBounds(150,75, 200, 25);
    balance.setBounds(150,90, 200, 25);
    panel.add(type);
    panel.add(num);
    panel.add(balance);
    // Figure out how to pull and display account info

    JLabel lineThree = new JLabel("Would you like to continue using the bank app?");
    lineThree.setBounds(5,115,300,25);
    panel.add(lineThree);

    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(10, 140, 200, 25);
    yesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new customerWelcome();
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
