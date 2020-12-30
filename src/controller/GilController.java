package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.GilCommand;
import common.PathNRedirect;

@WebServlet("*.gil")
public class GilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GilController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String context = request.getContextPath();
		String cmd = requestURI.substring(context.length());
		
		PathNRedirect pathNRedirect = null;
		GilCommand command = null;
		
		switch(cmd) {
		
		// 커맨드
		case "/GilBBSListPage.gil":
			
			break;
		
		// 이동
		}
		
		if(pathNRedirect.isRedirect()) {
			response.sendRedirect(pathNRedirect.getPath());
		}else {
			request.getRequestDispatcher(pathNRedirect.getPath()).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
