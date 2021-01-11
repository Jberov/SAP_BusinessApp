package GUI.TradeReps.Clients.RedactClients;

import CommandPattern.ClientsCommandPattern.RedactClientNameCommand;
import DAO.ClientDAOImpl;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactClientNameGUI extends JFrame{
    private JPanel panel1;
    private JTextField oldName;
    private JButton executeButton;
    private JButton backButton;
    private JTextField newName;


    public RedactClientNameGUI() {
        setVisible (true);
        setTitle ("Redact client name");
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        executeButton.addActionListener (e -> {
            RedactClientNameCommand redactClientNameCommand = new RedactClientNameCommand (new ClientDAOImpl ());
            if(redactClientNameCommand.execute (oldName.getText (), newName.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Client has been successfully redacted");
                setVisible (false);
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.setVisible (true);
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        backButton.addActionListener (e -> {
            TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
            setVisible (false);
            tradeRepMainPanel.setVisible (true);
            tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
    }
}
