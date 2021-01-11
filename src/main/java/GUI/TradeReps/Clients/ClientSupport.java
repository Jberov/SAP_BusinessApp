package GUI.TradeReps.Clients;

import GUI.TradeReps.Clients.RedactClients.RedactDirectoryPanelClients;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientSupport extends JFrame{
    private JPanel panel1;
    private JButton addClientButton;
    private JButton redactClientButton;
    private JButton removeClientButton;
    private JButton backButton;

    public ClientSupport() {
        setTitle ("Client support");
        setVisible (true);
        setResizable (false);
        setLocationRelativeTo (null);
        setSize (400, 300);
        add (panel1);
        backButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                TradeRepMainPanel mainTrader = new TradeRepMainPanel ();
                setVisible (false);
                mainTrader.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        removeClientButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteClient delete = new DeleteClient ();
                delete.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
                setVisible (false);
            }
        });
        addClientButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAddGUI clientAddGUI = new ClientAddGUI ();
                clientAddGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
                setVisible (false);

            }
        });
        redactClientButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible (false);
                RedactDirectoryPanelClients redactDirectoryPanelClients = new RedactDirectoryPanelClients ();
                redactDirectoryPanelClients.addWindowListener (new WindowAdapter () {
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
