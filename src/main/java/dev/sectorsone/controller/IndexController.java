package dev.sectorsone.controller;

import dev.sectorsone.model.Involvement;
import dev.sectorsone.service.InvolvementService;
import dev.sectorsone.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final SectorService sectorService;
    private final InvolvementService involvementService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentInvolvement", new Involvement());
        model.addAttribute("sectors", sectorService.findAll());
        model.addAttribute("involvements", involvementService.findAll());
        return "index";
    }
}
