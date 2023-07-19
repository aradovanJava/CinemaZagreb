package hr.apisit.java.domain;

import java.util.ArrayList;
import java.util.List;

public class CinemaTicketRegister {

    private List<Seat> soldSeats;
    private List<Ticket> ticketsList;
    private List<Seat> availableSeats;

    public CinemaTicketRegister(List<Ticket> ticketsList, List<Seat> soldSeats, List<Seat> availableSeats) {
        this.ticketsList = ticketsList;
        this.soldSeats = soldSeats;
        this.availableSeats = availableSeats;
    }

    public List<Seat> getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(List<Seat> soldSeats) {
        this.soldSeats = soldSeats;
    }

    public List<Ticket> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(List<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void updateTickets() {
        ticketsList.stream()
                .map(t -> t.getPurchasedSeat())
                .forEach(s -> {
                    soldSeats.add(s);
                    availableSeats.remove(s);
                });
    }
}
