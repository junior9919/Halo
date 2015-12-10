<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有文章</title>
</head>
<body>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.Map"%>
	<%
		List<Map<String, String>> articleList = (List<Map<String, String>>) request.getAttribute("articles");
	%>
	<%
		long articlesCount = Long.parseLong(request.getAttribute("articlesCount").toString());
	%>
	<%
		int previousRow = Integer.parseInt(request.getAttribute("previousRow").toString());
	%>
	<%
		int nextRow = Integer.parseInt(request.getAttribute("nextRow").toString());
	%>
	<table>
		<%
			for (int i = 0; i < articleList.size(); i++) {
		%>
		<tr>
			<td colspan="2"><a
				href=<%out.print(articleList.get(i).get("url"));%>> <%
 	out.print(articleList.get(i).get("title"));
 %>
			</a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td>
				<%
					if (previousRow >= 0) {
				%> <a
				href=<%out.print("searchArticles.do?firstRow=" + previousRow);%>>上一页</a>
				<%
					} else {
				%> 上一页 <%
					}
				%>
			</td>
			<td>
				<%
					if (nextRow >= 0 && nextRow <= articlesCount) {
				%> <a href=<%out.print("searchArticles.do?firstRow=" + nextRow);%>>下一页</a>
				<%
					} else {
				%> 下一页 <%
					}
				%>
			</td>
		</tr>
	</table>
</body>
</html>