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

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("utf-8");
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{
			con = DBUtils.getConnection();

			sql = "select id, title, detail, importance, limit_date from todo order by id";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			req.setAttribute("rs", rs);

		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
			.forward(req, resp);

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
