package org.gislers.chinook.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "invoice_line", schema = "chinook")
public class InvoiceLineEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="invoice_line_id")
    private long invoiceLineId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="track_id")
    private TrackEntity trackEntity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="invoice_id")
    private InvoiceEntity invoiceEntity;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    private int quantity;

    public InvoiceLineEntity() {
    }

    public long getInvoiceLineId() {
        return invoiceLineId;
    }

    public void setInvoiceLineId(long invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public TrackEntity getTrackEntity() {
        return trackEntity;
    }

    public void setTrackEntity(TrackEntity trackEntity) {
        this.trackEntity = trackEntity;
    }

    public InvoiceEntity getInvoiceEntity() {
        return invoiceEntity;
    }

    public void setInvoiceEntity(InvoiceEntity invoiceEntity) {
        this.invoiceEntity = invoiceEntity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
