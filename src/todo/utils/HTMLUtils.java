package todo.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class HTMLUtils {

	public static String importanceFormat(int importance) {
		String s = "";
		for(int i = 1; i <= importance; i++) {
			s = s.concat("★");
		}
		return s;
	}

	public static String dateFormat(Date limitDate) {
		String s = "";
		if(limitDate == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		s = sdf.format(limitDate);

		return s;
	}

	public static String ufDateFormat(String limitDate) {
		return limitDate.replace("-", "/");
	}

}
