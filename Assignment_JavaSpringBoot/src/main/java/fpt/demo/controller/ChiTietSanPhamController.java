package fpt.demo.controller;

import fpt.demo.entity.ChiTietSanPham;
import fpt.demo.entity.CuaHang;
import fpt.demo.entity.DongSp;
import fpt.demo.entity.GioHang;
import fpt.demo.entity.MauSac;
import fpt.demo.entity.Nsx;
import fpt.demo.entity.SanPham;
import fpt.demo.repositories.ChiTietSpRepository;
import fpt.demo.repositories.DongSpRepository;
import fpt.demo.repositories.MauSacRepository;
import fpt.demo.repositories.NsxRepository;
import fpt.demo.repositories.SanPhamRepository;
import fpt.demo.request.ChiTietSanPhamVM;
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
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSpRepository chiTietSpRepository;

    @Autowired
    private NsxRepository nsxRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private DongSpRepository dongSpRepository;


    @Autowired
    @Qualifier("chitietSp_vm")
    private ChiTietSanPhamVM vm;
    private List<ChiTietSanPham> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model, @ModelAttribute("error") String error) {
        list = this.chiTietSpRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/sanpham_chitiet/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        List<SanPham> listSp = this.sanPhamRepository.findAll();
        model.addAttribute("listSp", listSp);
        List<MauSac> listMs = this.mauSacRepository.findAll();
        model.addAttribute("listMs", listMs);
        List<Nsx> listNsx = this.nsxRepository.findAll();
        model.addAttribute("listNsx", listNsx);
        List<DongSp> listDongSp = this.dongSpRepository.findAll();
        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/chi-tiet-san-pham/store");
        return "/sanpham_chitiet/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") ChiTietSanPhamVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/sanpham_chitiet/create";
        }

        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.loadFromViewModel(vm);
        this.chiTietSpRepository.save(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSanPham chiTietSanPham, RedirectAttributes redirectAttributes) {
        try {
            this.chiTietSpRepository.delete(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa vì có liên kết khóa ngoại.");
            return "redirect:/chi-tiet-san-pham/index";

        }
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChiTietSanPham chiTietSanPham, Model model) {
        vm.loadFromDomainModel(chiTietSanPham);
        List<SanPham> listSp = this.sanPhamRepository.findAll();
        model.addAttribute("listSp", listSp);
        List<MauSac> listMs = this.mauSacRepository.findAll();
        model.addAttribute("listMs", listMs);
        List<Nsx> listNsx = this.nsxRepository.findAll();
        model.addAttribute("listNsx", listNsx);
        List<DongSp> listDongSp = this.dongSpRepository.findAll();
        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/chi-tiet-san-pham/update/" + chiTietSanPham.getId());
        return "/sanpham_chitiet/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChiTietSanPham oldValue,
            Model model,
            @Valid @ModelAttribute("data") ChiTietSanPhamVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {

            model.addAttribute("data", newValue);
            model.addAttribute("action", "/chi-tiet-san-pham/update/" + oldValue.getId());
            return "/sanpham_chitiet/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.chiTietSpRepository.save(oldValue);
        return "redirect:/chi-tiet-san-pham/index";
    }
}
