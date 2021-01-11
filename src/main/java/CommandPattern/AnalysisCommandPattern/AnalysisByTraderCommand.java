package CommandPattern.AnalysisCommandPattern;

import DAO.AnalysisTraderDAOImpl;

import javax.swing.*;

public class AnalysisByTraderCommand{
    private final AnalysisTraderDAOImpl traderanalysis;

    public AnalysisByTraderCommand(AnalysisTraderDAOImpl traderanalysis) {
        this.traderanalysis = traderanalysis;
    }

    public boolean execute(String trader, JTextPane result) {
        return traderanalysis.analyze (trader, result);
    }
}
