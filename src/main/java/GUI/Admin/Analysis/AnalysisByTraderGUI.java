package GUI.Admin.Analysis;

import CommandPattern.AnalysisCommandPattern.AnalysisByTraderCommand;
import DAO.AnalysisTraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnalysisByTraderGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton deleteProductButton;
    private JButton backButton;
    private JTextPane textPane1;

    public AnalysisByTraderGUI() {
        setVisible (true);
        setResizable (false);
        setSize (600, 400);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Analyse by trader");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        deleteProductButton.addActionListener (e -> {
            AnalysisByTraderCommand analysisByTraderCommand = new AnalysisByTraderCommand (new AnalysisTraderDAOImpl());
            if(!analysisByTraderCommand.execute (username.getText (), textPane1)){
                JOptionPane.showMessageDialog (new JPanel (), "Analysis failed");
            }
        });
        backButton.addActionListener (e -> {
            AdminMainPanel adminMainPanel = new AdminMainPanel ();
            setVisible (false);
            adminMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
    }
}
