package hr.apisit.java.repository;

import hr.apisit.java.domain.Projection;
import hr.apisit.java.domain.Seat;
import hr.apisit.java.domain.Stage;
import hr.apisit.java.util.LocalDateUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileProjectionRepository implements CrudRepository<Projection, Long> {

    private static final Integer NUMBER_OF_PROJECTION_ROWS = 4;

    private final FileStageRepository fileStageRepository;

    public FileProjectionRepository() {
        fileStageRepository = new FileStageRepository();
    }

    @Override
    public List<Projection> readAll() throws IOException {
        List<Projection> projectionList = new ArrayList<>();

        Path projectionFilePath = Path.of("dat/projections.txt");

        List<String> lines = Files.readAllLines(projectionFilePath);

        for(int i = 0; i < lines.size()/NUMBER_OF_PROJECTION_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_PROJECTION_ROWS);
            Long id = Long.parseLong(idString);
            String projectionName = lines.get(i * NUMBER_OF_PROJECTION_ROWS + 1);
            String projectionDateAndTimeString = lines.get(i * NUMBER_OF_PROJECTION_ROWS + 2);
            LocalDateTime projectionDateAndTime =
                    LocalDateUtils.convertStringToLocalDateTime(
                            projectionDateAndTimeString);
            String stageIdString = lines.get(i * NUMBER_OF_PROJECTION_ROWS + 3);
            Long stageId = Long.parseLong(stageIdString);

            Stage projectStage = fileStageRepository.readById(stageId);

            projectionList.add(
                    new Projection(id, projectionName, projectionDateAndTime, projectStage)
            );
        }

        return projectionList;
    }
}
