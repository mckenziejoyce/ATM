package GUI;
import OOP.*;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyATM {
  private JFrame frame;

  public static void main(String[] args){
    setUpFrame();
  }

  private static void setUpFrame(){
    TestCases tc = new TestCases();
    Customer c1 = tc.customer1();
    Customer c2 = tc.customer2();
    Customer c3 = tc.customer3();
    StockMarket sm = tc.market();
    Manager m = new Manager();
    Customer[] clist = new Customer[3];
    clist[0] = c1;
    clist[1] = c2;
    clist[2] = c3;
    m.setCustomers(clist);
    m.setStockMarket(sm);
    WelcomeScreen firstScreen = new WelcomeScreen(c1, m);
    firstScreen.setVisible(true);
  }
}
