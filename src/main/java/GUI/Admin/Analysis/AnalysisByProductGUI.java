package GUI.Admin.Analysis;

import CommandPattern.AnalysisCommandPattern.AnalysisByProductCommand;
import CommandPattern.AnalysisCommandPattern.AnalysisByTraderCommand;
import DAO.AnalysisProdDAOImpl;
import DAO.AnalysisTraderDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnalysisByProductGUI extends JFrame{
    private JPanel panel1;
    private JTextField prodName;
    private JButton deleteProductButton;
    private JButton backButton;
    private JTextPane textPane1;

    public AnalysisByProductGUI() {
        setVisible (true);
        setResizable (false);
        setSize (600, 400);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Analysis by product");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        deleteProductButton.addActionListener (e -> {
            AnalysisByProductCommand analysisByProductCommand = new AnalysisByProductCommand (new AnalysisProdDAOImpl());
            if(!analysisByProductCommand.execute (prodName.getText (), textPane1)){
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
                }
            });
        });
    }
}
