//package dao;
//
//import database.Connector;
//import entity.Subject2;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class SubjectDAOImpl2 implements SubjectDAO2 {
//    private String table = "subjects";
//
//    @Override
//    public ArrayList<Subject2> all() {
//        ArrayList<Subject2> list = new ArrayList<>();
//        try {
//            Connector connector = Connector.getInstance();
//            Statement st = connector.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
//            while (rs.next()) {
//                Subject2 subject = new Subject2(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("hours"),
//                        rs.getDouble("cost")
//                );
//                list.add(subject);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//
//    @Override
//    public Subject2 findById(int id) {
//        try {
//            Connector connector = Connector.getInstance();
//            PreparedStatement ps = connector.preparedStatement("SELECT * FROM " + table + " WHERE id = ?");
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Subject2(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("hours"),
//                        rs.getDouble("cost")
//                );
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean create(Subject2 subject) {
//        try {
//            Connector connector = Connector.getInstance();
//            PreparedStatement ps = connector.preparedStatement("INSERT INTO " + table + " (name, hours, cost) VALUES (?, ?, ?)");
//            ps.setString(1, subject.getName());
//            ps.setInt(2, subject.getHours());
//            ps.setDouble(3, subject.getCost());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public boolean update(Subject2 subject) {
//        try {
//            Connector connector = Connector.getInstance();
//            PreparedStatement ps = connector.preparedStatement("UPDATE " + table + " SET name = ?, hours = ?, cost = ? WHERE id = ?");
//            ps.setString(1, subject.getName());
//            ps.setInt(2, subject.getHours());
//            ps.setDouble(3, subject.getCost());
//            ps.setInt(4, subject.getId());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public boolean delete(int id) {
//        try {
//            Connector connector = Connector.getInstance();
//            PreparedStatement ps = connector.preparedStatement("DELETE FROM " + table + " WHERE id = ?");
//            ps.setInt(1, id);
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
