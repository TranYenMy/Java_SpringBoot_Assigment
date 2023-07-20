package fpt.demo.controller;

import fpt.demo.entity.ChucVu;
import fpt.demo.entity.Nsx;
import fpt.demo.repositories.ChucVuRepository;
import fpt.demo.repositories.NsxRepository;
import fpt.demo.request.ChucVuVM;
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
@RequestMapping("/nsx")
public class NsxController {
    @Autowired
    private NsxRepository nsxRepository;

    @Autowired
    @Qualifier("nsx_vm")
    private NsxVM vm;
    private List<Nsx> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.nsxRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);

        return "/nsx/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/nsx/store");
        return "/nsx/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") NsxVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/nsx/create";
        }

        Nsx nsx = new Nsx();
        nsx.loadFromViewModel(vm);
        this.nsxRepository.save(nsx);
        return "redirect:/nsx/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Nsx nsx, RedirectAttributes redirectAttributes) {
        try {
            this.nsxRepository.delete(nsx);
            return "redirect:/nsx/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa NSX vì có liên kết khóa ngoại.");
            return "redirect:/nsx/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Nsx nsx, Model model) {
        vm.loadFromDomainModel(nsx);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/nsx/update/" + nsx.getId());
        return "/nsx/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") Nsx oldValue,
            Model model,
            @Valid @ModelAttribute("data") NsxVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/nsx/update/" + oldValue.getId());
            return "/nsx/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.nsxRepository.save(oldValue);
        return "redirect:/nsx/index";
    }
}
