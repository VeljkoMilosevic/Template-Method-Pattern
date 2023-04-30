/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.main;

import desing.patterns.templatemethod.domain.FileHandlingException;
import desing.patterns.templatemethod.domain.Index;
import desing.patterns.templatemethod.domain.Manager;
import desing.patterns.templatemethod.domain.Report;
import desing.patterns.templatemethod.domain.Student;
import desing.patterns.templatemethod.reader.AbstractReader;
import desing.patterns.templatemethod.reader.JSONReader;
import desing.patterns.templatemethod.reader.XMLReader;
import desing.patterns.templatemethod.writer.AbstractWriter;
import desing.patterns.templatemethod.writer.JSONWriter;
import desing.patterns.templatemethod.writer.XMLWriter;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Veljko
 */
public class Main {

    private static final String STUDENT_PATH = "resources/StudentNew";
    private static final String REPORT_PATH = "resources/ReportNew";

    public static void main(final String[] args) throws Exception {
        makeResourceDirectory();

        writeStudentObjectToJSON();
        writeReportObjectToJSON();
        readStudentObjectFromJSON();
        readReportObjectFromJSON();

        writeStudentObjectToXML();
        writeReportObjectToXML();
        readStudentObjectFromXML();
        readReportObjectFromXML();
    }

    private static void writeStudentObjectToXML() throws FileHandlingException, ParseException {
        final AbstractWriter<Student> writer = new XMLWriter<>();
        final Student student = createStudent();
        writer.write(STUDENT_PATH, student);
    }

    private static void writeStudentObjectToJSON() throws FileHandlingException, ParseException {
        final AbstractWriter<Student> writer = new JSONWriter<>();
        final Student student = createStudent();
        writer.write(STUDENT_PATH, student);
    }

    private static void writeReportObjectToXML() throws FileHandlingException {
        final AbstractWriter<Report> writer = new XMLWriter<>();
        final Report report = createReport();
        writer.write(REPORT_PATH, report);
    }

    private static void writeReportObjectToJSON() throws FileHandlingException {
        final AbstractWriter<Report> writer = new JSONWriter<>();
        final Report report = createReport();
        writer.write(REPORT_PATH, report);
    }

    private static void readStudentObjectFromXML() throws FileHandlingException {
        final AbstractReader<Student> reader = new XMLReader<>();
        reader.read(STUDENT_PATH, Student.class);
    }

    private static void readStudentObjectFromJSON() throws FileHandlingException {
        final AbstractReader<Student> reader = new JSONReader<>();
        reader.read(STUDENT_PATH, Student.class);
    }

    private static void readReportObjectFromJSON() throws FileHandlingException {
        final AbstractReader<Report> reader = new JSONReader<>();
        reader.read(REPORT_PATH, Report.class);
    }

    private static void readReportObjectFromXML() throws FileHandlingException {
        final AbstractReader<Report> reader = new XMLReader<>();
        reader.read(REPORT_PATH, Report.class);
    }

    private static Student createStudent() throws ParseException {
        final Student student = new Student();
        student.setName("Veljko");
        student.setSurname("Milosevic");
        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        student.setDateBirth(sdf.parse("12.02.1997."));
        final Index index = new Index();
        index.setNumber("0244");
        index.setYear("2016");
        student.setIndex(index);
        student.setGpa(9.03);
        return student;
    }

    private static Report createReport() {
        final Report report = new Report();
        final Manager manager = new Manager();
        manager.setName("Veljko");
        manager.setSurname("Milosevic");
        report.setManager(manager);
        report.setDate(new Date());
        final List<String> items = new LinkedList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");
        report.setItems(items);
        return report;
    }

    private static void makeResourceDirectory() {
        final File file = new File("resources/");
        if (!file.exists()) {
            System.out.println("Creating directory: " + file);
            System.out.printf("Directory %s created:%s%n", file, file.mkdirs());
        }
    }
}
