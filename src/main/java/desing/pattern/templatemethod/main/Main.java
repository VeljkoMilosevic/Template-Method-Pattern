/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.main;

import desing.pattern.templatemethod.domain.Index;
import desing.pattern.templatemethod.domain.Manager;
import desing.pattern.templatemethod.reader.XMLReader;
import desing.pattern.templatemethod.reader.AbstractReader;
import desing.pattern.templatemethod.domain.Report;
import desing.pattern.templatemethod.domain.Student;
import desing.pattern.templatemethod.reader.JSONReader;
import desing.pattern.templatemethod.writer.AbstractWriter;
import desing.pattern.templatemethod.writer.JSONWriter;
import desing.pattern.templatemethod.writer.XMLWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Veljko
 */
public class Main {

    public static void main(String[] args) throws Exception {
      //  writeStudentObjectToXML();
        writeStudentObjectToJSON();
        writeReportObjectToJSON();
    }

    private static void writeStudentObjectToXML() throws Exception {
        AbstractWriter<Student> writer = new XMLWriter();
        Student student = createStudent();
        writer.write("resources/StudentNew", student);
    }

    private static void writeStudentObjectToJSON() throws Exception {
        AbstractWriter<Student> writer = new JSONWriter<>();
        Student student = createStudent();
        writer.write("resources/StudentNew", student);
    }

    private static void writeReportObjectToXML() throws Exception {
        AbstractWriter<Report> writer = new XMLWriter();
        Report report = createReport();
        writer.write("resources/ReportNew", report);
    }

    private static void writeReportObjectToJSON() throws Exception {
        AbstractWriter<Report> writer = new JSONWriter<>();
        Report report = createReport();
        writer.write("resources/ReportNew", report);
    }

    private static void readStudentObjectFromXML() throws Exception {
        AbstractReader<Student> reader = new XMLReader<>();
        reader.read("resources/Student", Student.class);
    }

    private static void readStudentObjectFromJSON() throws Exception {
        AbstractReader<Student> reader = new JSONReader<>();
        reader.read("resources/Student", Student.class);
    }

    private static void readReportObjectFromJSON() throws Exception {
        AbstractReader<Report> reader = new JSONReader<>();
        reader.read("resources/Report", Report.class);
    }

    private static void readReportObjectFromXML() throws Exception {
        AbstractReader<Report> reader = new XMLReader<>();
        reader.read("resources/Report", Report.class);
    }

    private static Student createStudent() throws ParseException {
        Student student = new Student();
        student.setName("Veljko");
        student.setSurname("Milosevic");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        student.setDateBirth(sdf.parse("12.02.1997."));
        Index index = new Index();
        index.setNumber("0244");
        index.setYear("2016");
        student.setIndex(index);
        student.setGPA(9.03);
        return student;
    }

    private static Report createReport() {
        Report report = new Report();
        Manager manager = new Manager();
        manager.setName("Veljko");
        manager.setSurname("Milosevic");
        report.setManager(manager);
        report.setDate(new Date());
        List<String> items = new LinkedList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");
        report.setItems(items);
        return report;
    }

}
