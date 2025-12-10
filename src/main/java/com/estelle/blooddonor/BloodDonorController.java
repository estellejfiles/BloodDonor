package com.estelle.blooddonor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// controller = collection of methods used to return info to user as response to their activity/input
@Controller
public class BloodDonorController {

    @GetMapping
    public String showDonorForm(Model model) {
        // create new donor object (it is empty right now)
        model.addAttribute("donor", new Donor());
        // return template
        return "donor_form";
    }
}
