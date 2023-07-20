package fpt.demo.controller;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.MauSac;
import fpt.demo.entity.SanPham;
import fpt.demo.repositories.MauSacRepository;
import fpt.demo.repositories.SanPhamRepository;
import fpt.demo.request.MauSacVM;
import fpt.demo.request.SanPhamVM;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    @Qualifier("mausac_vm")
    private MauSacVM vm;
    private List<MauSac> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.mauSacRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "mausac/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/mau-sac/store");
        return "/mausac/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") MauSacVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/mausac/create";
        }

        MauSac mauSac = new MauSac();
        mauSac.loadFromViewModel(vm);
        this.mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac, RedirectAttributes redirectAttributes) {
        try {
            this.mauSacRepository.delete(mauSac);
            return "redirect:/mau-sac/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa màu sắc vì có liên kết khóa ngoại.");
            return "redirect:/mau-sac/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model) {
        vm.loadFromDomainModel(mauSac);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/mau-sac/update/" + mauSac.getId());
        return "/mausac/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") MauSac oldValue,
            Model model,
            @Valid @ModelAttribute("data") MauSacVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/mau-sac/update/" + oldValue.getId());
            return "/mausac/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.mauSacRepository.save(oldValue);
        return "redirect:/mau-sac/index";
    }
}
