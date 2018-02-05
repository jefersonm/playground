package com.thomson.poc.jasper.engine;

import com.thomson.poc.jasper.pojo.Metric;
import com.thomson.poc.jasper.pojo.Report;
import com.thomson.poc.jasper.pojo.Section;

import java.util.ArrayList;
import java.util.List;

public class ReportBean {

    public static List<Report> createMainBeanCollection() {
        List<Report> reports = new ArrayList<Report>();
        List<Section> sections = new ArrayList<Section>();

        Report report = new Report();
        report.setServiceName("1P Auth");

        Section section = new Section();
        section.setType("Service Infrastructure");
        section.setMetrics(ReportBean.createImages());
        sections.add(section);

        section = new Section();
        section.setType("General Java stats");
        section.setMetrics(ReportBean.createImages());
        sections.add(section);

        section = new Section();
        section.setType("Gatling output");
        section.setMetrics(ReportBean.createImages());
        sections.add(section);

        report.setSections(sections);
        reports.add(report);

        return reports;
    }

    private static List<Metric> createImages() {
        List<Metric> metrics = new ArrayList<Metric>();

        Metric metric = new Metric();
        metric.setName("cpu");
        metric.setImage(ClassLoader.class.getResourceAsStream("/images/report_cpu.png"));
        metrics.add(metric);

        metric = new Metric();
        metric.setName("memory");
        metric.setImage(ClassLoader.class.getResourceAsStream("/images/report_total_disk.png"));
        metrics.add(metric);

        return metrics;
    }

}
