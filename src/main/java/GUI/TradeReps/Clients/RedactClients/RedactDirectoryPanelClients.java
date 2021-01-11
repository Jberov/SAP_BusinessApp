package GUI.TradeReps.Clients.RedactClients;

import GUI.Admin.Admins.Redact.RedactAdminEmailGUI;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactDirectoryPanelClients extends JFrame{
    private JButton redactNameButton;
    private JButton redactTradeRepButton;
    private JButton redactEmailButton;
    private JButton cancelButton;
    private JPanel Panel;


    public RedactDirectoryPanelClients() {
        setTitle ("Redact directory");
        add (Panel);
        setVisible (true);
        setResizable (false);
        setSize (350, 300);
        setLocationRelativeTo (null);
        redactNameButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactClientNameGUI redactClientNameGUI = new RedactClientNameGUI ();
                setVisible (false);
                redactClientNameGUI.setVisible (true);
                redactClientNameGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });

        redactTradeRepButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactClientTradeRepNameGUI redactClientTradeRepNameGUI = new RedactClientTradeRepNameGUI ();
                setVisible (false);
                redactClientTradeRepNameGUI.setVisible (true);
                redactClientTradeRepNameGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        redactEmailButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactClientTradeRepNameGUI redactClientTradeRepNameGUI = new RedactClientTradeRepNameGUI ();
                setVisible (false);
                redactClientTradeRepNameGUI.setVisible (true);
                redactClientTradeRepNameGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        cancelButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible (false);
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.setVisible (true);
                setVisible (false);
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
    }
}
