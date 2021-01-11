package GUI.TradeReps.Clients.RedactClients;

import CommandPattern.ClientsCommandPattern.RedactTradeNameRepClientCommand;
import DAO.ClientDAOImpl;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactClientTradeRepNameGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField TradeRepName;

    public RedactClientTradeRepNameGUI() {
        setTitle ("Redact client TradeRep");
        setVisible (true);
        setResizable (false);
        setSize (450, 300);
        add (panel1);
        setLocationRelativeTo (null);
        executeButton.addActionListener (e -> {
            RedactTradeNameRepClientCommand redactTradeNameRepClientCommand = new RedactTradeNameRepClientCommand (new ClientDAOImpl ());
            if(redactTradeNameRepClientCommand.execute (username.getText (), TradeRepName.getText())){
                JOptionPane.showMessageDialog (new JPanel (), "Name of the TradeRep has been redacted");
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
