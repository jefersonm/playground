package com.thomson.poc.jasper;

import com.thomson.poc.jasper.engine.ReportBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.HashMap;

public class Main {

    public static void main(String args[]) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        HashMap jasperParameter = new HashMap();

        try {
            jasperReport = JasperCompileManager.compileReport(ClassLoader.class.getResourceAsStream("/StressTestTemplate.jrxml"));

            JRBeanCollectionDataSource reportBeanCollectionDataSource = new JRBeanCollectionDataSource(
                    ReportBean.createMainBeanCollection(), false);

            jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameter, reportBeanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/jefersonm/Desktop/sample_report.pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
