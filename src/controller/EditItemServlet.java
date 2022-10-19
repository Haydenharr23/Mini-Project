package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Player itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setPosition(position);
		itemToUpdate.setName(name);
				
		dao.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);


	}

}
