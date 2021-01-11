package GUI.TradeReps.Clients;

import CommandPattern.ClientsCommandPattern.RemoveClient;
import DAO.ClientDAOImpl;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteClient extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton deleteClientButton;
    private JButton backButton;

    public DeleteClient() {
        setTitle ("Delete client");
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        deleteClientButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveClient delete = new RemoveClient (new ClientDAOImpl ());
                if(delete.execute (textField1.getText ())){
                    JOptionPane.showMessageDialog (new JPanel (), "Client has been deleted");
                    setVisible (false);
                    TradeRepMainPanel mainTrader = new TradeRepMainPanel ();
                    mainTrader.addWindowListener (new WindowAdapter () {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing (e);
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
                TradeRepMainPanel mainTrader = new TradeRepMainPanel ();
                setVisible (false);
                mainTrader.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
    }
}
