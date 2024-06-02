package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "prix")
    private Integer prix;

    // Default constructor
    public Voiture() {}

    // Parameterized constructor
    public Voiture(String marque, Integer prix) {
        this.marque = marque;
        this.prix = prix;
    }

    // Getter and Setter for marque
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    // Getter and Setter for prix
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
