package Lax.arbetsprov.laxstuga.entitys;

import jakarta.persistence.*;


@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "CUSTOMER_FIRSTNAME")
    private String firstname;

    @Column(name = "CUSTOMER_LASTNAME")
    private String lastname;

    @Column(name = "CABIN")
    private String cabin;

    private long cabinId;

    @Column(name = "BOOKED")
    private boolean booked;

    @Column(name = "RENT_DATE")
    private String rentDate;

    @Column(name = "RETURN_DATE")
    private String returnDate;

    public Orders() {
    }

    public Orders( String firstname, String lastname, long customerId, String cabin, long cabinId, String rentDate, String returnDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = customerId;
        this.cabin = cabin;
        this.cabinId = cabinId;
        this.setRentDate(rentDate);
        this.setReturnDate(returnDate);
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

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public long getCabinId() {
        return cabinId;
    }

    public void setCabinId(long carId) {
        this.cabinId = carId;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customer_id) {
        this.customerId = customer_id;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String date) {
        this.rentDate = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
