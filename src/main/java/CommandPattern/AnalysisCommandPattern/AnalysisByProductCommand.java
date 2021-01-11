package CommandPattern.AnalysisCommandPattern;

import DAO.AnalysisProdDAOImpl;

import javax.swing.*;

public class AnalysisByProductCommand{
    private final AnalysisProdDAOImpl prod;

    public AnalysisByProductCommand(AnalysisProdDAOImpl prod) {
        this.prod = prod;
    }
    public boolean execute(String product, JTextPane text) {
        return prod.analyze (product, text);
    }
}
