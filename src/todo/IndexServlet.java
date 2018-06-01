package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.Todo;
import todo.utils.DBUtils;

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

			List<Todo> list = new ArrayList<Todo>();

			while(rs.next()) {
				Todo t = new Todo(rs.getInt("id"), rs.getString("title"),
						rs.getString("detail"), rs.getInt("importance"),
						rs.getDate("limit_date")
						);
				list.add(t);
			}
			req.setAttribute("list", list);

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
