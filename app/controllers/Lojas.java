package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.Loja;
import models.Produto;

public class Lojas extends Controller {

	public static void home() {
		render();
	}

	public static void form() {
		render();
	}

	public static void listar() {
		List<Loja> listaLoj = Loja.findAll();
		render(listaLoj);
	}

	public static void salvar(Loja loj, Long id) {
		loj.save();
		home();
	}
	public static void deletar(Long id) {
		Loja loja = Loja.findById(id);
		if(loja != null) {
			loja.delete();
			
			flash.success("A pessoa foi removida com sucesso.");
		}
		
		listar();
	}
	public static void editar(Long id) {
		Loja loj = Loja.findById(id);	
		
		renderTemplate("Lojas/form.html", loj);
	}
}