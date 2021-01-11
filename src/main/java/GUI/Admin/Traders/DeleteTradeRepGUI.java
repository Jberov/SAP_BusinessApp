package GUI.Admin.Traders;

import CommandPattern.TradeRepCommandPattern.RemoveTradeRep;
import DAO.TraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteTradeRepGUI extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton deleteAdminButton;
    private JButton backButton;

    public DeleteTradeRepGUI() {
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
        deleteAdminButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveTradeRep delete = new RemoveTradeRep (new TraderDAOImpl ());
                if(delete.execute (textField1.getText ())){
                    setVisible (false);
                    AdminMainPanel adminMainPanel = new AdminMainPanel ();
                    adminMainPanel.setVisible (true);
                    adminMainPanel.addWindowListener (new WindowAdapter () {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing (e);
                            System.exit (0);
                        }
                    });
                }
            }
        });
        backButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
                setVisible (false);
                adminMainPanel.setVisible (true);
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
