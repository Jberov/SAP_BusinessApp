package GUI.TradeReps.Clients.RedactClients;

import CommandPattern.ClientsCommandPattern.RedactClientEmailCommand;
import DAO.ClientDAOImpl;
import GUI.TradeReps.TradeRepMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactEmailClientGUI extends JFrame{
    private JPanel panel1;
    private JTextField name;
    private JButton executeButton;
    private JButton backButton;
    private JTextField email;


    public RedactEmailClientGUI() {
        setTitle ("Redact client email");
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
        executeButton.addActionListener (e -> {
            RedactClientEmailCommand redactClientEmailCommand = new RedactClientEmailCommand (new ClientDAOImpl ());
            if(redactClientEmailCommand.execute (name.getText (), email.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Email of the client has been successfully redacted");
                setVisible (false);
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.setLocationRelativeTo (null);
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
            tradeRepMainPanel.setLocationRelativeTo (null);
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
