package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;

public class GilBBSInsertCommand implements GilCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {

		String gil_writer = request.getParameter("gil_writer");
		String gil_title = request.getParameter("gil_title");
		String gil_content = request.getParameter("gli_content");
		
		
		
		return null;
	}

}
