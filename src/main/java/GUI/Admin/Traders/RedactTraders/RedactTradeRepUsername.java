package GUI.Admin.Traders.RedactTraders;


import CommandPattern.TradeRepCommandPattern.RedactTradeRepUsernameCommand;
import DAO.TraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactTradeRepUsername extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton redactButton;
    private JButton backButton;
    private JTextField newUsername;

    public RedactTradeRepUsername() {
        setVisible (true);
        setResizable (false);
        setLocationRelativeTo (null);
        setTitle ("Redact trader name");
        setSize (300, 300);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        redactButton.addActionListener (e -> {
            RedactTradeRepUsernameCommand redactTraderUsername = new RedactTradeRepUsernameCommand (new TraderDAOImpl ());
            if(redactTraderUsername.execute (textField1.getText (), newUsername.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Trade Representative has been successfully redacted");
                setVisible (false);
                AdminMainPanel traderMainPanel = new AdminMainPanel ();
                traderMainPanel.setVisible (true);
                traderMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        backButton.addActionListener (e -> {
            AdminMainPanel traderMainPanel = new AdminMainPanel ();
            setVisible (false);
            traderMainPanel.setVisible (true);
            traderMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
    }
}
