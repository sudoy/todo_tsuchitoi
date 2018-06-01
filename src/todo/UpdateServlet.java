package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.Todo;
import todo.utils.DBUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;


		try {
			con = DBUtils.getConnection();

			sql = "select * from todo where id=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, req.getParameter("id"));

			rs = ps.executeQuery();

			rs.next();

			Todo todo = new Todo(rs.getInt("id"), rs.getString("title"),
					rs.getString("detail"), rs.getInt("importance"),
					rs.getDate("limit_date")
				);

		req.setAttribute("todo", todo);

			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
			.forward(req, resp);


		} catch (Exception e) {
			throw new ServletException(e);
		}finally {
			try {
				DBUtils.close(con);
				DBUtils.close(ps);
				DBUtils.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = DBUtils.getConnection();

			if(req.getParameter("update") != null){
				sql = "UPDATE todo SET title = ?, detail = ?, importance = ?, limit_date = ? where id = ?";

				ps = con.prepareStatement(sql);

				ps.setString(1, req.getParameter("title"));
				ps.setString(2, req.getParameter("detail"));
				ps.setString(3, req.getParameter("importance"));
				ps.setString(4, req.getParameter("limit_date"));
				ps.setString(5, req.getParameter("id"));

				System.out.println(req.getParameter("id"));

			}else{
				//sql作る
				sql = "DELETE FROM todo where id = ?";

				//準備
				ps = con.prepareStatement(sql);

				//ポストデータをセット
				ps.setString(1, req.getParameter("id"));
			}

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


		resp.sendRedirect("index.html");
	}
}
