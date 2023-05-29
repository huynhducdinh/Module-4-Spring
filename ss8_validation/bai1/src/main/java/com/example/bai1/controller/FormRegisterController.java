package com.example.bai1.controller;

import com.example.bai1.dto.FormRegisterDTO;
import com.example.bai1.model.FormRegisterModel;
import com.example.bai1.service.IFormRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FormRegisterController {
    @Autowired
    private IFormRegisterService iFormRegisterService;
    @GetMapping("/")
    public String listForm(Model model){
        List<FormRegisterModel>formRegisterModelList=iFormRegisterService.findAll();
        model.addAttribute("formRegisterModelList",formRegisterModelList);
        return "list";
    }
    @GetMapping("/createForm")
    public String create(Model model){
        model.addAttribute("formRegisterDTO",new FormRegisterDTO());
        return "form";
    }
    @PostMapping("createFormModel")
    public String createForm(@Validated @ModelAttribute("formRegisterDTO")  FormRegisterDTO formRegisterDTO, BindingResult bindingResult, RedirectAttributes attributes) {
        new FormRegisterDTO().validate(formRegisterDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            FormRegisterModel formRegisterModel = new FormRegisterModel();
            BeanUtils.copyProperties(formRegisterDTO, formRegisterModel);
            iFormRegisterService.save(formRegisterModel);
            attributes.addFlashAttribute("mess",true);
            return "redirect:/";
        }
    }

}
