import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class AccountInfoScreen{
  private JFrame frame;

  public AccountInfoScreen(){
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
    JLabel headerMessage = new JLabel("View Account Information");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("Accounts");
    lineOne.setBounds(5,25,200,25);
    panel.add(lineOne);

    int y = 25;
    //Figure out how to get the real number for this
    int numOfAccounts = 2;
    int i = 0;
    while(i < numOfAccounts){
      y += 15;
      String acc = "Account "+(i+1)+":";
      JLabel accLabel = new JLabel(acc);
      accLabel.setBounds(19,y,200,25);
      panel.add(accLabel);
      y += 15;
      JLabel accType = new JLabel("Account type:");
      accType.setBounds(30,y, 200, 25);
      JLabel type = new JLabel("xxxxxxxxxx");
      type.setBounds(150,y, 200, 25);
      panel.add(accType);
      panel.add(type);
      y += 15;
      JLabel accNum = new JLabel("Account number:");
      accNum.setBounds(30,y, 200, 25);
      panel.add(accNum);
      JLabel num = new JLabel("xxxxxxxxxxx");
      num.setBounds(150,y, 200, 25);
      panel.add(num);
      y += 15;
      JLabel accBalance = new JLabel("Account balance:");
      accBalance.setBounds(30,y, 200, 25);
      panel.add(accBalance);
      JLabel balance = new JLabel("xxxxxxxxxxxx");
      balance.setBounds(150,y, 200, 25);
      panel.add(balance);
      y += 10;
      i++;
    }
    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new AccountManagementScreen();
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 90, 130, 50);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new WelcomeScreen();
        }});
    panel.add(logoutButton);
  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
