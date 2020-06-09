package privada.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.Timestamp;

import privada.dao.ClienteDAO;
import privada.dao.DAOFactory;
import privada.dao.TicketDAO;
import privada.dao.VehiculoDAO;
import privada.entidad.Cliente;
import privada.entidad.Ticket;
import privada.entidad.Vehiculo;

/**
 * Servlet implementation class ServletTicket
 */
@WebServlet("/ServletTicket")
public class ServletTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fechaingreso= request.getParameter("fechaingreso");
		String fechasalida= request.getParameter("fechasalida");
		String placa= request.getParameter("placa");
		String marca = request.getParameter("marca");
		String modelo= request.getParameter("modelo");
		String cedula= request.getParameter("cedula");
		ClienteDAO clienteDAO = DAOFactory.getFactory().getClienteDAO();
		Cliente cliente=clienteDAO.buscarPorId(cedula);
		System.out.println(cliente.toString());
		Ticket ticket = new Ticket(0,fechaingreso,fechasalida,null);
		VehiculoDAO vehiculoDAO=DAOFactory.getFactory().getVehiculoDAO();
		Vehiculo vprueba= new Vehiculo();
		vprueba.setPlaca(placa);
		try {
		vprueba=vehiculoDAO.recuperarPorPlaca(vprueba);
		List<Ticket> tickets= vprueba.getTickets();
		tickets.add(ticket);
		ticket.setVehiculo(vprueba);
		vehiculoDAO.update(vprueba);
		}catch (Exception e) {
			// TODO: handle exception
			Vehiculo vnuevo= new Vehiculo(placa,marca,modelo,cliente,null);
			List<Ticket> tickets= new ArrayList<Ticket>();
			ticket.setVehiculo(vnuevo);
			tickets.add(ticket);
			vnuevo.setTickets(tickets);
			vehiculoDAO.create(vnuevo);
		}
		response.sendRedirect("/Recuperacion/JSPs/buscar.jsp");
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
