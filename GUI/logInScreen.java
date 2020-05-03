package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class logInScreen {
  private JFrame frame;

  public logInScreen(){
    frame = new JFrame("Sign In");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
  }
    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel messageLabel = new JLabel("Please log in to your account");
        messageLabel.setBounds(5,5,200,25);
        panel.add(messageLabel);
        // Creating JLabel
        JLabel userLabel = new JLabel("Username");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,40,80,25);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,40,165,25);
        panel.add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,70,80,25);
        panel.add(passwordLabel);

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,70,165,25);
        panel.add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("Submit");
        loginButton.setBounds(110, 110, 80, 25);
        panel.add(loginButton);
    }
    public void setVisible(boolean bool){
      frame.setVisible(bool);
    }

}
