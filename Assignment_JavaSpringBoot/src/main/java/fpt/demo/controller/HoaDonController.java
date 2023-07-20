package fpt.demo.controller;

import fpt.demo.entity.GioHang;
import fpt.demo.entity.HoaDon;
import fpt.demo.repositories.GioHangRepository;
import fpt.demo.repositories.HoaDonRepository;
import fpt.demo.request.GioHangVM;
import fpt.demo.request.HoaDonVM;
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
@RequestMapping("/hoa-don")
public class HoaDonController {

        @Autowired
        private HoaDonRepository hoaDonRepository;

        @Autowired
        @Qualifier("hoadon_vm")
        private HoaDonVM vm;
        private List<HoaDon> list = new ArrayList<>();

        @GetMapping("index")
        public String getIndex(Model model, @ModelAttribute("error") String error) {
            list = this.hoaDonRepository.findAll();
            model.addAttribute("list", list);
            model.addAttribute("error", error);
            return "/hoadon/index";

        }


        @GetMapping("create")

        public String createKH(Model model) {
            model.addAttribute("data", vm);
            model.addAttribute("action", "/hoa-don/store");
            return "/hoadon/create";
        }


        @PostMapping("store")
        public String store(
                @Valid @ModelAttribute("data") HoaDonVM vm,
                BindingResult result
        ) {
            if (result.hasErrors()) {
                return "/hoadon/create";
            }

            HoaDon hoaDon = new HoaDon();
            hoaDon.loadFromViewModel(vm);
            this.hoaDonRepository.save(hoaDon);
            return "redirect:/hoa-don/index";
        }

        @GetMapping("delete/{id}")
        public String delete(@PathVariable("id") HoaDon hoaDon, RedirectAttributes redirectAttributes) {
            try {
                this.hoaDonRepository.delete(hoaDon);
                return "redirect:/hoa-don/index";
            } catch (Exception e) {
                redirectAttributes.addAttribute("error", "Không thể xóa hoá đơn vì có liên kết khóa ngoại.");
                return "redirect:/hoa-don/index";

            }
        }


        @GetMapping("edit/{id}")
        public String edit(@PathVariable("id") HoaDon hoaDon, Model model) {
            vm.loadFromDomainModel(hoaDon);
            model.addAttribute("data", vm);
            model.addAttribute("action", "/hoa-don/update/" + hoaDon.getId());
            return "/hoadon/create";
        }

        @PostMapping("update/{id}")
        public String update(
                @PathVariable("id") HoaDon oldValue,
                Model model,
                @Valid @ModelAttribute("data") HoaDonVM newValue,
                BindingResult result
        ) {
            if (result.hasErrors()) {
                model.addAttribute("data", newValue);
                model.addAttribute("action", "/hoa-don/update/" + oldValue.getId());
                return "/hoadon/create";
            }

            oldValue.loadFromViewModel(newValue);
            this.hoaDonRepository.save(oldValue);
            return "redirect:/hoa-don/index";
        }
    }


