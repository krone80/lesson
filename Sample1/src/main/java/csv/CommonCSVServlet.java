package csv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommonCSVServlet
 */
@WebServlet("/CommonCSVServlet")
public class CommonCSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommonCSVservlet");
		String filePath = "/csv";
		String realPath = this.getServletContext().getRealPath(filePath);
		String action =request.getParameter("action");
		System.out.println(action);
		if(action.equals("write")) {
			CommonWrite writer = new CommonWrite();
			writer.execute(realPath);
		} else if(action.equals("read")) {
			CommonRead reader = new CommonRead();
			reader.execute(realPath);
		}

		RequestDispatcher dis = request.getRequestDispatcher("/csv.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
