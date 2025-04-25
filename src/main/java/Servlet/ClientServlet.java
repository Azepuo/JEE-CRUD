package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import Dao.ClientDAO;
import Model.Client;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO dao;
	@Override
    public void init() {
        dao = new ClientDAO();
    }
    public ClientServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
        try {
            if ("new".equals(action)) {
                req.getRequestDispatcher("client-form.jsp").forward(req, resp);
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Client existing = dao.trouverClient(id);
                req.setAttribute("client", existing);
                req.getRequestDispatcher("client-form.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                dao.supprimerClient(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("clients");
            }else if("search".equals(action)) {
                String motCle = req.getParameter("query");
                List<Client> list = dao.rechercherClients(motCle);
                req.setAttribute("listeClients", list);
                req.setAttribute("query", motCle);
                req.getRequestDispatcher("list-clients.jsp").forward(req, resp);}
            else {
                List<Client> list = dao.listerClients();
                req.setAttribute("listeClients", list);
                req.getRequestDispatcher("list-clients.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
	            String idStr = req.getParameter("id");
	            Client cl = new Client(
	                req.getParameter("nom"),
	                req.getParameter("email"),
	                req.getParameter("telephone")
	            );
	            if (idStr == null || idStr.isEmpty()) {
	                dao.ajouterClient(cl);
	            } else {
	                cl.setId(Integer.parseInt(idStr));
	                dao.modifierClient(cl);
	            }
	            resp.sendRedirect("clients");
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	    } 

}
