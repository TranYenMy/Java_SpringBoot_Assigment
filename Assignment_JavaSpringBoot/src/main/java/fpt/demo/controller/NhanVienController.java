package fpt.demo.controller;

import fpt.demo.entity.ChucVu;
import fpt.demo.entity.CuaHang;
import fpt.demo.entity.DongSp;
import fpt.demo.entity.NhanVien;
import fpt.demo.repositories.ChucVuRepository;
import fpt.demo.repositories.CuaHangRepository;
import fpt.demo.repositories.NhanVienRepository;
import fpt.demo.request.NhanVienVM;
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
import java.util.UUID;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {


    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    @Qualifier("nv_vm")
    private NhanVienVM vm;
    private List<NhanVien> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model , @ModelAttribute("error") String error) {
        list = this.nhanVienRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/nhanvien/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        List<CuaHang> listCh = this.cuaHangRepository.findAll();
        model.addAttribute("listCh", listCh);
        List<ChucVu> listCv = this.chucVuRepository.findAll();
        model.addAttribute("listCv", listCv);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/nhan-vien/store");
        return "/nhanvien/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") NhanVienVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/nhanvien/create";
        }
        CuaHang cuaHang = cuaHangRepository.findById(UUID.randomUUID()).orElse(null);
        NhanVien nv = new NhanVien();
        nv.loadFromViewModel(vm);
        this.nhanVienRepository.save(nv);
        return "redirect:/nhan-vien/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien, RedirectAttributes redirectAttributes) {
        try {
            this.nhanVienRepository.delete(nhanVien);
            return "redirect:/nhan-vien/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa nhân viên vì có liên kết khóa ngoại.");
            return "redirect:/nhan-vien/index";

        }
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVien, Model model) {
        vm.loadFromDomainModel(nhanVien);
        model.addAttribute("data", vm);
        List<CuaHang> listCh = this.cuaHangRepository.findAll();
        model.addAttribute("listCh", listCh);
        List<ChucVu> listCv = this.chucVuRepository.findAll();
        model.addAttribute("listCv", listCv);
        model.addAttribute("action", "/nhan-vien/update/" + nhanVien.getId());
        return "/nhanvien/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") NhanVien oldValue,
            Model model,
            @Valid @ModelAttribute("data") NhanVienVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {

            model.addAttribute("data", newValue);
            model.addAttribute("action", "/nhan-vien/update/" + oldValue.getId());
            return "/nhanvien/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.nhanVienRepository.save(oldValue);
        return "redirect:/nhan-vien/index";
    }


}
