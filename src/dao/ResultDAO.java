package dao;

import entity.Result;
import java.util.ArrayList;

public interface ResultDAO {
    ArrayList<Result> all();
    Result findById(int id);
    Boolean create(Result r);
    Boolean update(Result r);
    Boolean delete(int id);
}
