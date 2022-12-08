package kim.blog.home.financial.domain;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class FinancialLedger {
    final String spentAt;
    final String part;
    final String detail;
    final String revenue;
    final String expenditure;
    final String totalAmount;

}
