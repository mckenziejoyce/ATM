import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class monthTransInfo{
  private JFrame frame;

  public monthTransInfo(){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    int x = 5;
    int y = 5;
    panel.setLayout(null);

    JLabel headerMessage = new JLabel("View Current Month Transaction History");
    headerMessage.setBounds(5,y,300,25);
    panel.add(headerMessage);
    y+= 10;
    // Get real number
    int numOfTransactions = 2;
    int i = 0;
    while(i < numOfTransactions){
      y += 15;
      String trans = "Transaction "+(i+1)+":";
      JLabel transLabel = new JLabel(trans);
      transLabel.setBounds(19,y,200,25);
      panel.add(transLabel);
      y += 15;
      JLabel transType = new JLabel("Transaction type:");
      transType.setBounds(30,y, 200, 25);
      JLabel type = new JLabel("xxxxxxxxxx");
      type.setBounds(150,y, 200, 25);
      panel.add(transType);
      panel.add(type);
      y += 15;
      JLabel transAcc = new JLabel("Account Involved:");
      transAcc.setBounds(30,y, 200, 25);
      JLabel account = new JLabel("xxxxxxxxxx");
      account.setBounds(150,y, 200, 25);
      panel.add(transAcc);
      panel.add(account);
      y += 15;
      JLabel transDate = new JLabel("Date:");
      transDate.setBounds(30,y, 200, 25);
      JLabel date = new JLabel("xx/xx/xxxx");
      date.setBounds(150,y, 200, 25);
      panel.add(transDate);
      panel.add(date);
      y += 10;
      i++;
    }
    JButton backButton = new JButton("Back");
    backButton.setBounds(300, 35, 130, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new accountManagement();
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(300, 90, 130, 50);
    logoutButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new welcomePage();
        }});
    panel.add(logoutButton);

  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }
}
