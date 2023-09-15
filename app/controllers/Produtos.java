package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.Produto;
import models.Loja;

public class Produtos extends Controller {

	public static void form() {

		List<Loja> listaLojas = Loja.findAll();
		render(listaLojas);
	}

	public static void listar() {
		String busca = params.get("busca");
		List<Produto> listaP;

		if (busca == null) {
			listaP = Produto.findAll();
		} else {
			listaP = Produto.find("nome like ?1 order by valor", "%" + busca + "%").fetch();
		}

		render(listaP);
	}

	public static void salvar(Produto p, Long idLoja) {

		if (idLoja != null) {
			Loja loja = Loja.findById(idLoja);
			loja.listaProdutos.add(p);
		}
		p.save();
		listar();
	}

	public static void deletar(Long id) {
		Produto p = Produto.findById(id);

		p.delete();

		listar();
	}

	public static void editar(Long id) {
		Produto p = Produto.findById(id);

		renderTemplate("Produtos/form.html", p);

	}
}