package fpt.demo.controller;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.GioHang;
import fpt.demo.repositories.DongSpRepository;
import fpt.demo.repositories.GioHangRepository;
import fpt.demo.request.DongSpVM;
import fpt.demo.request.GioHangVM;
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
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    @Qualifier("giohang_vm")
    private GioHangVM vm;
    private List<GioHang> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.gioHangRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/giohang/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/gio-hang/store");
        return "/giohang/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") GioHangVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/giohang/create";
        }

        GioHang gioHang = new GioHang();
        gioHang.loadFromViewModel(vm);
        this.gioHangRepository.save(gioHang);
        return "redirect:/gio-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") GioHang gioHang, RedirectAttributes redirectAttributes) {
        try {
            this.gioHangRepository.delete(gioHang);
            return "redirect:/gio-hang/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa giỏ hàng vì có liên kết khóa ngoại.");
            return "redirect:/gio-hang/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") GioHang gioHang, Model model) {
        vm.loadFromDomainModel(gioHang);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/gio-hang/update/" + gioHang.getId());
        return "/giohang/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") GioHang oldValue,
            Model model,
            @Valid @ModelAttribute("data") GioHangVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/gio-hang/update/" + oldValue.getId());
            return "/giohang/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.gioHangRepository.save(oldValue);
        return "redirect:/gio-hang/index";
    }
}
