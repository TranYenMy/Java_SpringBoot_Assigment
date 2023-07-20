package fpt.demo.controller;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.Nsx;
import fpt.demo.repositories.DongSpRepository;
import fpt.demo.repositories.NsxRepository;
import fpt.demo.request.DongSpVM;
import fpt.demo.request.NsxVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/dong-sp")
public class DongSpController {
    @Autowired
    private DongSpRepository dongSpRepository;

    @Autowired
    @Qualifier("dongsp_vm")
    private DongSpVM vm;
    private List<DongSp> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.dongSpRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/dongsp/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/dong-sp/store");
        return "/dongsp/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") DongSpVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/dongsp/create";
        }

        DongSp dongSp = new DongSp();
        dongSp.loadFromViewModel(vm);
        this.dongSpRepository.save(dongSp);
        return "redirect:/dong-sp/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSp dongSp, RedirectAttributes redirectAttributes) {
        try {
            this.dongSpRepository.delete(dongSp);
            return "redirect:/dong-sp/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa DongSp vì có liên kết khóa ngoại.");
            return "redirect:/dong-sp/index";

        }
    }



    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DongSp dongSp, Model model) {
        vm.loadFromDomainModel(dongSp);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/dong-sp/update/" + dongSp.getId());
        return "/dongsp/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") DongSp oldValue,
            Model model,
            @Valid @ModelAttribute("data") DongSpVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/dong-sp/update/" + oldValue.getId());
            return "/dongsp/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.dongSpRepository.save(oldValue);
        return "redirect:/dong-sp/index";
    }
}
