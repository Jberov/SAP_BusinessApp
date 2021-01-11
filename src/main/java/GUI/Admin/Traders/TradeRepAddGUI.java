package GUI.Admin.Traders;

import CommandPattern.TradeRepCommandPattern.AddTradeRep;
import DAO.TraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TradeRepAddGUI extends JFrame{
    private JPanel panel1;
    private JTextField Username;
    private JPasswordField Password;
    private JTextField email;
    private JTextField Name;
    private JButton cancelButton;
    private JButton executeButton;

    public TradeRepAddGUI() {
        setVisible (true);
        setSize (500, 400);
        setResizable (false);
        setLocationRelativeTo (null);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTradeRep addTradeRep = new AddTradeRep (new TraderDAOImpl ());
                if(addTradeRep.execute (Username.getText (), email.getText (), String.valueOf (Password.getPassword ()), Name.getText ())){
                    JOptionPane.showMessageDialog (new JPanel (), "Success");
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
                }else{
                    JOptionPane.showMessageDialog (new JPanel (), "Failure");
                }

            }

        });
        cancelButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
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
