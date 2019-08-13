package com.fishbuddy.capstone.controller;

import com.fishbuddy.capstone.model.Compatibility;
import com.fishbuddy.capstone.model.data.CompatibilityDao;
import com.fishbuddy.capstone.model.data.FishDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "compatibility")
public class CompatibilityController {

    @Autowired
    private CompatibilityDao compatibilityDao;

    @Autowired
    private FishDao fishDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute(new Compatibility());
        return "input/compatibility";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processCompatibility(Model model, @ModelAttribute @Valid Compatibility newComp, Errors errors) {

        if (errors.hasErrors()) {
            return "input/compatibility";
        }

        compatibilityDao.save(newComp);
        return "redirect:";
    }
}
