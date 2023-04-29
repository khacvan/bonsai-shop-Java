package com.bonsai.admin.brand.export;

import com.bonsai.admin.AbstractExporter;
import com.bonsai.common.entity.Brand;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BrandCsvExporter extends AbstractExporter {

	public void export(List<Brand> listBrands, HttpServletResponse response) throws IOException {
		super.setResponseHeader(response, "text/csv", ".csv", "brands_");//các tham số là các định dạng mong muốn

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "Brand ID","Brand Name"};//phần header hiển thị
		String[] fieldMapping = { "id", "name"};//khai báo các thuộc tính trong entity

		csvWriter.writeHeader(csvHeader);//write header

		for (Brand Brand : listBrands) {
			csvWriter.write(Brand, fieldMapping);//write rows
		}

		csvWriter.close();
	}
}
