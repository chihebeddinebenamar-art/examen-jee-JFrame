package View;

import Controller.ExamenEvt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Examen extends JFrame {

    // Titre
    JLabel titre = new JLabel("Liste des utilisateurs");

    // Barre de menu
    JMenuBar menuBar = new JMenuBar();
    JMenu ouvrir = new JMenu("Ouvrir");
    JMenu gestionUtilisateurs = new JMenu("Gestion des utilisateurs");
    JMenuItem ajouter = new JMenuItem("Ajouter un utilisateur");
    JMenuItem supprimer = new JMenuItem("Supprimer un utilisateur");
    JMenu aide = new JMenu("Aide");

    // Tableau
    String nomColonnes[] = {"Id", "Nom", "Genre", "Adresse"};
    public DefaultTableModel model = new DefaultTableModel(nomColonnes, 0);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);

    public Examen() {
        setTitle("Examen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Configuration de la barre de menu
        gestionUtilisateurs.add(ajouter);
        gestionUtilisateurs.add(supprimer);
        ouvrir.add(gestionUtilisateurs);
        menuBar.add(ouvrir);
        menuBar.add(aide);
        setJMenuBar(menuBar);

        // Configuration du tableau
        table.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(580, 300));

        // Layout
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("NORTH", titre);
        c.add("CENTER", scrollPane);

        // Les écouteurs
        ExamenEvt examenEvt = new ExamenEvt(this);
        ajouter.addActionListener(examenEvt);
        supprimer.addActionListener(examenEvt);

        setVisible(true);
    }
}
