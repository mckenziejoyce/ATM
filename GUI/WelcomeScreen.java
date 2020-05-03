import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class WelcomeScreen{
  private JFrame frame;

  public WelcomeScreen(){
    frame = new JFrame("MyATM");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel){
    panel.setLayout(null);
    JLabel welcomeMessage = new JLabel("Welcome to MyATM app!");
    welcomeMessage.setBounds(5,5,200,25);
    panel.add(welcomeMessage);

    JLabel identityMessage = new JLabel("Please choose your identity");
    identityMessage.setBounds(5,30,200,25);
    panel.add(identityMessage);

    JButton customerButton = new JButton("I am a customer");
    customerButton.setBounds(10, 70, 200, 30);
    customerButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new CustomerWelcomeScreen();
        }});
    panel.add(customerButton);


    JButton managerButton = new JButton("I am the manager");
    managerButton.setBounds(10, 115, 200, 30);
    panel.add(managerButton);

  }
  public void setVisible(boolean bool){
    frame.setVisible(bool);
  }

}
