package controlador;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import modelo.Contador;

/**
 * Servlet implementation class control
 */
@WebServlet("/contadores")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HttpServlet = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public control() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
///obtener la sesion//

		HttpSession miSesion = request.getSession(); //
		ServletContext contexto = this.getServletContext();
		Contador contaContexto = (Contador) contexto.getAttribute("contadorContexto");
		Contador contaSesion = (Contador) miSesion.getAttribute("contadorSesion");

		if (contaSesion == null) {
			System.out.println("Creando variable de sesion..");
			contaSesion = new Contador();
			miSesion.setAttribute("contadorSesion", contaSesion);
		}
		if (contaContexto == null) {
			System.out.println("Creando variable de contexto..");
			contaContexto = new Contador();
			contexto.setAttribute("contadorContexto", contaContexto);
		}
		contaSesion.inc();
		contaContexto.inc();
		response.getWriter().append("Contador sesion : " + contaSesion.getContador());
		response.getWriter().append("Contador contexto  : " + contaContexto.getContador());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
