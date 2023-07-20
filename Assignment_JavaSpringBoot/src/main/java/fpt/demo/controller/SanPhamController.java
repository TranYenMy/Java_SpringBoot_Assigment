package fpt.demo.controller;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.Nsx;
import fpt.demo.entity.SanPham;
import fpt.demo.repositories.DongSpRepository;
import fpt.demo.repositories.SanPhamRepository;
import fpt.demo.request.DongSpVM;
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
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    @Qualifier("sanpham_vm")
    private SanPhamVM vm;
    private List<SanPham> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.sanPhamRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/sanpham/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/san-pham/store");
        return "/sanpham/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") SanPhamVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/sanpham/create";
        }

        SanPham sanPham = new SanPham();
        sanPham.loadFromViewModel(vm);
        this.sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham, RedirectAttributes redirectAttributes) {
        try {
            this.sanPhamRepository.delete(sanPham);
            return "redirect:/san-pham/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa sản phẩm vì có liên kết khóa ngoại.");
            return "redirect:/san-pham/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model) {
        vm.loadFromDomainModel(sanPham);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/san-pham/update/" + sanPham.getId());
        return "/sanpham/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") SanPham oldValue,
            Model model,
            @Valid @ModelAttribute("data") SanPhamVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/san-pham/update/" + oldValue.getId());
            return "/sanpham/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.sanPhamRepository.save(oldValue);
        return "redirect:/san-pham/index";
    }
}
