package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageVo;
import common.PathNRedirect;
import dao.GilDao;
import dto.GilDto;

public class GilBBSListCommand implements GilCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		
		PageVo pageVo = new PageVo();
		
		// 2. 전체 레코드 수
		int totalRecord = GilDao.getInstance().gilCountRecord();
		pageVo.setTotalRecord(totalRecord);
		
		// 3. 전체 페이지의 개수 구하기
		pageVo.setTotalPage();
		
		// 4. 현재 페이지 번호 구하기
		// 기본값 page = 1 (PageVo)
		String page = request.getParameter("page");
		if(page != null && !page.isEmpty()) {
			pageVo.setPage(Integer.parseInt(page));
		}
		
		// 5. 현재 페이지의 시작 게시물 번호와 종료 게시물 번호 구하기
		// 한 페이지 당 게시물은 3개 (recordPerPage)
		// page = 1인 경우 beginRecord = 1, endRecord = 3
		// page = 2인 경우 beginRecord = 4, endRecord = 6
		// page = 3인 경우 beginRecord = 7, endRecord = 9
		int beginRecord = pageVo.getPage() * pageVo.getRecordPerPage() - 2;
		pageVo.setBeginRecord(beginRecord);
		int endRecord = pageVo.getPage() * pageVo.getRecordPerPage();
		endRecord = endRecord < pageVo.getTotalRecord() ? endRecord : pageVo.getTotalRecord();
		pageVo.setEndRecord(endRecord);
		
		// 6. beginRecord ~ endRecord 사이의 목록만 가져오기
		List<GilDto> list = GilDao.getInstance().gilBBSList(pageVo);
		
		// 7. beginPage와 endPage 구하기
		// page=1~5인 경우 beginPage = 1, endPage = 5
		// page=6~10인 경우 beginPage = 6, endPage = 10
		// 실제로는
		// page=6~7인 경우 beginPage = 6, endPage = 7
		int beginPage = ( (pageVo.getPage() - 1) /  pageVo.getPagePerBlock() ) * pageVo.getPagePerBlock() + 1;
		pageVo.setBeginPage(beginPage);
		int endPage = beginPage + pageVo.getPagePerBlock() -1;
		endPage = endPage < pageVo.getTotalPage() ? endPage : pageVo.getTotalPage();
		pageVo.setEndPage(endPage);
		
		// 9. gilbbs/gilbbsListPage.jsp로 전달할 데이터 저장하기
		request.setAttribute("list", list);
		request.setAttribute("pageVo", pageVo);
		
		// 10. gilbbs/gilbbsListPage 로 이동
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		
		pathNRedirect.setPath("gilbbs/gilbbsListPage.jsp");
		pathNRedirect.setRedirect(false);
		return pathNRedirect;
	}

}
