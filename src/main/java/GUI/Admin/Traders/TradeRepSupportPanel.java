package GUI.Admin.Traders;

import GUI.Admin.Admins.AdminMainPanel;
import GUI.Admin.Traders.RedactTraders.RedactDirectoryPanelTradeReps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TradeRepSupportPanel extends JFrame{
    private JPanel panel1;
    private JButton addNewTradeRepesentativeButton;
    private JButton redactExistingTradeRepesentativeButton;
    private JButton deleteTradeRepesentativeButton;
    private JButton backButton;

    public TradeRepSupportPanel() {
        setTitle ("TradeRep support");
        setSize (400,300);
        setResizable (false);
        setLocationRelativeTo (null);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        addNewTradeRepesentativeButton.addActionListener (e -> {
            TradeRepAddGUI tradeRepAddGUI = new TradeRepAddGUI ();
            tradeRepAddGUI.setVisible (true);
            setVisible (false);
            tradeRepAddGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        redactExistingTradeRepesentativeButton.addActionListener (e -> {
            RedactDirectoryPanelTradeReps redactDirectoryPanelTradeReps = new RedactDirectoryPanelTradeReps ();
            redactDirectoryPanelTradeReps.setVisible (true);
            redactDirectoryPanelTradeReps.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);

                }
            });
            setVisible (false);

        });
        deleteTradeRepesentativeButton.addActionListener (e -> {
            DeleteTradeRepGUI deleteTradeRepGUI = new DeleteTradeRepGUI ();
            deleteTradeRepGUI.setVisible (true);
            setVisible (false);
            deleteTradeRepGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        backButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMainPanel mainAdmin = new AdminMainPanel ();
                mainAdmin.setVisible (true);
                setVisible (false);
                mainAdmin.addWindowListener (new WindowAdapter () {
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
