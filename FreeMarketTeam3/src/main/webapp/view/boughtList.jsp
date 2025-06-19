<%@page contentType="text/html; charset=UTF-8"%>
<%@page import ="bean.BuytInfo"%>
<%@page import ="bean.Goods"%>
<%@page import ="java.util.ArrayList"%>
<%
ArrayList<BuyInfo> buyList = (ArrayList<BuyInfo>)request.getAttribute("buyList");
ArrayList<Goods> goodsList = (ArrayList<Goods>)request.getAttribute("goodsList");
%>


<html>
	<head>
		<title>購入履歴</title>
	</head>
	<body>
	<div style ="text-align:center;margin-bottom:300">
	<hr style="text-align:center; height:2px; background-color:black; width:950px">
<h2>購入履歴</h2>
		<table style="text-align:center;margin:auto;width:800px;margin-bottom:100">
		<tr>
				<th style="background-color:#6495ed">購入品画像</th>
				<th style="background-color:#6495ed">商品名</th>
				<th style="background-color:#6495ed">金額</th>
			</tr>
		<%
				if( != null){
			for(int i = 0;i<buyList.size();i++){
				Goods goods = goodsList.get(i);
			%>
			
			<tr>
				<td style="text-align:center; width:100px"><%= goods.getImage() %></td>
				<td style="text-align:center; width:100px"><%= goods.getProductName() %></td>
				<td style="text-align:center; width:100px"><%= goods.getPrice() %></td>
				<td><form action =""method ="get">
				<select name = "nyukin">
				<option value = "0">未入金</option>
				<option value = "1">入金済</option>
				</select></form></td>
				
			</tr>
		
		
		</table>
		<hr style="text-align:center; height:2px; background-color:black; width:950px">
		<td style="text-align:center; width:100px">[<a href="<%=request.getContextPath() %>/mypage">マイページ</a>]</td>
		<td style="text-align:center; width:100px">[<a href="<%=request.getContextPath() %>/listGoods">商品一覧</a>]</td>
	</body>
</html>