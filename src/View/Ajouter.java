package View;

import javax.swing.*;
import java.awt.*;

public class Ajouter extends JFrame {

    // Labels et champs
    JLabel titre = new JLabel("inscription");
    JLabel nomLabel = new JLabel("Nom");
    public JTextField nom = new JTextField();
    
    JLabel genreLabel = new JLabel("Genre");
    JRadioButton homme = new JRadioButton("Homme");
    JRadioButton femme = new JRadioButton("Femme");
    ButtonGroup genreGroup = new ButtonGroup();
    
    JLabel adresseLabel = new JLabel("Adresse");
    public JComboBox<String> adresseCombo = new JComboBox<>(new String[]{"Ville 1", "Ville 2", "Ville 3"});

    // Les boutons
    public JButton ajouter = new JButton("Ajouter dans la base");
    public JButton annuler = new JButton("Annuler");
    public JButton fermer = new JButton("Fermer cette fenêtre");

    public Ajouter() {
        setTitle("Ajouter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Désactiver le redimensionnement (bouton d'agrandissement désactivé)

       
        // Groupe de radio buttons pour le genre
        genreGroup.add(homme);
        genreGroup.add(femme);
        JPanel pGenre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pGenre.add(homme);
        pGenre.add(femme);

        // Panel pour les boutons
        JPanel pSouth = new JPanel(new FlowLayout());
        pSouth.add(ajouter);
        pSouth.add(annuler);
        pSouth.add(fermer);

        // Formulaire
        JPanel center = new JPanel(new GridLayout(3, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        center.add(nomLabel);
        center.add(nom);
        center.add(genreLabel);
        center.add(pGenre);
        center.add(adresseLabel);
        center.add(adresseCombo);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("NORTH", titre);
        c.add("CENTER", center);
        c.add("SOUTH", pSouth);
    }

    public String getGenreSelection() {
        if (homme.isSelected()) {
            return "Homme";
        } else if (femme.isSelected()) {
            return "Femme";
        }
        return "";
    }

    public void clearGenreSelection() {
        // Désélectionner manuellement les radio buttons
        homme.setSelected(false);
        femme.setSelected(false);
    }
}

