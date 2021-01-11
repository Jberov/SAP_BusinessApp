package GUI.TradeReps;

import GUI.TradeReps.Clients.ClientSupport;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TradeRepMainPanel extends JFrame{
    private JPanel panel1;
    private JButton analyzeByTrader;
    private JButton AnalyseByTime;
    private JButton analyzeByProduct;

    public TradeRepMainPanel() {
        setVisible (true);
        add (panel1);
        setResizable (false);
        setLocationRelativeTo (null);
        setTitle ("Main panel");
        setSize (1100, 270);

        AnalyseByTime.addActionListener (e -> {
            ClientSupport clientSupport = new ClientSupport ();
            setVisible (false);
            clientSupport.setVisible (true);
            clientSupport.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        analyzeByProduct.addActionListener (e -> {
            Sales sale = new Sales ();
            setVisible (false);
            sale.setVisible (true);

            sale.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        analyzeByTrader.addActionListener (e -> {
            TwitterForm twitterForm = new TwitterForm ();
            twitterForm.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });

    }
}
