package dev.sectorsone.controller;

import dev.sectorsone.model.Involvement;
import dev.sectorsone.service.InvolvementService;
import dev.sectorsone.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/involvement")
@Controller
public class InvolvementController {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String REDIRECT_ROOT = "redirect:/";

    private final InvolvementService service;
    private final SectorService sectorService;

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("currentInvolvement") Involvement involvement,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentInvolvement", involvement);
            model.addAttribute("sectors", sectorService.findAll());
            model.addAttribute("involvements", service.findAll());
            return "index";
        }
        var result = service.save(involvement);
        if (result.getId() != null) {
            redirectAttributes.addFlashAttribute(SUCCESS, "Involvement saved.");
        } else {
            redirectAttributes.addFlashAttribute(ERROR, "Involvement could not be saved!");
        }
        return REDIRECT_ROOT;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes) {
        var result = service.findById(id);
        if (result.isPresent()) {
            model.addAttribute("currentInvolvement", result.get());
            model.addAttribute("sectors", sectorService.findAll());
            model.addAttribute("involvements", service.findAll());
            return "index";
        }
        redirectAttributes.addFlashAttribute(ERROR, "Involvement not found!");
        return REDIRECT_ROOT;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, RedirectAttributes redirectAttributes) {
        var result = service.deleteById(id);
        if (result) {
            redirectAttributes.addFlashAttribute(SUCCESS, "Contact deleted.");
        } else {
            redirectAttributes.addFlashAttribute(ERROR, "Contact could not be deleted!");
        }
        return REDIRECT_ROOT;
    }
}
