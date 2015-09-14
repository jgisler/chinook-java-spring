package org.gislers.chinook.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "employee", schema = "chinook")
public class EmployeeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employee_id")
    private long employeeId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="reports_to")
    private EmployeeEntity manager;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="manager")
    private List<EmployeeEntity> subordinates;

    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="supportRep")
    private List<CustomerEntity> customerEntities;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String title;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="hire_date")
    private Date hireDate;

    private String address;
    private String city;
    private String state;
    private String country;

    @Column(name="postal_code")
    private String postalCode;

    private String phone;
    private String fax;
    private String email;

    public EmployeeEntity() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public List<CustomerEntity> getCustomerEntities() {
        return customerEntities;
    }

    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EmployeeEntity> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeEntity> subordinates) {
        this.subordinates = subordinates;
    }
}
