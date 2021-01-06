package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.GilDao;
import dto.GilDto;

public class GilBBSInsertCommand implements GilCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter("page");
		if(page == null || page.isEmpty()) {
			page = "1";
		}
		String gil_writer = request.getParameter("gil_writer");
		String gil_title = request.getParameter("gil_title");
		String gil_content = request.getParameter("gil_content");
		String gil_pw = request.getParameter("gil_pw");
		
		GilDto gilDto = new GilDto();
		gilDto.setgil_writer(gil_writer);
		gilDto.setgil_title(gil_title);
		gilDto.setgil_content(gil_content);
		gilDto.setgil_pw(gil_pw);
		gilDto.setgil_ip(request.getRemoteAddr());
		
		int result = GilDao.getInstance().gilBBSInsert(gilDto);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		
		pathNRedirect.setPath("gilbbs/gilbbsinsertResultPage.jsp?page=" + page + "&result=" + result);
		pathNRedirect.setRedirect(true);
		
		
		return pathNRedirect;
	}

}
