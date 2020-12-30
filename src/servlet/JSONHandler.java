package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/JSONHandler")
public class JSONHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JSONHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		int age = 0;
		if(request.getParameter("age") != null) {
			age = Integer.parseInt(request.getParameter("age"));
		}
		
		boolean isMarried = false;
		if(request.getParameter("isMarried") != null) {
			isMarried = Boolean.parseBoolean(request.getParameter("isMarried"));
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("name", name.charAt(0));
		obj.put("age", age);
		obj.put("isMarried", isMarried);
		
		request.setAttribute("obj", obj);
		
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
