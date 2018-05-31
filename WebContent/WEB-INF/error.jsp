<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-offset-1 col-sm-10">
		<div class="alert alert-success alert-dismissible fade in" role="alert"  style="margin-top: 21px;">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<h4>完了しました！</h4>
			<ul>
				<li>No.27のリストを更新しました。</li>
			</ul>
		</div>
		<c:if test="${error.equals(\"error\")}">
			<div class="alert alert-danger alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4>エラーが発生しました！</h4>
				<ul>
					<c:if test="${etn.equals(\"題名は必須入力です。\")}"><li>${etn}</li></c:if>
					<c:if test="${eto.equals(\"題名は100文字以内にして下さい。\")}"><li>${eto}</li></c:if>
					<c:if test="${ei.equals(\"重要度に不正な入力がされました。\")}"><li>${ei}</li></c:if>
					<c:if test="${ed.equals(\"期限は「YYYY/MM/DD」形式で入力して下さい。\")}"><li>${ed}</li></c:if>
				</ul>
			</div>
		</c:if>
	</div>
</div><!-- row -->
