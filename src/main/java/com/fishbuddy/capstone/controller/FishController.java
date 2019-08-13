package com.fishbuddy.capstone.controller;

import com.fishbuddy.capstone.model.Compatibility;
import com.fishbuddy.capstone.model.Difficulty;
import com.fishbuddy.capstone.model.Fish;
import com.fishbuddy.capstone.model.data.CompatibilityDao;
import com.fishbuddy.capstone.model.data.DifficultyDao;
import com.fishbuddy.capstone.model.data.FishDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "fish")
public class FishController {

    @Autowired
    private FishDao fishDao;

    @Autowired
    private CompatibilityDao compatibilityDao;

    @Autowired
    private DifficultyDao difficultyDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("fishList", fishDao.findAll());

        return "fishlist";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addFish(Model model) {
        model.addAttribute(new Fish());
        model.addAttribute("difficultyList", difficultyDao.findAll());
        model.addAttribute("compatibilityList", compatibilityDao.findAll());

        return "input/fish";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processFish(Model model, @ModelAttribute @Valid Fish newFish, @RequestParam int compId,
                              @RequestParam int diffId, Errors errors) {

        if (errors.hasErrors()) {
            System.out.println("errors!!!!");
            return "input/fish";
        }

        Optional<Compatibility> opComp = compatibilityDao.findById(compId);
        Compatibility comp = opComp.orElse(null);
        newFish.setCompatibility(comp);
        Optional<Difficulty> opDiff = difficultyDao.findById(diffId);
        Difficulty diff = opDiff.orElse(null);
        newFish.setDifficulty(diff);
        fishDao.save(newFish);
        return "redirect:";
    }
}
