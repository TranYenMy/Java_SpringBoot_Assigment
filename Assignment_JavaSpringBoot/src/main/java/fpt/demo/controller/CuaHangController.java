package fpt.demo.controller;

import fpt.demo.entity.CuaHang;
import fpt.demo.entity.NhanVien;
import fpt.demo.repositories.CuaHangRepository;
import fpt.demo.request.CuaHangVm;
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
@RequestMapping("/cua-hang")

public class CuaHangController {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Autowired
    @Qualifier("ch_vm1")
    private CuaHangVm vm;
    private List<CuaHang> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.cuaHangRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/cuahang/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/cua-hang/store");
        return "/cuahang/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") CuaHangVm vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/cuahang/create";
        }

        CuaHang ch = new CuaHang();
        ch.loadFromViewModel(vm);
        this.cuaHangRepository.save(ch);
        return "redirect:/cua-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang, RedirectAttributes redirectAttributes) {
        try {
            this.cuaHangRepository.delete(cuaHang);
            return "redirect:/cua-hang/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa Cua hang vì có liên kết khóa ngoại.");
            return "redirect:/cua-hang/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model) {
        vm.loadFromDomainModel(cuaHang);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/cua-hang/update/" + cuaHang.getId());
        return "/cuahang/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") CuaHang oldValue,
            Model model,
            @Valid @ModelAttribute("data") CuaHangVm newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/cua-hang/update/" + oldValue.getId());
            return "/cuahang/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.cuaHangRepository.save(oldValue);
        return "redirect:/cua-hang/index";
    }

}
