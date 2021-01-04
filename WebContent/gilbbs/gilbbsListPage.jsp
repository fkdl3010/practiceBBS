<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
				<td>아이피주소</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list }">
				<tr>
					<td>게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list }">
				<c:forEach var="gilDto" items="${list }" varStatus="k">
					<tr>
						<td>${pageVo.totalRecord - ((pageVo.page - 1) * pageVo.recordPerPage + k.index)}</td>
						<td>${gilDto.gil_writer }</td>
						<td><a href="/WebExer/gilListView.gil?gil_no">${gilDto.gil_title }</a></td>
						<td>${gilDto.gil_content }</td>
						<td>${gilDto.gil_ip }</td>
						<td>${gilDto.gil_date }</td>
						<td>${gilDto.gil_hit }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
					<c:if test="${pageVo.beginPage <= pageVo.pagePerBlock }">
						이전&nbsp;
					</c:if>
					<c:if test="${pageVo.beginPage > pageVo.pagePerBlock }">
						<a href="/WebExer/GilBBSListPage.gil?page=${pageVo.beginPage -1 }">이전</a>
					</c:if>
					<c:forEach var="page" begin="${pageVo.beginPage }" end="${pageVo.endPage }" step="1" >
						<c:if test="${page eq pageVo.page}">
							${page }
						</c:if>
						<c:if test="${page ne pageVo.page }">
							<a href="/WebExer/GilBBSListPage.gil?page=${page }">${page }</a>
						</c:if>
					</c:forEach>
					
					<c:if test="${pageVo.endPage >= pageVo.totalPage }">
						다음
					</c:if>
					
					<c:if test="${pageVo.endPage < pageVo.totalPage }">
						<a href="/WebExer/GilBBSListPage.gil?page=${pageVo.endPage + 1 }">다음</a>
					</c:if>
				</td>
			</tr>
		</tfoot>
	</table>
	
	<form>
		<input type="button" value="게시글 작성하기" onclick="/WebExer/GilBBSInsertPage.gil" />
		
		<!-- hidden -->
		<input type="hidden" name="page" value="${page }" />
		
	</form>
</body>
</html>