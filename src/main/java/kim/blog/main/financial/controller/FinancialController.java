package kim.blog.main.financial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial")
public class FinancialController {

    @GetMapping
    public String financial() {
        return "/financial/financialMain";
    }
}
