package csv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CSVServlet
 */
@WebServlet("/CSVServlet")
public class CSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CSVservlet");
		String dirPath = "/csv";
		System.out.println(dirPath);
		String dirRealPath = this.getServletContext().getRealPath(dirPath);
		System.out.println(dirRealPath);
		String action =request.getParameter("action");
		System.out.println(action);
		if(action.equals("write")) {
			Write writer = new Write();
			writer.execute(dirRealPath);
		} else if(action.equals("read")) {
			Read reader = new Read();
			reader.execute(dirRealPath);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
