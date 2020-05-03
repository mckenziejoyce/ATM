import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class CloseAccConfirmScreen{
  private JFrame frame;
  private int accNumber;

  public CloseAccConfirmScreen(int numOfAccountToClose){
    frame = new JFrame("MyATM");
    accNumber = numOfAccountToClose;
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Close a Current Account");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("Confirm you would like to close the account");
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
    JLabel type = new JLabel("xxxxxxxxxx");
    JLabel num = new JLabel("xxxxxxxxxxx");
    JLabel balance = new JLabel("xxxxxxxxxxxx");
    type.setBounds(150,60, 200, 25);
    num.setBounds(150,75, 200, 25);
    balance.setBounds(150,90, 200, 25);
    panel.add(type);
    panel.add(num);
    panel.add(balance);

    JLabel lineThree = new JLabel("You will be charged a fee of 5 USD");
    lineThree.setBounds(5,115,300,25);
    panel.add(lineThree);

    JLabel lineFour = new JLabel("We will send you a check of your remaining balance in the mail");
    lineFour.setBounds(5,130,400,25);
    panel.add(lineFour);

    JButton confirmButton = new JButton("Confirm and Close");
    confirmButton.setBounds(50, 160, 200, 25);
    confirmButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CloseAccSuccessScreen();
        }});
    panel.add(confirmButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(330, 35, 100, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CloseAccountScreen();
        }});
    panel.add(backButton);

    // Pull and add account number
  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
