package com.project.Covoiturage.controller;

import com.project.Covoiturage.entity.Driver;
import com.project.Covoiturage.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Afficher la liste des conducteurs
    @GetMapping
    public String getAllDrivers(Model model) {
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "drivers"; // Correspond à drivers.html
    }

    // Afficher le formulaire pour ajouter un conducteur
    @GetMapping("/add")
    public String addDriverForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "add-driver"; // Correspond à add-driver.html
    }

    // Enregistrer un nouveau conducteur
    @PostMapping("/add")
    public String createDriver(@ModelAttribute Driver driver) {
        driverService.saveDriver(driver);
        return "redirect:/drivers";
    }

    // Supprimer un conducteur
    @GetMapping("/delete/{id}")
    public String deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }
}
