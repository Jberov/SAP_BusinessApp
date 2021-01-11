package GUI.TradeReps.Clients;

import CommandPattern.ClientsCommandPattern.AddClient;
import DAO.ClientDAOImpl;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientAddGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JTextField email;
    private JTextField name;
    private JButton cancelButton;
    private JButton executeButton;

    public ClientAddGUI() {
        setTitle ("Add client");
        setVisible (true);
        setSize (500, 400);
        setResizable (false);
        add (panel1);
        setLocationRelativeTo (null);
        executeButton.addActionListener (el -> {
            AddClient addClient = new AddClient (new ClientDAOImpl ());
            if(addClient.execute (username.getText (), email.getText (), name.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Success");
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
                setVisible (false);
            }else{
                JOptionPane.showMessageDialog (new JPanel (), "Failure");
            }

        });
        cancelButton.addActionListener (e -> {
            TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
            tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
            setVisible (false);
        });
    }
}
