package hr.apisit.java.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket extends BaseEntity {

    private Projection projection;
    private LocalDateTime purchaseDateAndTime;
    private BigDecimal price;
    private Seat purchasedSeat;

    public Ticket(Long id, Projection projection,
                  LocalDateTime purchaseDateAndTime,
                  BigDecimal price,
                  Seat purchasedSeat)
    {
        super(id);
        this.projection = projection;
        this.purchaseDateAndTime = purchaseDateAndTime;
        this.price = price;
        this.purchasedSeat = purchasedSeat;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public LocalDateTime getPurchaseDateAndTime() {
        return purchaseDateAndTime;
    }

    public void setPurchaseDateAndTime(LocalDateTime purchaseDateAndTime) {
        this.purchaseDateAndTime = purchaseDateAndTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Seat getPurchasedSeat() {
        return purchasedSeat;
    }

    public void setPurchasedSeat(Seat purchasedSeat) {
        this.purchasedSeat = purchasedSeat;
    }
}
