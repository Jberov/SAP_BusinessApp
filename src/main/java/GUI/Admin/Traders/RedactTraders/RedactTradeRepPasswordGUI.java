package GUI.Admin.Traders.RedactTraders;

import CommandPattern.TradeRepCommandPattern.RedactPasswordTradeRepCommand;
import DAO.TraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactTradeRepPasswordGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JPasswordField newPassword;

    public RedactTradeRepPasswordGUI() {
        setTitle ("Redact password");
        setVisible (true);
        setResizable (false);
        setLocationRelativeTo (null);
        setSize (300, 300);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactPasswordTradeRepCommand redactTraderPassword = new RedactPasswordTradeRepCommand (new TraderDAOImpl ());
            if(redactTraderPassword.execute (username.getText (), String.valueOf (newPassword.getPassword ()))){
                JOptionPane.showMessageDialog (new JPanel (), "Trader has been redacted");
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
