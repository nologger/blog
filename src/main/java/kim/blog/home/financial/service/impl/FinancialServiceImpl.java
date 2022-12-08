package kim.blog.home.financial.service.impl;

import kim.blog.home.financial.domain.FinancialLedger;
import kim.blog.home.financial.service.FinancialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {
    @Override
    public List<FinancialLedger> inquireFinancialLedger(String financialDate) {
        return null;
    }

    @Override
    public void updateFinancialLedger(String financialDate, List<FinancialLedger> financialLedger) {

    }
}
