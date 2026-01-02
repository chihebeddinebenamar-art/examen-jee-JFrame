package Model;

public class Etudiant {

    private int id;
    private String nom;
    private String genre;
    private String adresse;

    public Etudiant(int id, String nom, String genre, String adresse) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
        this.adresse = adresse;
    }


    public Etudiant(int id) {
        this.id = id;
    }

    public Etudiant(String adresse, String genre, String nom) {
        this.adresse = adresse;
        this.genre = genre;
        this.nom = nom;
    }

    public Etudiant(String adresse, String nom) {
        this.adresse = adresse;
        this.nom = nom;
    }

    public int getId() {return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', genre='" + genre + "', adresse='" + adresse + "'}";
    }
}
