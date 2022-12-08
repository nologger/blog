package kim.blog.home.financial.controller;

import kim.blog.home.financial.domain.FinancialLedger;
import kim.blog.home.financial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/home/financial")
public class FinancialController {
    @Autowired
    FinancialService financialService;

    @GetMapping
    public String financial(@RequestParam(required = false) String financialDate, Model model) {
        String view = "/main/financial/financialLedger";

        // default now date
        if (financialDate.isEmpty()) {
            financialDate = LocalDate.now().toString();
        }
        List<FinancialLedger> financialLedger = financialService.inquireFinancialLedger(financialDate);
        model.addAttribute("financialDate", financialDate);
        model.addAttribute("financialLedger", financialLedger);

        return view;
    }

    @GetMapping("/modify")
    public String modify(@RequestParam String financialDate, Model model) {
        String view = "/main/financial/modifyFinancialLedger";

        // default now date
        if (financialDate.isEmpty()) {
            financialDate = LocalDate.now().toString();
        }
        List<FinancialLedger> financialLedger = financialService.inquireFinancialLedger(financialDate);
        model.addAttribute("financialDate", financialDate);
        model.addAttribute("financialLedger", financialLedger);

        return view;
    }

    @PostMapping("/modify")
    public String modify(@RequestParam String financialDate, @RequestParam List<FinancialLedger> financialLedger, Model model) {
        String view = "/main/financial/financialLedger";

        // default now date
        if (financialDate.isEmpty()) {
            financialDate = LocalDate.now().toString();
        }

        // update financial ledger
        financialService.updateFinancialLedger(financialDate, financialLedger);

        // inquire
        financialLedger = financialService.inquireFinancialLedger(financialDate);
        model.addAttribute("financialDate", financialDate);
        model.addAttribute("financialLedger", financialLedger);

        return view;
    }
}
