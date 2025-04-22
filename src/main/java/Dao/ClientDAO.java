package Dao;

import Model.Client;
import Utils.DButil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClientDAO {
	public List<Client> listerClients() throws SQLException {
        List<Client> liste = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection c = DButil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Client cli = new Client();
                cli.setId(rs.getInt("id"));
                cli.setNom(rs.getString("nom"));
                cli.setEmail(rs.getString("email"));
                cli.setTelephone(rs.getString("telephone"));
                liste.add(cli);
            }
        }
        return liste;
    }

    public void ajouterClient(Client cl) throws SQLException {
        String sql = "INSERT INTO client(nom,email,telephone) VALUES(?,?,?)";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cl.getNom());
            ps.setString(2, cl.getEmail());
            ps.setString(3, cl.getTelephone());
            ps.executeUpdate();
        }
    }

    public Client trouverClient(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE id=?";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Client cl = new Client();
                    cl.setId(rs.getInt("id"));
                    cl.setNom(rs.getString("nom"));
                    cl.setEmail(rs.getString("email"));
                    cl.setTelephone(rs.getString("telephone"));
                    return cl;
                }
            }
        }
        return null;
    }

    public void modifierClient(Client cl) throws SQLException {
        String sql = "UPDATE client SET nom=?,email=?,telephone=? WHERE id=?";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cl.getNom());
            ps.setString(2, cl.getEmail());
            ps.setString(3, cl.getTelephone());
            ps.setInt(4, cl.getId());
            ps.executeUpdate();
        }
    }

    public void supprimerClient(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id=?";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

}
