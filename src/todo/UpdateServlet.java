package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.beans.UpdateForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession();

		if(session.getAttribute("login") == null) {
			session.setAttribute("errorList", "ログインしてください。");
			resp.sendRedirect("login.html");
			return;
		}


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

			UpdateForm uf = new UpdateForm(rs.getString("id"), rs.getString("title"),
					rs.getString("detail"), rs.getInt("importance"),
					HTMLUtils.ufDateFormat(rs.getString("limit_date"))
				);

			req.setAttribute("uf", uf);

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

		HttpSession session = req.getSession();
		if(session.getAttribute("login") == null) {
			session.setAttribute("errorList", "ログインしてください。");
			resp.sendRedirect("login.html");
			return;
		}



		List<String> errorList = validate(req);
		if(errorList.size() > 0) {

			//errorListをsessionに登録
			session.setAttribute("errorList", errorList);

			UpdateForm uf = new UpdateForm(req.getParameter("id"), req.getParameter("title"), req.getParameter("detail"),
					Integer.parseInt(req.getParameter("importance")), req.getParameter("limit_date"));

			req.setAttribute("uf", uf);


			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
			.forward(req, resp);
			return;

		}

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = DBUtils.getConnection();

			sql = "UPDATE todo SET title = ?, detail = ?, importance = ?, limit_date = ? where id = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, req.getParameter("title"));
			ps.setString(2, req.getParameter("detail"));
			ps.setString(3, req.getParameter("importance"));
			if(req.getParameter("limit_date").equals("")) {
				ps.setString(4, null);
			}else {
				ps.setString(4, req.getParameter("limit_date"));
			}
			ps.setString(5, req.getParameter("id"));

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

		//sessionに登録メッセージを登録し、エラー文を消す。
		List<String> success = new ArrayList<>();
		success.add("更新しました。");
		session.setAttribute("success", success);

		resp.sendRedirect("index.html");
	}

	private static List<String> validate(HttpServletRequest req) {
		List<String> errorList = new ArrayList<>();
		int titleLength = req.getParameter("title").length();

		if(req.getParameter("id").equals("")) {
			errorList.add("idに不正な入力がありました。");
		}

		if(req.getParameter("title").equals("")) {
			errorList.add("題名は必須入力です。");
		}
		if(titleLength > 100) {
			errorList.add("題名は100文字以内にして下さい。");
		}
		if(req.getParameter("importance").equals("1")
				|| req.getParameter("importance").equals("2")
				|| req.getParameter("importance").equals("3")) {
		}else {
			errorList.add("重要度に不正な入力がありました。");
		}
		if((req.getParameter("limit_date").equals("") == false)) {
			if((dateCheck(req) == false)) {
				errorList.add("期限は「YYYY/MM/DD」形式で入力して下さい。");
			}
		}

		return errorList;
	}

	public static boolean dateCheck(HttpServletRequest req) {
		String value = req.getParameter("limit_date");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		df.setLenient(false);
		java.util.Date parsedDate = null;
		boolean dateCheck = true;
		try {
			parsedDate =  df.parse(value);
			dateCheck = df.format(parsedDate).equals(value);
		} catch (Exception e) {
			dateCheck = false;
		}
		return dateCheck;

	}

}
