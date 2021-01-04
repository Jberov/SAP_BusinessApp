package CommandPattern;

import DAO.AnalysisTraderDAOImpl;

public class AnalysisByTraderCommand implements Command{
    private final AnalysisTraderDAOImpl traderanalysis;

    public AnalysisByTraderCommand(AnalysisTraderDAOImpl traderanalysis) {
        this.traderanalysis = traderanalysis;
    }

    @Override
    public void execute() {
        traderanalysis.analyze ();
    }
}
