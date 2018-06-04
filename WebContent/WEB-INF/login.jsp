<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
	<title>login</title>
</head>
<body style="background-color: #f9f8f8;">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-sm-offset-1">
				<a href="index.html"><h1 class="col-sm-4"><small>Todoリスト</small></h1></a>
			</div>
		</div>
	</div><!-- /container -->
	<div class="container">
		<div class="panel panel-default box row col-sm-offset-3 col-sm-6" style="margin-top: 75px;">
			<div class="panel-body">
				<div class="row">
					<div class="text-left col-sm-5"><h4 style="margin-bottom: 40px;">ログイン</h4></div>
				</div>
				<jsp:include page="error.jsp" />
				<form class="form-horizontal" action="login.html" method="post">
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">メールアドレス</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email" id="email" placeholder="メールアドレス" value="${param.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-4 control-label">パスワード</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password" id="password" placeholder="パスワード">
						</div>
					</div>
					<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> ログイン</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>