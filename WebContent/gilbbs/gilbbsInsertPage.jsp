<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_bbsInsert(f){
		if(f.gil_writer == '' || f.gil_title == '' || f.gil_pw == ''){
			alert('필수 입력사항입니다.');
			return;
		}
		
		f.action='/WebExer/GilBBSInsert.gil';
		f.submit();
		
	}
</script>
</head>
<body>
	
	<form method="post">
		작성자<br>
		<input type="text" name="gil_writer" /><br>
		
		제목<br>
		<input type="text" name="gil_title" /><br>
		
		내용<br>
		<textarea rows="3" cols="30" name="gil_content"></textarea><br>
		
		비밀번호<br>
		<input type="password" name="gil_pw" /><br>
		
		<input type="button" value="작성하기" onclick="fn_bbsInsert(this.form)"/>
		<input type="button" value="목록으로 돌아가기" onclick="location.href='/WebExer/GilBBSListPage.gil?page=${param.page}'"/>
		<input type="reset" value="다시작성하기"/>
		
		
	</form>
</body>
</html>