<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="./css/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="./css/main.css">
        
        <title>Hub</title>
    </head>
    <body>
    
        <div class="modal">
            <div class="personal-modify">
                <input type="text" class="keyword-form" /><div class="add-button">추가</div>
                <span class="personal-modify-close">X</span>
                <ul class="keyword-list">
                	<c:forEach var="keyword" items="${keywords }">
                    	<li class="keyword">${keyword.word }<span class="keyword-delete-button">x</span></li>
                    </c:forEach>
                </ul>
                <div class="ok-button">확인</div>
            </div>
        </div>
    
        <header>
            <span id="title"><a href="#">Hub</a></span>
            <span class="personal-modify-button">정보 수정</span>
            <span><a href="${pageContext.request.contextPath }/auth/logout.do">logout</a></span>            
        </header>
        <div class="board-container">
        	<c:forEach var="keyword" items="${keywords }">
            <div class="board-card">
                <h1 class="keyword-name">${keyword.word }</h1>
                <table class="post-list">
                    <thead>
                        <tr>
                            <th>게시글</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="article" items="${articles }">
                    		<c:if test="${keyword.no == article.keywordNo }" >
	                        <tr>
	                            <td><a href="${article.url }">${article.title }</a></td>
	                            <td>${article.postTime }</td>
	                        </tr>
	                        </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            </c:forEach>
        </div>
        <footer>
            <h1 class="footer-title">Hub</h1>
        </footer>
        
        <script type="text/javascript" src="./js/lib/jquery-2.2.4.js"></script>
        <script type="text/javascript" src="./js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="./js/main.js"></script>
        
    </body>
</html>