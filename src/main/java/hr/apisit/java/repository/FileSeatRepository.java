package hr.apisit.java.repository;

import hr.apisit.java.domain.Seat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class  FileSeatRepository implements CrudRepository<Seat, Long> {

    private static final Integer NUMBER_OF_SEAT_ROWS = 3;

    @Override
    public List<Seat> readAll() throws IOException {

        List<Seat> seatList = new ArrayList<>();
        Path seatsFilePath = Path.of("dat/seats.txt");

        List<String> lines = Files.readAllLines(seatsFilePath);

        for(int i = 0; i < lines.size()/NUMBER_OF_SEAT_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_SEAT_ROWS);
            Long id = Long.parseLong(idString);
            String rowName = lines.get(i * NUMBER_OF_SEAT_ROWS + 1);
            Integer rowPosition = Integer.parseInt(lines.get(i * NUMBER_OF_SEAT_ROWS + 2));
            Seat newSeat = new Seat(id, rowName, rowPosition);
            seatList.add(newSeat);
        }

        return seatList;
    }

    @Override
    public Seat readById(Long id) throws IOException {
        return readAll().stream()
                .filter(seat -> seat.getId().equals(id))
                .findFirst()
                .get();
    }
}
