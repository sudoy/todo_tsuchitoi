package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.utils.DBUtils;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = DBUtils.getConnection();

			//sql作る
			sql = "DELETE FROM todo where id = ?";

			//準備
			ps = con.prepareStatement(sql);

			//ポストデータをセット
			ps.setString(1, req.getParameter("id"));

			ps.executeUpdate();

		} catch (Exception e) {
			throw new ServletException();
		}finally {
			try {
				DBUtils.close(con);
				DBUtils.close(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//sessionに更新メッセージを登録
		HttpSession session = req.getSession();
		List<String> success = new ArrayList<>();
		success.add("削除しました。");
		session.setAttribute("success", success);



		resp.sendRedirect("index.html");

	}
}
