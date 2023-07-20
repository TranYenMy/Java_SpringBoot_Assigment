package fpt.demo.controller;

import fpt.demo.entity.ChucVu;
import fpt.demo.entity.CuaHang;
import fpt.demo.entity.GioHang;
import fpt.demo.repositories.ChucVuRepository;
import fpt.demo.repositories.CuaHangRepository;
import fpt.demo.request.ChucVuVM;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    @Qualifier("chucvu_vm")
    private ChucVuVM vm;
    private List<ChucVu> list = new ArrayList<>();

    @GetMapping("index")
    public String getIndex(Model model , @ModelAttribute("error") String error) {
        list = this.chucVuRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("error", error);
        return "/chucvu/index";

    }


    @GetMapping("create")

    public String createKH(Model model) {
        model.addAttribute("data", vm);
        model.addAttribute("action", "/chuc-vu/store");
        return "/chucvu/create";
    }


    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") ChucVuVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/chucvu/create";
        }

        ChucVu cv = new ChucVu();
        cv.loadFromViewModel(vm);
        this.chucVuRepository.save(cv);
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu chucVu, RedirectAttributes redirectAttributes) {
        try {
            this.chucVuRepository.delete(chucVu);
            return "redirect:/chuc-vu/index";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Không thể xóa chức vụ vì có liên kết khóa ngoại.");
            return "redirect:/chuc-vu/index";

        }
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu, Model model) {
        vm.loadFromDomainModel(chucVu);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/chuc-vu/update/" + chucVu.getId());
        return "/chucvu/create";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChucVu oldValue,
            Model model,
            @Valid @ModelAttribute("data") ChucVuVM newValue,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/chuc-vu/update/" + oldValue.getId());
            return "/chucvu/create";
        }

        oldValue.loadFromViewModel(newValue);
        this.chucVuRepository.save(oldValue);
        return "redirect:/chuc-vu/index";
    }
}
