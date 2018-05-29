<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<tr>
							<td>1</td>
							<td><a href="update.html">テストテキスト</a></td>
							<td>★★★</td>
							<td>2015/06/20</td>
						</tr>
						<tr>
							<td>2</td>
							<td><a href="update.html">テストテキスト</a></td>
							<td>★</td>
							<td>2015/06/20</td>
						</tr>
						<tr>
							<td>3</td>
							<td><a href="update.html">テストテキスト</a></td>
							<td>★★★</td>
							<td>2015/06/20</td>
						</tr>
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
