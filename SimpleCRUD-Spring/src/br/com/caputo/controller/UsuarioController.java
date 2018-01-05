package br.com.caputo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.faces.action.RequestMapping;

import br.com.caputo.dao.UsuarioDAO;
import br.com.caputo.entities.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@RequestMapping("/userForm")
	public ModelAndView exibirFormulario() {
		//Original:
		//return new ModelAndView("empform","command",new Emp());  
		return new ModelAndView("userForm","comando",new Usuario());  
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserirUsuario(@ModelAttribute("user")Usuario usuario) {
		usuarioDAO.inserir(usuario);  
	     return new ModelAndView("redirect:/viewUsuario");  
	}
	
	@RequestMapping(value="/editemp/{id}")  
    public ModelAndView buscar(@PathVariable int id){  
        Usuario usuario = usuarioDAO.findById(id); 
        return new ModelAndView("userFormPopulado","comando",usuario);  
    } 
	
}
