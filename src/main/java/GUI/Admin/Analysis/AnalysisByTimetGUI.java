package GUI.Admin.Analysis;

import CommandPattern.AnalysisCommandPattern.AnalysisByTimeCommand;
import DAO.AnalysisTimeDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnalysisByTimetGUI extends JFrame{
    private JPanel panel1;
    private JTextField startDate;
    private JButton analyzeButton;
    private JButton backButton;
    private JTextPane Results;
    private JTextField EndDate;

    public AnalysisByTimetGUI() {
        setVisible (true);
        setResizable (false);
        setSize (600, 400);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Analysis by time");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        analyzeButton.addActionListener (e -> {
            AnalysisByTimeCommand analysisByTimeCommand = new AnalysisByTimeCommand (new AnalysisTimeDAOImpl ());
            if(!analysisByTimeCommand.execute (startDate.getText (), EndDate.getText (), Results)){
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
