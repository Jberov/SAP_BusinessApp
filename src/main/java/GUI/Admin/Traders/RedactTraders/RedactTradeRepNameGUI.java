package GUI.Admin.Traders.RedactTraders;

import CommandPattern.TradeRepCommandPattern.RedactNameTradeRepCommand;
import DAO.TraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactTradeRepNameGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField name;


    public RedactTradeRepNameGUI() {
        setVisible (true);
        setResizable (false);
        setLocationRelativeTo (null);
        setSize (300, 300);
        add (panel1);
        setTitle ("Redact trader name");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactNameTradeRepCommand redactTradeRepName = new RedactNameTradeRepCommand (new TraderDAOImpl ());
            if(redactTradeRepName.execute (username.getText (), name.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "TradeRep has been successfully redacted");
                setVisible (false);
                AdminMainPanel tradeRepMainPanel = new AdminMainPanel ();
                tradeRepMainPanel.setVisible (true);
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        backButton.addActionListener (e -> {
            AdminMainPanel tradeRepMainPanel = new AdminMainPanel ();
            setVisible (false);
            tradeRepMainPanel.setVisible (true);
            tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
    }
}
