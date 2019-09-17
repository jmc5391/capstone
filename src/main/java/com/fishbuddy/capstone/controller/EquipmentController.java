package com.fishbuddy.capstone.controller;

import com.fishbuddy.capstone.model.Equipment;
import com.fishbuddy.capstone.model.Type;
import com.fishbuddy.capstone.model.data.EquipmentDao;
import com.fishbuddy.capstone.model.data.equipment.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private TypeDao typeDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addEquipment(Model model) {

        model.addAttribute(new Equipment());
        model.addAttribute("typeList", typeDao.findAll());
        return "equipment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processEquipment(Model model, @Valid Equipment aEquip, @RequestParam int typeId, Errors errors) {

        if (errors.hasErrors()) {
            return "equipment/add";
        }

        Optional<Type> opType = typeDao.findById(typeId);
        Type aType = opType.orElse(null);
        aEquip.setType(aType);
        aEquip.setTypeName(aType.getName());
        equipmentDao.save(aEquip);
        return "redirect:/";
    }

    @RequestMapping(value = "type", method = RequestMethod.GET)
    public String addType(Model model) {

        model.addAttribute(new Type());
        return "equipment/type";
    }

    @RequestMapping(value = "type", method = RequestMethod.POST)
    public String processType(Model model, @Valid Type aType, Errors errors) {

        if (errors.hasErrors()) {
            return "equipment/type";
        }

        typeDao.save(aType);
        return "redirect:/";
    }
}
