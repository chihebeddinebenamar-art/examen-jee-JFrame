package Model;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class BaseDonnee {
    private Connection con;
    private Statement st;

    public BaseDonnee() {
        try {
            // Chargement du pilote
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("erreur pilote ");
        }

        try {
            // Initialisation de la variable de connexion
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BaseFx2024", "root", "");
        } catch (Exception e) {
            System.out.println("erreur connexion ");
        }

        try {
            // Initialisation de variable statement
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("erreur stm ");
        }
    }

    public int ajouter(Etudiant e) {
        String cmd = "insert into user(nom,genre,adress) values('" + e.getNom() + "','" + e.getGenre() + "','" + e.getAdresse() + "')";
        try {
            return st.executeUpdate(cmd);
        } catch (Exception ex) {
            System.out.println("erreur sql");
        }
        return -1;
    }

    public void remplir(DefaultTableModel model) {
        // Vider le modèle avant de le remplir
        model.setRowCount(0);
        
        String cmd = "select * from user";
        try {
            ResultSet rs = st.executeQuery(cmd);
            while (rs.next()) {
                // Inclure l'id dans les données
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("genre"),
                    rs.getString("adress")
                });
            }
        } catch (SQLException e) {
            System.out.println("erreur remplir: " + e.getMessage());
        }
    }
}
