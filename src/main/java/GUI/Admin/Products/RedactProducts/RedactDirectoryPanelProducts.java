package GUI.Admin.Products.RedactProducts;

import GUI.Admin.Admins.AdminMainPanel;
import GUI.Admin.Admins.Redact.RedactAdminEmailGUI;
import GUI.Admin.Admins.Redact.RedactAdminNameGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactDirectoryPanelProducts extends JFrame{
    private JButton redactNameButton;
    private JButton redactPriceButton;
    private JButton redactQuantityButton;
    private JButton redactEmailButton;
    private JButton cancelButton;
    private JPanel Panel;


    public RedactDirectoryPanelProducts() {
        setTitle ("Redact directory");
        add (Panel);
        setVisible (true);
        setResizable (false);
        setSize (350, 300);
        setLocationRelativeTo (null);
        redactNameButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactProductNameGUI redactProductNameGUI = new RedactProductNameGUI ();
                setVisible (false);
                redactProductNameGUI.setVisible (true);
                redactProductNameGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);

                    }
                });
            }
        });
        redactPriceButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactProductPriceGUI redactProductPriceGUI = new RedactProductPriceGUI ();
                setVisible (false);
                redactProductPriceGUI.setVisible (true);
                redactProductPriceGUI.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);

                    }
                });
            }
        });
        redactQuantityButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedactProductQuantityGUI redactProductQuantityGUI = new RedactProductQuantityGUI ();
                setVisible (false);
                redactProductQuantityGUI.setVisible (true);
                redactProductQuantityGUI.addWindowListener (new WindowAdapter () {
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
                RedactProductTradeRepEmailGUI redactProductTradeRepEmailGUI = new RedactProductTradeRepEmailGUI ();
                setVisible (false);
                redactProductTradeRepEmailGUI.setVisible (true);
                redactProductTradeRepEmailGUI.addWindowListener (new WindowAdapter () {
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
