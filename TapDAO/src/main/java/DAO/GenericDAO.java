package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica para un DAO
 */
public interface GenericDAO<T> {
    void insertar(T obj) throws SQLException;
    List<T> consultarTodos() throws SQLException;
    void actualizar(T obj) throws SQLException;
    void eliminar(int id) throws SQLException;
}
