package Controlador;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

public class ExcelPlantilla extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, URISyntaxException, SQLException {

        response.setContentType("application/vnd.ms-excel");
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("Hoja 1");

        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[]{"Identificador","Nombre","Tipo","cursoArea","Colegio","Clave","Imagen","Correo","Estado"});
        data.put("2", new Object[]{"12345678","Nombre Estudiante","Estudiante, Docente, Administrativo","curso-Area","Nombre de colegio","null","null","null","null"});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        int rowTotal = sheet.getLastRowNum();

        if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
            rowTotal++;
        }
        HSSFCellStyle cellStyle = wb.createCellStyle();
        for (int j = 0; j < rowTotal; j++) {
            HSSFRow header = sheet.getRow(j);
            for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
                HSSFCell cell = header.getCell(i);
                cell.setCellStyle(cellStyle);
            }
        }
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 5000);
        sheet.setColumnWidth(6, 3000);

        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        HSSFRow header1 = sheet.getRow(0);
        for (int i = 0; i < header1.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header1.getCell(i);
            cell.setCellStyle(cellStyle2);
        }

        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle2.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        cellStyle2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle2.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP POST method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Example to create a workbook in a servlet using HSSF";
    }
}
