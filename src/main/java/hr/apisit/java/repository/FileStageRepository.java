package hr.apisit.java.repository;

import hr.apisit.java.domain.Seat;
import hr.apisit.java.domain.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStageRepository implements CrudRepository<Stage, Long> {
    private static final Integer NUMBER_OF_STAGE_ROWS = 3;

    private final FileSeatRepository fileSeatRepository;

    public FileStageRepository() {
        fileSeatRepository = new FileSeatRepository();
    }
    @Override
    public List<Stage> readAll() throws IOException {
        List<Stage> stageList = new ArrayList<>();

        Path stageFilePath = Path.of("dat/stages.txt");

        List<String> lines = Files.readAllLines(stageFilePath);

        for(int i = 0; i < lines.size()/NUMBER_OF_STAGE_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_STAGE_ROWS);
            Long id = Long.parseLong(idString);
            String stageName = lines.get(i * NUMBER_OF_STAGE_ROWS + 1);
            String seatsGroup = lines.get(i * NUMBER_OF_STAGE_ROWS + 2);
            String[] seatsIds = seatsGroup.split("\\s+");

            List<Seat> seatList = new ArrayList<>();

            for(String seatIdString : seatsIds) {
                Long seatId = Long.parseLong(seatIdString);
                Seat seat = fileSeatRepository.readById(seatId);
                seatList.add(seat);
            }

            Stage newStage = new Stage(id, stageName, seatList);
            stageList.add(newStage);
        }

        return stageList;
    }
}
