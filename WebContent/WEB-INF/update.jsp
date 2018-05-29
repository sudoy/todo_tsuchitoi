<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>

		<jsp:include page="header.jsp" />

		<title>update</title>
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
					<form class="form-horizontal" action="update.html" method="post">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">題名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title" placeholder="題名" value="テストテスト">
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="detail" class="col-sm-2 control-label">詳細</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="detail" name="detail" rows="3" placeholder="詳細">SQLの確認テストの採点と報告書を作成する。</textarea>
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">重要度</label>
							<div class="col-sm-10">
								<div class="radio">
									<label>
										<input type="radio" name="primary" id="primary3" value="primary3" checked>★★★
									</label><br>
									<label>
										<input type="radio" name="primary" id="primary2" value="primary2">★★
									</label><br>
									<label>
										<input type="radio" name="primary" id="primary1" value="primary1">★
									</label>
								</div>
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="limit" class="col-sm-2 control-label">期限</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="limit" name="limit" placeholder="期限" value="2015/06/15">
							</div>
						</div><!-- form-group -->
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<a href="index.html" class="btn btn-default">キャンセル</a>
								<input type="submit" name="update" class="btn btn-primary" value="更 新">
								<input type="submit" name="delete" class="btn btn-danger pull-right" value="削 除">
							</div>
						</div><!-- form-group -->
					</form>
				</div>
			</div><!-- row -->
		</div>


		<jsp:include page="footer.jsp" />
	</body>
</html>
