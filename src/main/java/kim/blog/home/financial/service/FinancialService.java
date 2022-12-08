package kim.blog.home.financial.service;

import kim.blog.home.financial.domain.FinancialLedger;

import java.util.List;

public interface FinancialService {
    public List<FinancialLedger> inquireFinancialLedger(String financialDate);
    public void updateFinancialLedger(String financialDate, List<FinancialLedger> financialLedger);
}
