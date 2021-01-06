<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if('${param.result}' > 0){
		alert('게시글이 등록되었습니다.');
		location.href='/WebExer/GilBBSListPage.gil?page=${param.page}';
	}else{
		alert('게시글 등록이 실패하였습니다.');
		history.back();
	}
</script>