package com.bonsai.admin.brand.export;

import com.bonsai.admin.AbstractExporter;
import com.bonsai.common.entity.Brand;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class BrandPdfExporter extends AbstractExporter {

		private static final Font HEADER_FONT = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		private static final Font CONTENT_FONT = FontFactory.getFont(FontFactory.HELVETICA);

		public BrandPdfExporter() {
		}

		public void export(List<Brand> listBrands, HttpServletResponse response) throws IOException {
			super.setResponseHeader(response, "application/pdf", ".pdf", "Brands_");

			Document document = new Document(PageSize.A4);
			try {
				PdfWriter.getInstance(document, response.getOutputStream());

				document.open();

				Paragraph header = new Paragraph("List of Brands", HEADER_FONT);
				header.setAlignment(Paragraph.ALIGN_CENTER);
				header.setSpacingAfter(10);
				document.add(header);

				PdfPTable table = new PdfPTable(3);
				table.setWidthPercentage(100f);
				table.setWidths(new float[] { 1.2f, 3.5f, 3.0f });

				writeTableHeader(table);
				writeTableData(table, listBrands);

				document.add(table);
			} catch (DocumentException e) {
				e.printStackTrace();
			} finally {
				document.close();
			}
		}

		private void writeTableData(PdfPTable table, List<Brand> listBrands) {
			for (Brand brand : listBrands) {
				table.addCell(String.valueOf(brand.getId()));
				table.addCell(brand.getName());
				table.addCell(brand.getLogo());
			}
		}

		private void writeTableHeader(PdfPTable table) {
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(Color.BLUE);
			cell.setPadding(5);

			cell.setPhrase(new Phrase("ID", CONTENT_FONT));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Name", CONTENT_FONT));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Logo", CONTENT_FONT));
			table.addCell(cell);
		}


}
