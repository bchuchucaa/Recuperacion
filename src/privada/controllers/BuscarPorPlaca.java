package privada.controllers;

import java.io.IOException;
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
 * Servlet implementation class BuscarPorPlaca
 */
@WebServlet("/BuscarPorPlaca")
public class BuscarPorPlaca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPorPlaca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		String placa= request.getParameter("placa");
		Vehiculo ve1= new Vehiculo();
		ve1.setPlaca(placa);
		VehiculoDAO vdao =DAOFactory.getFactory().getVehiculoDAO();
		Vehiculo vehiculo= vdao.recuperarPorPlaca(ve1);
		
		Cliente cliente = vehiculo.getCliente();
		TicketDAO ticketdao= DAOFactory.getFactory().getTicketDAO();
		Ticket tik= new Ticket();
		tik.setVehiculo(vehiculo);
		List<Ticket> tickets= new ArrayList<Ticket>();
		tickets=ticketdao.recuperarTickets(tik);
		System.out.println(tickets.toString());
		
		try {
			request.setAttribute("cliente", cliente);
			request.setAttribute("vehiculo",vehiculo);
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
