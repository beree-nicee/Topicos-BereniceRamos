package DAO;


import Models.Libro;
import org.example.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO específico para Libro implementando GenericDAO
 */
public class LibroDAO implements GenericDAO<Libro> {

    @Override
    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libro (titulo, autor, anio, disponible) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnio());
            stmt.setBoolean(4, libro.isDisponible());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) libro.setId(rs.getInt(1));
        }
    }

    @Override
    public List<Libro> consultarTodos() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Libro libro = new Libro.LibroBuilder()
                        .setTitulo(rs.getString("titulo"))
                        .setAutor(rs.getString("autor"))
                        .setAnio(rs.getInt("anio"))
                        .setDisponible(rs.getBoolean("disponible"))
                        .build();
                libro.setId(rs.getInt("id"));
                libros.add(libro);
            }
        }
        return libros;
    }

    @Override
    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE libro SET titulo=?, autor=?, anio=?, disponible=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnio());
            stmt.setBoolean(4, libro.isDisponible());
            stmt.setInt(5, libro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libro WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
