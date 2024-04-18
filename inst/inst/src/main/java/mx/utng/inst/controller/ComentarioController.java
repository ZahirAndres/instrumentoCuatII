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
import mx.utng.inst.model.entity.Comentario;
import mx.utng.inst.model.service.IComentarioService;

@Controller
@SessionAttributes("comentario")
public class ComentarioController {
    @Autowired 
    private IComentarioService service;

    @GetMapping({"comentario", "/comentario", "/comentario/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de comentarios");
        model.addAttribute("comentarios", service.list());
        return "comentario-list";
    }

    @GetMapping("/comentario/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de comentarios");
        model.addAttribute("comentario", new Comentario());
        return "comentario-form";
    }

    @PostMapping("/comentario/form")
    public String save(@Valid Comentario comentario, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de comentarios");
            return "comentario-form";
        }
        service.save(comentario);
        return "redirect:/comentario/list";
    }

    @GetMapping("/comentario/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Comentario comentario = null;
        if(id > 0){
            comentario=service.getByID(id);
        }else{
            return "redirect:/comentario/list";
        }
        model.addAttribute("title", "Editar comentarios");
        model.addAttribute("comentario", comentario);
        return "comentario-form";
    }
    @GetMapping("/comentario/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/comentario/list";
    }

}
