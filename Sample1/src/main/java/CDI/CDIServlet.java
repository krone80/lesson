package CDI;

import java.io.IOException;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CDIServlet
 */
//
@WebServlet("/CDIServlet")
@Dependent
public class CDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//スコープにセットしたいBeanをinject
	@Inject
	public MyInfo myInfo;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("入力値" + request.getParameter("myName"));
		/*
		 * setterの使用は可、newするのは不可。
		 */
//		myInfo.setMyName(request.getParameter("myName"));
//		myInfo = new MyInfo(request.getParameter("myName"), "A");
		myInfo.setMyInfo(request.getParameter("myName"), "A");

		RequestDispatcher dis = request.getRequestDispatcher("/CDI.jsp");
		dis.forward(request, response);

	}

}
