package com.jean.util;


import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class DocumentParser {

    public void parse(InputStream stream) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook(stream);
        ExcelExtractor extractor = new ExcelExtractor(wb);
        extractor.setFormulasNotResults(false); //work with formuls\
    }
}
