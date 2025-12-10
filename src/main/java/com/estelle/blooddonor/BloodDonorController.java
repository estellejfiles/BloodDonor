package com.estelle.blooddonor;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// controller = collection of methods used to return info to user as response to their activity/input
@Controller
public class BloodDonorController {

    // accesses form when user goes to homepage
    @GetMapping
    // method to fetch and display donor form
    public String showDonorForm(Model model) {
        // create new donor object (it is empty right now); add as model attribute
        model.addAttribute("donor", new Donor());
        // return donor form template to display to user
        return "donor_form";
    }

    // sends data when user submits form
    @PostMapping("/submitDonorForm")
    // method to process & package data entered in form by user
    public String processDonorForm(@Valid Donor donor, BindingResult bindingResult, Model model) {
        // executes if there are field errors
        if (bindingResult.hasErrors()) {
            // read through field errors in binding result; store in list
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            // create map for error messages from binding result (now stored in list)
            Map<String, String> validationErrorMap = ErrorUtils.createErrorMap(fieldErrors);
            // add error map as model attribute
            model.addAttribute("validationErrorMap", validationErrorMap);
            // return donor form with errors
            return "donor_form";
        } else { // execute if no errors
            // variable to store the message for user's eligibility
            String resultMessage;
            // create list to store reasons they may not be eligible
            List<String> ineligibleReasons = new ArrayList<>();

            // execute if the donor is too young
            if (donor.getAge() < 16) {
                // add message that user is too young to list
                ineligibleReasons.add("Age must be at least 16");
            }

            // execute if donor weighs too little
            if (donor.getWeight() < 110) {
                // add message that user weighs too little to list
                ineligibleReasons.add("Weight must be at least 110lbs");
            }

            // execute if there are no ineligibility reasons in the list
            if (ineligibleReasons.isEmpty()) {
                // modify resultMessage to say user may be eligible
                resultMessage = "You may be eligible to donate blood";
            } else { // execute if there are ineligibility reasons
                // modify resultMessage to say user is not eligible
                resultMessage = "You are not eligible to donate blood";
                // add ineligible reasons to model template
                model.addAttribute("ineligibleReasons", ineligibleReasons);
            }

            // add resultMessage as model attribute
            model.addAttribute("resultMessage", resultMessage);

            // return results template to display to user
            return "results";
        }
    }
}
