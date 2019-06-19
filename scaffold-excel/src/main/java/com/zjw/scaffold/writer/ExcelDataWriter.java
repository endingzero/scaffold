package com.zjw.scaffold.writer;

import com.google.common.net.UrlEscapers;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @program scaffold
 * @description: excel数据写入
 * @author: zhuangjiewei
 * @create: 2019/03/28 22:49
 */
@Slf4j
public class ExcelDataWriter implements DataWriter<ResponseEntity<FileSystemResource>> {

    private String title;
    private List<String> header;
    private Sheet sheet;
    private int rowIndex;
    private Workbook workbook;
    private CellStyle headerCellStyle;
    private CellStyle dataCellStyle;


    public ExcelDataWriter() {
        //内存中保留500条
        this.workbook = new SXSSFWorkbook(500);
        this.headerCellStyle = this.workbook.createCellStyle();
        Font font = this.workbook.createFont();
        font.setFontHeightInPoints((short)13);
        this.headerCellStyle.setFont(font);
        this.headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        this.headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setHeader(List<String> header) {
        this.header = header;
    }

    @Override
    public void accept(List<String> data) {
        if(this.sheet == null) {
            this.initSheet();
        }
        this.writeRow(data,this.dataCellStyle);
    }

    private void initSheet() {
        String sheetName = this.title;
        int numberOfSheets = this.workbook.getNumberOfSheets();
        if(numberOfSheets > 0) {
            sheetName = String.format("%s-%d", sheetName, numberOfSheets + 1);
        }
        sheetName = WorkbookUtil.createSafeSheetName(sheetName);
        this.sheet = this.workbook.createSheet(sheetName);
        this.rowIndex = 0;
        this.writeRow(this.header, this.headerCellStyle);
    }

    private void writeRow(List<String> rowData, CellStyle cellStyle) {
        Row row = this.sheet.createRow(rowIndex);
        int i = 0;
        for(int length = rowData.size(); i < length; ++i) {
            if (rowData.get(i) != null) {
                CellUtil.createCell(row, i, rowData.get(i), cellStyle);
            }
        }
        ++this.rowIndex;
    }

    @Override
    public ResponseEntity<FileSystemResource> get() {

        File file = this.getFile(workbook);

        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .header("Content-Disposition", String.format("attachment; filename=%s.xlsx", UrlEscapers.urlPathSegmentEscaper().escape(title)))
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));

    }

    private File getFile(Workbook workbook) {

        File file = this.createTempFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){

            workbook.write(fileOutputStream);
        } catch (Exception e) {
            log.error("导出错误excel",e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("关闭workbook",e);
            }
        }
        return file;
    }

    private File createTempFile() {
        String prefix = UUID.randomUUID().toString();
        String suffix = ".xlsx";
        File file = null;
        try {
            file = File.createTempFile(prefix, suffix);
        } catch (IOException e) {
            log.error("创建临时文件",e);
        }
        return file;
    }


}
