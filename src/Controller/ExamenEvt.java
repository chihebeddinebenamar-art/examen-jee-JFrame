package Controller;

import Model.BaseDonnee;
import View.Ajouter;
import View.Examen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamenEvt implements ActionListener {

    private BaseDonnee bd;
    private Examen ex;
    private Thread refreshThread;

    public ExamenEvt(Examen ex) {
        this.ex = ex;
        this.bd = new BaseDonnee();
        
        // Thread pour rafraîchir le tableau automatiquement toutes les 2 secondes
        refreshThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000); // 2 secondes
                    SwingUtilities.invokeLater(() -> {
                        bd.remplir(ex.model);
                    });
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        refreshThread.setDaemon(true);
        refreshThread.start();
        
        // Remplir le tableau au démarrage
        bd.remplir(ex.model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Ajouter un utilisateur")) {
            Ajouter ajouterVue = new Ajouter();
            AjouterEvt ajouterEvt = new AjouterEvt(ajouterVue, this);
            ajouterVue.ajouter.addActionListener(ajouterEvt);
            ajouterVue.annuler.addActionListener(ajouterEvt);
            ajouterVue.fermer.addActionListener(ajouterEvt);
            ajouterVue.setVisible(true);
        } else if (cmd.equals("Supprimer un utilisateur")) {
            // Bouton sans action selon les spécifications
            int selectedRow = ex.table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(ex, "Veuillez sélectionner un utilisateur à supprimer");
            } else {
                // Fonctionnalité non implémentée (bouton sans action)
            }
        }
    }
}
