package GUI.Login;

import CommandPattern.TradeRepCommandPattern.TradeRepLoginCommand;
import DAO.LoginDAO;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class LoginFormTrader extends JFrame{
    private JPanel panel1;
    private JFormattedTextField formattedTextField1;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;

    public LoginFormTrader() {
        setTitle ("Login");
        setResizable (false);
        add (panel1);
        setSize (400, 300);
        setLocationRelativeTo (null);
        loginButton.addActionListener (e -> {
                TradeRepLoginCommand traderlog = new TradeRepLoginCommand (new LoginDAO ());
                if(traderlog.execute(textField1.getText (), String.valueOf (passwordField1.getPassword ()))){
                    TradeRepMainPanel traderMain = new TradeRepMainPanel ();
                    setVisible (false);
                    traderMain.setLocationRelativeTo (null);
                    traderMain.addWindowListener(new WindowAdapter () {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            System.exit(0);
                        }
                    });
                }
        });

    }
}
