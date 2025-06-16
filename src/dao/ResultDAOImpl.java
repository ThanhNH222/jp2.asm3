package dao;

import entity.Result;
import database.Connector;

import java.sql.*;
import java.util.ArrayList;

public class ResultDAOImpl implements RepositoryDAO<Result, Integer> {
    private String table = "results";

    @Override
    public ArrayList<Result> all() {
        ArrayList<Result> list = new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            Statement stmt = connector.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                Result r = new Result(
                        rs.getInt("id"),
                        rs.getDouble("mark"),
                        rs.getInt("student_id"),
                        rs.getInt("subject_id")
                );
                list.add(r);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Result findById(Integer id) {
        try {
            Connector connector = Connector.getInstance();
            Statement stmt = connector.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE id = " + id);
            if (rs.next()) {
                return new Result(
                        rs.getInt("id"),
                        rs.getDouble("mark"),
                        rs.getInt("student_id"),
                        rs.getInt("subject_id")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Boolean create(Result r) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "INSERT INTO results(mark, student_id, subject_id) VALUES (?, ?, ?)";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setDouble(1, r.getMark());
            pstm.setInt(2, r.getStudentId());
            pstm.setInt(3, r.getSubjectId());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean update(Result r) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "UPDATE results SET mark = ?, student_id = ?, subject_id = ? WHERE id = ?";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setDouble(1, r.getMark());
            pstm.setInt(2, r.getStudentId());
            pstm.setInt(3, r.getSubjectId());
            pstm.setInt(4, r.getId());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "DELETE FROM results WHERE id = ?";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
