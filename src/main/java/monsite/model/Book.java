package monsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titre;
    private String auteur;
    private String edition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublication;
    private String isbn;
    private int nombrePages;
    private boolean disponible = true; 

    public Book(){}
    //Constructeurs 
    public Book(String titre, String auteur, String edition, LocalDate datePublication){
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.datePublication = datePublication; 
    }

    //Gettters et setters
    public long getId(){return id;}
    public void setId(Long id ){this.id = id;}

    public String getTitre(){return titre;}
    public void setTitre(String titre){this.titre = titre;}

    public String getAuteur(){return auteur;}
    public void setAuteur(String auteur){this.auteur = auteur;}

    public String getEdition(){return edition;}
    public void setEdition(String edition){this.edition = edition;}

    public LocalDate getDatePublication(){return datePublication;}
    public void setDatePublication(LocalDate datePublication){this.datePublication = datePublication;}

    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn = isbn;}

    public int getNombrePages(){return nombrePages;}
    public void setNombrePages(int nombrePages){this.nombrePages = nombrePages;}

    public boolean getDisponible(){return disponible;}
    public boolean isDisponible(){return disponible;}
    public void setDisponible(boolean disponible){this.disponible = disponible;}

}
