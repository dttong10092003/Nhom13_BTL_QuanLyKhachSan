package gui;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuyenDoi {
	// chuyển đổi từ string->date

	static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	static DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

	public static Date getDate(String ngay) {
		try {
			return df.parse(ngay);
		} catch (ParseException ex) {
			System.out.println("Lỗi ngày");
		}
		return null;
	}

	public static Date getDate1(String ngay) {
		try {
			return df1.parse(ngay);
		} catch (ParseException ex) {
			System.out.println("Lỗi ngày");
		}
		return null;
	}

	// chuyển đổi từ date->string

	public static String getDate2(Date date) {
		return df.format(date);
	}

	// chuyển đổi định dạng số double -> string

	public static String dinhDangSo(double so) {
		return NumberFormat.getNumberInstance().format(so);

	}

	// chuyển từ string-> double
	public static double chuyenSangSo(String chuSo) {
		try {
			return NumberFormat.getNumberInstance().parse(chuSo).doubleValue();
		} catch (ParseException ex) {

			return 0;
		}
	}

}
