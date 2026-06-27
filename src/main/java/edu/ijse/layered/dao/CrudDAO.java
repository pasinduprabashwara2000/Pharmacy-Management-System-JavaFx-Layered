package edu.ijse.layered.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{

    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(Integer id) throws Exception;
    T findById(Integer id) throws Exception;
    List<T> getAll() throws Exception;

}
