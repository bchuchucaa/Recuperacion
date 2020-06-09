package privada.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import privada.dao.ClienteDAO;
import privada.dao.DAOFactory;

import privada.dao.TicketDAO;

import privada.dao.VehiculoDAO;
import privada.entidad.Cliente;

import privada.entidad.Ticket;

import privada.entidad.Vehiculo;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		String cedula= request.getParameter("cedula");
		ClienteDAO clienteDAO = DAOFactory.getFactory().getClienteDAO();
		Cliente cliente=clienteDAO.buscarPorId(cedula);
		System.out.println(cliente.toString());
		VehiculoDAO vdao =DAOFactory.getFactory().getVehiculoDAO();
		Vehiculo vehiculo= new Vehiculo();
		vehiculo.setCliente(cliente);
		TicketDAO tiketdao= DAOFactory.getFactory().getTicketDAO();
		List<Ticket>tickets= new ArrayList<Ticket>();
	
		
		for (Vehiculo v :vdao.recuperarVehiculos(vehiculo)) {
			Ticket ticket = new Ticket();
			ticket.setVehiculo(v);
			List<Ticket>ticketsre= new ArrayList<Ticket>();
			ticketsre=tiketdao.recuperarTickets(ticket);
			
			for (Ticket ticket2 : ticketsre) {
				tickets.add(ticket2);
			}
			
		}

		try {
			request.setAttribute("cliente", cliente);
			request.setAttribute("tickets", tickets);
			url="/JSPs/buscar.jsp";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("algo salio mal");
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
