package hr.apisit.java.repository;

import hr.apisit.java.domain.Projection;
import hr.apisit.java.domain.Seat;
import hr.apisit.java.domain.Ticket;
import hr.apisit.java.util.LocalDateUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileTicketRepository implements CrudRepository<Ticket, Long> {

    private static final Integer NUMBER_OF_TICKETS_ROWS = 5;

    private CrudRepository<Projection, Long> projectionRepository;

    private CrudRepository<Seat, Long> seatRepository;

    public FileTicketRepository() {
        projectionRepository = new FileProjectionRepository();
        seatRepository = new FileSeatRepository();
    }

    @Override
    public List<Ticket> readAll() throws IOException {
        List<Ticket> ticketList = new ArrayList<>();

        Path ticketsFilePath = Path.of("dat/tickets.txt");

        List<String> lines = Files.readAllLines(ticketsFilePath);

        for(int i = 0; i < lines.size()/NUMBER_OF_TICKETS_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_TICKETS_ROWS);
            Long id = Long.parseLong(idString);
            String projectionId = lines.get(i * NUMBER_OF_TICKETS_ROWS + 1);
            Projection projection = projectionRepository.readById(Long.parseLong(projectionId));
            String purchaseDateAndTimeString = lines.get(i * NUMBER_OF_TICKETS_ROWS + 2);
            LocalDateTime purchaseDateAndTime =
                    LocalDateUtils.convertStringToLocalDateTime(
                            purchaseDateAndTimeString);
            String priceString = lines.get(i * NUMBER_OF_TICKETS_ROWS + 3);
            BigDecimal price = new BigDecimal(priceString);
            String seatIdString = lines.get(i * NUMBER_OF_TICKETS_ROWS + 4);
            Long seatId = Long.parseLong(seatIdString);

            Seat purchasedSeat = seatRepository.readById(seatId);

            ticketList.add(
                    new Ticket(id, projection, purchaseDateAndTime, price, purchasedSeat)
            );
        }

        return ticketList;
    }

}
