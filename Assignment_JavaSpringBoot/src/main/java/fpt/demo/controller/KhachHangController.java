package fpt.demo.controller;

import fpt.demo.entity.HoaDon;
import fpt.demo.entity.KhachHang;
import fpt.demo.entity.SanPham;
import fpt.demo.repositories.KhachHangRepository;
import fpt.demo.repositories.SanPhamRepository;
import fpt.demo.request.KhachHangVM;
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
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    @Qualifier("kh_vm")
    private KhachHangVM vm;
    private List<KhachHang> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model , @ModelAttribute("error") String error) {
        list = this.khachHangRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/khachhang/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/khach-hang/store");
        return "/khachhang/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") KhachHangVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/khachhang/create";
        }

        KhachHang khachHang = new KhachHang();
        khachHang.loadFromViewModel(vm);
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang, RedirectAttributes redirectAttributes) {
        try {
            this.khachHangRepository.delete(khachHang);
            return "redirect:/khach-hang/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa khách hàng vì có liên kết khóa ngoại.");
            return "redirect:/khach-hang/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KhachHang khachHang, Model model) {
        vm.loadFromDomainModel(khachHang);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/khach-hang/update/" + khachHang.getId());
        return "/khachhang/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") KhachHang oldValue,
            Model model,
            @Valid @ModelAttribute("data") KhachHangVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/khach-hang/update/" + oldValue.getId());
            return "/khachhang/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.khachHangRepository.save(oldValue);
        return "redirect:/khach-hang/index";
    }

}
