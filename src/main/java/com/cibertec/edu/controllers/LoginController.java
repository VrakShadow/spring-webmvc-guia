package com.cibertec.edu.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginPage(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout
			, Model model, Authentication principal, RedirectAttributes flash){
		
		if(principal != null) {
			flash.addAttribute("info","ya ha iniciado sesion anteriormente");
			return "redirect:/home/index";
		}
		
		if(error != null) {
			model.addAttribute("error","Error en el login: Nombre de usuario o contraseña son incorrectos");
		}
		
		if(logout != null) {
			model.addAttribute("success", "Ha cerrado sesion correctamente");
		}
		
		return "login";
	}
}
