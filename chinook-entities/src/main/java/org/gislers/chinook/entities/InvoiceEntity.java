package org.gislers.chinook.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "invoice", schema = "chinook")
public class InvoiceEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private long invoiceId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private CustomerEntity customerEntity;

    @Column(name="invoice_date")
    private Date invoiceDate;

    @Column(name="billing_address")
    private String billingAddress;

    @Column(name="billing_state")
    private String billingState;

    @Column(name="billing_country")
    private String billingCountry;

    @Column(name="billing_postal_code")
    private String billingPostalCode;

    private BigDecimal total;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="invoiceEntity")
    private List<InvoiceLineEntity> invoiceLineEntities;

    public InvoiceEntity() {
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public List<InvoiceLineEntity> getInvoiceLineEntities() {
        return invoiceLineEntities;
    }

    public void setInvoiceLineEntities(List<InvoiceLineEntity> invoiceLineEntities) {
        this.invoiceLineEntities = invoiceLineEntities;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
