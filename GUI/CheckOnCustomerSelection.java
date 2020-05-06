package GUI;
import OOP.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

public class CheckOnCustomerSelection{
  private JFrame frame;

  public CheckOnCustomerSelection(Manager m){
      frame = new JFrame("MyATM");
      frame.setSize(500, 300);
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      JPanel panel = new JPanel();
      frame.add(panel);
      placeComponents(panel, m);
      frame.setVisible(true);
  }

  private void placeComponents(JPanel panel, Manager m){
    panel.setLayout(null);
    JLabel headerMessage = new JLabel("Check on a Customer");
    headerMessage.setBounds(5,5,200,25);
    panel.add(headerMessage);

    JLabel lineOne = new JLabel("Which customer would you like to check on?");
    lineOne.setBounds(5,25,300,25);
    panel.add(lineOne);

    Customer[] customers = m.getCustomers();
    int lol = 0;
    if(customers != null){
      lol = customers.length;
    }
    int y = 40;
    for(int i=0; i< lol; i++){
      String custLabel = "Customer "+(i+1)+ ":" + customers[i].getName();
      JLabel custName = new JLabel(custLabel);
      custName.setBounds(19,y,200,25);
      panel.add(custName);
      y += 15;
    }
    JLabel lineTwo = new JLabel("Enter the corresponding number of the customer");
    lineTwo.setBounds(5,y,400,25);
    panel.add(lineTwo);

    y += 20;
    JTextField userText = new JTextField(50);
    userText.setBounds(5,y,165,25);
    panel.add(userText);

    y += 30;
    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(40, y, 100, 25);
    submitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Customer[] notcustomers = m.getCustomers();
        int notlol = 0;
        if(notcustomers != null){
          notlol = notcustomers.length;
        }
        String account = userText.getText();
        int custNum = Integer.parseInt(account);
        boolean cont = (custNum > notlol) && (custNum < 0);
        if(cont){
          Customer selectedCustomer = customers[custNum-1];
          frame.dispose();
          new ManagerCustomerDisplayScreen(selectedCustomer);
        }
        else{
          userText.setText("");
          new InvalidEntryPopUp("That account does not exist");
        }
        }});
    panel.add(submitButton);

  }

}
