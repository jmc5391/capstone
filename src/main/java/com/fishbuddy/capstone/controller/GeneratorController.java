package com.fishbuddy.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneratorController {

    private ArrayList<String> genOptions = new ArrayList<String>();

    @GetMapping("/generator")
    public String generator(Model model) {
        genOptions.add("Fish");
        genOptions.add("Size");
        genOptions.add("Price");
        model.addAttribute("genOptions", genOptions);

        return "generator/generator";
    }
}
