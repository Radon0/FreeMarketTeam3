<%@page contentType="text/html; charset=UTF-8"%>

<%
//ArrayList<Mail> mailList = (ArrayList<Mail>) request.getAttribute("mailList");
%>

<html>
<head>
<title>メッセージ画面</title>
<link rel="stylesheet"  href="../css/style.css">
</head>
<body>
	<h1 style="text-align: center">メッセージ画面</h1>
	<div class="message">
		<p style="float: right"><a href="">詳細に戻る</a></p>
		<br>
		<br>
		<div class="messageBox">
			<ul>
			<% 
				//if(){
			%>
				<li class="me">
					<p class="text">他の写真も見せていただけますか</p>
					<div class="status">既読<br>17:00</div>
				</li>
			<%// } else { %>
				<li class="you">
					<p class="text">もちろんいいですよ</p>
					<div class="status">17:00</div>
				</li>
			<%// } %>
			</ul>
		</div>
		<form style="text-align: center" action="<%= request.getContextPath() %>/message" method="get">
				<input type="text" size="30" name="message"> 
				<input type="hidden" name="cmd" value="send">
				<input type="button" value="送信">
		</form>
	</div>
</body>
</html>