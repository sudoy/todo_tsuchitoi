<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	request.setCharacterEncoding("utf-8"); %>
<%@ page import="todo.utils.HTMLUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<jsp:include page="header.jsp" />
		<title>entry</title>
	</head>
	<body style="background-color: #f9f8f8;">

		<jsp:include page="bar.jsp" />

		<div class="container-fluid">

			<jsp:include page="error.jsp" />

			<div class="row">
				<div class="col-sm-offset-1 col-sm-10" style="border-bottom: solid 1px #80808075; margin-bottom: 13px;">
					<strong>登録フォーム</strong>
				</div>
			</div><!-- row -->
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<form class="form-horizontal" action="entry.html" method="post">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">題名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title" placeholder="題名" value="${ef.title}">
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="detail" class="col-sm-2 control-label">詳細</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="detail" name="detail" rows="3" placeholder="詳細">${ef.detail}</textarea>
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">重要度</label>
							<div class="col-sm-10">
								<div class="radio">
									<label>
										<input type="radio" name="importance" id="importance3" value="3" ${ef.importance == 3 || ef.importance == null ? "checked" : ""}>★★★
									</label><br>
									<label>
										<input type="radio" name="importance" id="importance2" value="2" ${ef.importance == 2 ? "checked" : ""}>★★
									</label><br>
									<label>
										<input type="radio" name="importance" id="importance1" value="1" ${ef.importance == 1 ? "checked" : ""}>★
									</label>
								</div>
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="limit" class="col-sm-2 control-label">期限</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="limit_date" name="limit_date" placeholder="期限" value="${ef.limitDate}">
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<a href="index.html" class="btn btn-default">キャンセル</a>
								<button type="submit" name="add" class="btn btn-primary">追 加</button>
							</div>
						</div><!-- form-group -->
					</form>
				</div>
			</div><!-- row -->
		</div><!-- container -->

		<jsp:include page="footer.jsp" />

	</body>
</html>
