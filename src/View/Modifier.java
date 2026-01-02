package View;

import javax.swing.*;
import java.awt.*;

public class Modifier extends JFrame {

    // label et textfield
    JLabel titre = new JLabel("inscription ");
    JLabel idLabel = new JLabel("id");
    JTextField id=new JTextField();
    JLabel nomlabel=new JLabel("Nom");
    public JTextField nom=new JTextField();
    JLabel genre=new JLabel("genre");
    JButton H=new JButton("homme");
    JButton F=new JButton("femme");
    public JLabel address=new JLabel("address");
    JComboBox list=new JComboBox();

    //les bouttons
    public JButton modifier=new JButton("modifier dans la base");
    public JButton annuler=new JButton("annuler");
    public JButton fermer=new JButton("fermer cette fenetre");

    public Modifier() {

        setTitle("Modifier");

        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getParent());

        titre.setHorizontalAlignment(SwingConstants.CENTER);

        //genre
        JPanel Pgenre=new JPanel(new GridLayout(1,2));
        Pgenre.add(H);
        Pgenre.add(F);

        //les bouttons
        JPanel psouth=new JPanel(new GridLayout(1,3));
        psouth.add(modifier);
        psouth.add(annuler);
        psouth.add(fermer);


        //formulaire
        JPanel Center=new JPanel(new GridLayout(4,2));
        Center.add(idLabel);
        Center.add(id);
        Center.add(nomlabel);
        Center.add(nom);
        Center.add(genre);
        Center.add(Pgenre);
        Center.add(address);
        Center.add(list);

        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add("CENTER",Center);
        c.add("SOUTH",psouth);


        //les ecouteurs
    }
}
