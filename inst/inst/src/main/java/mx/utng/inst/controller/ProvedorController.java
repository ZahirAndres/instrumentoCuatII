package mx.utng.inst.controller;


/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.inst.model.entity.Provedor;
import mx.utng.inst.model.service.IProvedorService;

@Controller
@SessionAttributes("provedor")
public class ProvedorController {
    @Autowired      
    private IProvedorService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de provedor");
        model.addAttribute("provedors", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de provedor");
        model.addAttribute("provedor", new Provedor());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Provedor provedor, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de provedor");
            return "form";
        }

        service.save(provedor);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Provedor provedor = null;
        if(id > 0){
            provedor=service.getByID(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar provedor");
        model.addAttribute("provedor", provedor);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/list";
    }

}
