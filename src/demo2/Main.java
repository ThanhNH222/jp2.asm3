package demo2;

import dao.ResultDAOImpl;
import dao.StudentDAOImpl;
import database.Connector;
import entity.Result;
import entity.Student;
import entity.Subject;
import factory.DaoFactory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        try{

            System.out.println("==== DANH SÁCH SINH VIÊN ====");
            ArrayList<Student> listStudent = DaoFactory.getDAO("student").all();
            for (Student s : listStudent){
                s.showInfo();
            }

            System.out.println("==== DANH SÁCH MÔN HỌC ====");
            ArrayList<Subject> listSubjects = DaoFactory.getDAO("subject").all();
            for (Subject sub : listSubjects){
                sub.showInfo(); // nhớ có hàm showInfo trong entity.Subject
            }

            System.out.println("==== DANH SÁCH KẾT QUẢ ====");
            ResultDAOImpl resultDAO = new ResultDAOImpl();
            ArrayList<Result> listResults = resultDAO.all();
            for (Result r : listResults) {
                r.showInfo();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}