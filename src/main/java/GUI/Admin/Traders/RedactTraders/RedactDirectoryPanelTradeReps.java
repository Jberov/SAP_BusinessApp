package GUI.Admin.Traders.RedactTraders;

import GUI.Admin.Admins.AdminMainPanel;
import GUI.Admin.Admins.Redact.RedactAdminEmailGUI;
import GUI.Admin.Admins.Redact.RedactAdminNameGUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactDirectoryPanelTradeReps extends JFrame{
    private JButton redactUsernameButton;
    private JButton redactPasswordButton;
    private JButton redactEmailButton;
    private JButton redactNameButton;
    private JButton cancelButton;
    private JPanel Panel;


    public RedactDirectoryPanelTradeReps() {
        setTitle ("Redact directory");
        add (Panel);
        setLocationRelativeTo (null);
        setVisible (true);
        setResizable (false);
        setSize (350, 300);
        redactUsernameButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactTradeRepUsername redactTradeRepUsername = new RedactTradeRepUsername ();
                setVisible (false);
                redactTradeRepUsername.setVisible (true);
                redactTradeRepUsername.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        redactPasswordButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactTradeRepPasswordGUI redactTradeRepPasswordGUI = new RedactTradeRepPasswordGUI ();
                setVisible (false);
                redactTradeRepPasswordGUI.setVisible (true);
                redactTradeRepPasswordGUI.addWindowListener (new WindowAdapter () {
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
                RedactTradeRepEmailGUI redactAdminEmailGUI = new RedactTradeRepEmailGUI ();
                setVisible (false);
                redactAdminEmailGUI.setVisible (true);
                redactAdminEmailGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        redactNameButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactTradeRepNameGUI redactAdminNameGUI = new RedactTradeRepNameGUI ();
                setVisible (false);
                redactAdminNameGUI.setVisible (true);
                redactAdminNameGUI.addWindowListener (new WindowAdapter () {
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
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
                adminMainPanel.setVisible (true);
                setVisible (false);
                adminMainPanel.addWindowListener (new WindowAdapter () {
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
