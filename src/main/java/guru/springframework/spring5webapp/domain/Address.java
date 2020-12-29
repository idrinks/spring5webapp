package guru.springframework.spring5webapp.domain;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressLine1;
    private String city;
    private String state;
    private Integer zip;



    public Address() {
    }

    public Address(String addressLine1, String city, String state, Integer zip) {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = false)
    private Publisher publisher;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getId() != null ? !getId().equals(address.getId()) : address.getId() != null) return false;
        if (getAddressLine1() != null ? !getAddressLine1().equals(address.getAddressLine1()) : address.getAddressLine1() != null)
            return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getState() != null ? !getState().equals(address.getState()) : address.getState() != null) return false;
        return getZip() != null ? getZip().equals(address.getZip()) : address.getZip() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getZip() != null ? getZip().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", publisher=" + publisher +
                '}';
    }
}
