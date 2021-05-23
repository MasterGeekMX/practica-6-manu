package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

/**
 * @author Luis Manuel Arrieta Ávila
 *
 */
@Controller
@Slf4j
public class ListarUsuariosController {

	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
	public String getListarUsuarios(Model model) {
		log.info("Iniciando la Historia de Usuario: listar usuarios");
		try {
			List<Usuario> usuarios = servicioUsuario.recuperaUsuarios();
			model.addAttribute("usuarios", usuarios);
			return "vistaListarUsuarios/ListarUsuarios.html";
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "vistaListarUsuarios/ListarUsuariosError.html";
		}
	}
	
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.POST)
	public String postListarUsuarios(Model model) {
		return "vistaPrincipal/Principal.html";
	}

}
