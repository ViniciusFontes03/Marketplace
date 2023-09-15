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
		System.out.println(id);
		Produto p = Produto.findById(id);
		if( p != null) {
			p.delete();
			
			flash.success("A pessoa foi removida com sucesso.");
		}else {
			
		}
		
		listar();
	}
	public static void editar(Long id) {
		Loja loja = Loja.findById(id);	
		
		renderTemplate("Loja/form.html", loja);
	}
}