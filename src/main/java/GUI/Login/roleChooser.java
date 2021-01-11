package GUI.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class roleChooser extends JFrame{
    private JButton tradeRepButton;
    private JButton adminButton;
    private JPanel panel1;

    public roleChooser() {
        setTitle ("Account type");
        add(panel1);
        setSize (300,300);
        setResizable (false);
        setLocationRelativeTo (null);
        tradeRepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFormTrader loginTrader = new LoginFormTrader ();
                loginTrader.setVisible (true);
                setVisible (false);
                loginTrader.addWindowListener(new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                });
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFormAdmin adminLog = new LoginFormAdmin ();
                adminLog.setVisible (true);
                setVisible (false);
                adminLog.addWindowListener(new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                });
            }
        });
    }

}
