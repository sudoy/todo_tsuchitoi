package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.beans.Login;
import todo.utils.DBUtils;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{


			con = DBUtils.getConnection();

			sql = "select login_id, user, email, password from login where email=? and password=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, req.getParameter("email"));
			ps.setString(2, req.getParameter("password"));

			rs = ps.executeQuery();

			if(!rs.next()) {

				req.setAttribute("errorList", "メールアドレス、またはパスワードが間違っています。");
				getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(req, resp);
				return;
			}
			Login login = new Login(rs.getInt("login_id"), rs.getString("user"),
					rs.getString("email"), rs.getString("password"));
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
			resp.sendRedirect("index.html");
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				DBUtils.close(con);
				DBUtils.close(ps);
				DBUtils.close(rs);
			}catch(Exception e){}
		}
	}
}
