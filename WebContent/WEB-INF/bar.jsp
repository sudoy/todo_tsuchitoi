<%@page pageEncoding="UTF-8"%>
<div class="container-fluid" style="background-color: white;">
			<div class="row">
				<div class="col-sm-offset-1">
					<a href="index.html"><h1 class="col-sm-4"><small>Todoリスト</small></h1></a>
				</div>
				<div class="dropdown pull-right" style="margin-top: 19px;">
					<button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						${login.user}
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="logout.html">ログアウト</a></li>
					</ul>
				</div>
			</div>
		</div><!-- /container -->