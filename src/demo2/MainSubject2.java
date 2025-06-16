//package demo2;
//
//import dao.SubjectDAOImpl2;
//import entity.Subject2;
//
//import java.util.ArrayList;
//
//public class MainSubject2 {
//    public static void main(String[] args) {
//        try {
//            SubjectDAOImpl2 subjectDAO = new SubjectDAOImpl2();
//
//            System.out.println("=== Danh sách môn học ===");
//            ArrayList<Subject2> subjects = subjectDAO.all();
//            for (Subject2 s : subjects) {
//                System.out.printf("ID: %d | Name: %s | Hours: %d | Cost: %.2f\n",
//                        s.getId(), s.getName(), s.getHours(), s.getCost());
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
