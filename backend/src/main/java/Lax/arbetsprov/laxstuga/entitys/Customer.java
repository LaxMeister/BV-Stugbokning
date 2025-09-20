package Lax.arbetsprov.laxstuga.entitys;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "RENT_TIMES")
    private int rentTimes;

    public Customer() {
    }

    public Customer(long id, String firstname, String lastname, String address, int phone, String username, int rentTimes) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.rentTimes = rentTimes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRentTimes() {
        return rentTimes;
    }

    public void setRentTimes(int rentTimes) {
        this.rentTimes = rentTimes;
    }
}