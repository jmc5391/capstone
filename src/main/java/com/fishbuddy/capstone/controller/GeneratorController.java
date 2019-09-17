package com.fishbuddy.capstone.controller;

import com.fishbuddy.capstone.model.Equipment;
import com.fishbuddy.capstone.model.Fish;
import com.fishbuddy.capstone.model.Tank;
import com.fishbuddy.capstone.model.data.CompatibilityDao;
import com.fishbuddy.capstone.model.data.EquipmentDao;
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
@SessionAttributes("tempTank")
@RequestMapping(value = "/generator")
public class GeneratorController {

    @Autowired
    private FishDao fishDao;

    @Autowired
    private CompatibilityDao compatibilityDao;

    @Autowired
    private TankDao tankDao;

    @Autowired
    private EquipmentDao equipmentDao;

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

        int amount = 0;
        Optional<Tank> opTank = tankDao.findById(tankId);
        Tank tank = opTank.orElse(null);
        model.addAttribute("fish", new Fish());
        model.addAttribute("amount", amount);
        model.addAttribute("fishList", fishDao.findAll());
        model.addAttribute("tank", tank);

        return "tank/view";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String generatorStepOne(Model model) {

        ArrayList<String> genOptions = new ArrayList<>();
        genOptions.add("Tank Size");
        model.addAttribute("genOptions", genOptions);
        return "generator/generator";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String generatorStepTwo(Model model, @ModelAttribute("tempTank") Tank tempTank, @RequestParam String choice,
                                   @RequestParam String step) {

        if(choice.equals("Tank Size")) {

            return "generator/tanksize";
        }

        if(step.equals("two")) {

            int gallons = Integer.parseInt(choice);
            tempTank.setGal(gallons);
            tempTank.setGlassTank(tempTank.findEquipment(equipmentDao.findAll(), "Tank"));
            model.addAttribute("tank", tempTank);
            return "generator/tankconfirm";
        }

        if(step.equals("three")) {

            tempTank.setHeater(tempTank.findEquipment(equipmentDao.findAll(), "Heater"));
            tempTank.setFilter(tempTank.findEquipment(equipmentDao.findAll(), "Filter"));
            tempTank.setStand(tempTank.findEquipment(equipmentDao.findAll(), "Stand"));
            tempTank.setLight(tempTank.findEquipment(equipmentDao.findAll(), "Light"));
            tempTank.setCost();
            model.addAttribute("tank", tempTank);
            return "tankview";
        }

        return "redirect:/";
    }

    @ModelAttribute("tempTank")
    public Tank tempTank() {
        return new Tank();
    }
}
