package hr.apisit.java.domain;

import java.util.ArrayList;
import java.util.List;

public class CinemaTicketRegister {

    private List<Seat> soldSeats;
    private List<Ticket> ticketsList;
    private List<Seat> availableSeats;

    public CinemaTicketRegister() {
        this.soldSeats = new ArrayList<>();
    }

    public List<Seat> getSoldSeats() {
        return soldSeats;
    }

    public void updateTickets() {
        //prođi krod sve tickete
        //prebaci prodana sjedala iz slobodnih u prodane
    }
}
