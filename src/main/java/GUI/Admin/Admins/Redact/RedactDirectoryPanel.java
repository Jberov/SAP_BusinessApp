package GUI.Admin.Admins.Redact;

import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactDirectoryPanel extends JFrame{
    private JButton redactUsernameButton;
    private JButton redactPasswordButton;
    private JButton redactEmailButton;
    private JButton redactNameButton;
    private JButton cancelButton;
    private JPanel Panel;


    public RedactDirectoryPanel() {
        setTitle ("Redact directory");
        add (Panel);
        setVisible (true);
        setResizable (false);
        setSize (350, 300);
        setLocationRelativeTo (null);
        setTitle ("Redact directory");
        redactUsernameButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactAdminUsername redactAdminUsername = new RedactAdminUsername ();
                setVisible (false);
                redactAdminUsername.setVisible (true);
                redactAdminUsername.addWindowListener (new WindowAdapter () {
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
                RedactAdminPasswordGUI redactAdminPasswordGUI = new RedactAdminPasswordGUI ();
                setVisible (false);
                redactAdminPasswordGUI.setVisible (true);
                redactAdminPasswordGUI.addWindowListener (new WindowAdapter () {
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
                RedactAdminEmailGUI redactAdminEmailGUI = new RedactAdminEmailGUI ();
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
                RedactAdminNameGUI redactAdminNameGUI = new RedactAdminNameGUI ();
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
