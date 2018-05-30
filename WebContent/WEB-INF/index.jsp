<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% ResultSet rs = (ResultSet) request.getAttribute("rs");%>

<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="header.jsp" />
		<title>index</title>
	</head>
	<body style="background-color: #f9f8f8;">

		<%-- bar部分のinclude --%>
		<jsp:include page="bar.jsp" />

		<div class="container-fluid">

			<%-- error文のinclude --%>
			<jsp:include page="error.jsp" />

			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<table class="table">
						<tr>
							<th>#</th>
							<th>題名</th>
							<th>重要度</th>
							<th>期限</th>
						</tr>
<%
	while(rs.next()){
%>
						<tr>
							<td>1</td>
							<td><a href="update.html?id=<%= rs.getInt("id") %>"><%= rs.getString("title") %></a></td>
							<td>
								<%
									for(int i = 1; i <= rs.getInt("importance"); i++){
								%>
									★
								<%
									}
								%>
							</td>
							<td>
								<%
									if(rs.getDate("limit_date") != null){
								%>
								<%= rs.getDate("limit_date") %>
								<%
									}else{}
								%>
							</td>
						</tr>
<%
	}
%>
					</table>
				</div>
			</div><!-- row -->
			<div class="row">
				<div class="col-sm-offset-1 col-sm-2">
					<a href="entry.html" type="button" class="btn btn-primary">追加</a>
				</div>
			</div>
		</div><!-- container -->

		<jsp:include page="footer.jsp" />
	</body>
</html>
