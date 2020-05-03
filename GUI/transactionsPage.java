import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;


public class transactionsPage{
  private JFrame frame;

  public transactionsPage(){
    frame = new JFrame("MyATM");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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

    JLabel identityMessage = new JLabel("What would you like to do?");
    identityMessage.setBounds(5,25,200,25);
    panel.add(identityMessage);

    JButton withdrawButton = new JButton("Withdraw");
    withdrawButton.setBounds(10, 70, 200, 30);
    withdrawButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new transactionsPageAccountChoice();
        }});
    panel.add(withdrawButton);

    JButton depositButton = new JButton("Deposit");
    depositButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new transactionsPageAccountChoice();
        }});
    depositButton.setBounds(10, 100, 200, 30);
    panel.add(depositButton);

    JButton backButton = new JButton("Back");
    backButton.setBounds(330, 35, 100, 50);
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new customerWelcome();
        }});
    panel.add(backButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(330, 90, 100, 50);
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
