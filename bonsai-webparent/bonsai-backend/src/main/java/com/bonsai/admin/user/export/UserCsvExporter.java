package com.bonsai.admin.user.export;

import com.bonsai.admin.AbstractExporter;
import com.bonsai.common.entity.User;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserCsvExporter extends AbstractExporter {

	public void export(List<User> listUsers, HttpServletResponse response) throws IOException {
		super.setResponseHeader(response, "text/csv", ".csv", "users_");//các tham số là các định dạng mong muốn

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "User ID", "E-mail", "First Name", "Last Name", "Roles", "Enabled" };//phần header hiển thị
		String[] fieldMapping = { "id", "email", "firstName", "lastName", "roles", "enabled" };//khai báo các thuộc tính trong entity

		csvWriter.writeHeader(csvHeader);//write header

		for (User user : listUsers) {
			csvWriter.write(user, fieldMapping);//write rows
		}

		csvWriter.close();
	}
}
