package Lax.arbetsprov.laxstuga.entitys;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "CABINS")
public class Cabins {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;
    @Column(name = "PRICE")
    private int price;

    @Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "BOOKED")
    private boolean booked;

    @Column(name = "DETAILS")
    private String details;


    public Cabins() {
    }

    public Cabins(long id, String name, String type, int price, LocalDateTime date, boolean booked, String details) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.date = date;
        this.booked = booked;
        this.details = details;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
