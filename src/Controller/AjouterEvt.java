package Controller;

import Model.BaseDonnee;
import Model.Etudiant;
import View.Ajouter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterEvt implements ActionListener {
    private Ajouter ajouter;
    private BaseDonnee bd;
    private ExamenEvt examenEvt;

    public AjouterEvt(Ajouter ajouter, ExamenEvt examenEvt) {
        this.ajouter = ajouter;
        this.bd = new BaseDonnee();
        this.examenEvt = examenEvt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajouter.ajouter) {
            // Vérifier que tous les champs sont remplis
            if (ajouter.nom.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(ajouter, "Veuillez remplir le champ Nom");
                return;
            }
            
            if (ajouter.getGenreSelection().isEmpty()) {
                JOptionPane.showMessageDialog(ajouter, "Veuillez sélectionner un genre");
                return;
            }
            
            // Créer un nouvel étudiant
            String nom = ajouter.nom.getText().trim();
            String genre = ajouter.getGenreSelection();
            String adresse = (String) ajouter.adresseCombo.getSelectedItem();
            
            // Utiliser le constructeur (String adresse, String genre, String nom)
            Etudiant etudiant = new Etudiant(adresse, genre, nom);
            
            int res = bd.ajouter(etudiant);
            if (res >= 1) {
                JOptionPane.showMessageDialog(ajouter, "Utilisateur ajouté avec succès");
                // Vider les champs après ajout réussi
                ajouter.nom.setText("");
                ajouter.clearGenreSelection();
                ajouter.adresseCombo.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(ajouter, "Erreur lors de l'ajout de l'utilisateur");
            }
        } else if (e.getSource() == ajouter.annuler) {
            // Annuler : vider les champs
            ajouter.nom.setText("");
            ajouter.clearGenreSelection();
            ajouter.adresseCombo.setSelectedIndex(0);
        } else if (e.getSource() == ajouter.fermer) {
            // Fermer : fermer la fenêtre
            ajouter.setVisible(false);
            ajouter.dispose();
        }
    }
}
