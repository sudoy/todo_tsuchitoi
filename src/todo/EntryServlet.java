package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.EntryForm;
import todo.utils.DBUtils;


@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		if(validate(req)) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;

			try{

				con = DBUtils.getConnection();

				sql = "INSERT INTO todo (title, detail, importance, limit_date) VALUES (?,?,?,?)";

				ps = con.prepareStatement(sql);

				ps.setString(1, req.getParameter("title"));
				ps.setString(2, req.getParameter("detail"));
				ps.setString(3, req.getParameter("importance"));
				if(req.getParameter("limit_date").equals("")) {
					ps.setString(4, null);
				}else {
					ps.setString(4, req.getParameter("limit_date"));
				}

				ps.executeUpdate();
			}catch(Exception e){
				throw new ServletException(e);
			}finally{
				try{
					DBUtils.close(con);
					DBUtils.close(ps);
				}catch(Exception e){}
			}


			resp.sendRedirect("index.html");
		}else {

			req.setAttribute("error", "error");

			EntryForm ef = new EntryForm(null, req.getParameter("title"), req.getParameter("detail"),
					Integer.parseInt(req.getParameter("importance")), req.getParameter("limit_date"));

			req.setAttribute("ef", ef);

			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
			.forward(req, resp);
		}
	}

	public static boolean validate(HttpServletRequest req) {

		boolean errorCheck = true;
		int titleLength = req.getParameter("title").length();
		if(req.getParameter("title").equals("")) {
			errorCheck = false;
			req.setAttribute("etn", "題名は必須入力です。");
		}
		if(titleLength > 100) {
			errorCheck = false;
			req.setAttribute("eto", "題名は100文字以内にして下さい。");
		}
		if(req.getParameter("importance").equals("1")
				|| req.getParameter("importance").equals("2")
				|| req.getParameter("importance").equals("3")) {
		}else {
			errorCheck = false;
			req.setAttribute("ei", "重要度に不正な入力がされました。");
		}
		if((req.getParameter("limit_date").equals("") == false)) {
			if((dateCheck(req) == false)) {
				errorCheck = false;
				req.setAttribute("ed", "期限は「YYYY/MM/DD」形式で入力して下さい。");
			}
		}

		return errorCheck;
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
