package com.fishbuddy.capstone.controller;

import com.fishbuddy.capstone.model.Tank;
import com.fishbuddy.capstone.model.data.CompatibilityDao;
import com.fishbuddy.capstone.model.data.FishDao;
import com.fishbuddy.capstone.model.data.TankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/generator")
public class GeneratorController {

    @Autowired
    private FishDao fishDao;

    @Autowired
    private CompatibilityDao compatibilityDao;

    @Autowired
    private TankDao tankDao;

    private ArrayList<String> genOptions = new ArrayList<String>();

    @RequestMapping(value = "manual", method = RequestMethod.GET)
    public String manualEntry(Model model) {
        model.addAttribute("tank", new Tank());

        return "generator/manual";
    }

    @RequestMapping(value = "manual", method = RequestMethod.POST)
    public String manualProcess(Model model, @ModelAttribute @Valid Tank newTank, Errors errors) {

        if(errors.hasErrors()) {
            return "generator/manual";
        }

        tankDao.save(newTank);

        return "redirect:/";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String tankView(@PathVariable("id") int tankId, Model model) {

        Optional<Tank> opTank = tankDao.findById(tankId);
        Tank tank = opTank.orElse(null);
        model.addAttribute("fishList", fishDao.findAll());
        model.addAttribute("tank", tank);

        return "tank/view";
    }
}
