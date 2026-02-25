package Agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {

    private static final String SQL_INSERT = "INSERT INTO contato(nome, email, telefone) VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT id, nome, email, telefone FROM contato";

    public void inserir(AgendaModel agenda){
        try(Connection conn = ConnectDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT)){
            ps.setString(1, agenda.getNome());
            ps.setString(2, agenda.getEmail());
            ps.setString(3, agenda.getTelefone());
            ps.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException("erro ao inserir: "+ e.getMessage(), e);
        }
    }

    public List<AgendaModel> buscar() {
        List<AgendaModel> listaRegistros = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AgendaModel registro = new AgendaModel();

                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));

                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar registros: " + e.getMessage(), e);
        }

        return listaRegistros;
    }
}
