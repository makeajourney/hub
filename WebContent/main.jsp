<%@ page import="hub.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="../css/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        
        <title>Hub</title>
    </head>
    <body>
    
        <div class="modal">
            <div class="personal-modify">
                <input type="text" class="keyword-form" />
                <span class="personal-modify-close">X</span>
                <ul class="keyword-list">
                    <li class="keyword">keyword1</li>
                    <li class="keyword">keyword2</li>
                    <li class="keyword">keyword3</li>
                    <li class="keyword">keyword4</li>
                </ul>
                <div class="ok-button">확인</div>
            </div>
        </div>
    
        <header>
            ${user.id}
            <span id="personal-modify-button">정보 수정</span>
            <span>로그 아웃</span>            
        </header>
        <div class="board-container">
            <div class="board-card">
                <h1 class="keyword-name">키워드</h1>
                <table class="post-list">
                    <thead>
                        <tr>
                            <th>게시글</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>뭘까요 ~1</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~2</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~3</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~4</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~5</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~6</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~7</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~8</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~9</td>
                            <td>HH:MM:SS</td>
                        </tr>
                        <tr>
                            <td>뭘까요 ~10</td>
                            <td>HH:MM:SS</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <footer></footer>
        
        <script type="text/javascript" src="../js/lib/jquery-2.2.4.js"></script>
        <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
        
    </body>
</html>