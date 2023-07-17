package hr.apisit.java.repository;

import hr.apisit.java.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileCinemaRepository implements CrudRepository<Cinema, Long> {

    public static final Integer NUMBER_OF_CINEMA_ROWS = 8;

    private CrudRepository fileProjectionRepository;
    private FileStageRepository fileStageRepository;

    public FileCinemaRepository() {
        //this.fileProjectionRepository = new FileProjectionRepository();
        AbstractCinemaRepositoryFactory cinemaFactory = CinemaRepositoryProvider.getFactory(HallFactory.PROJECTION_FACTORY);
        this.fileProjectionRepository = cinemaFactory.createRepository();
        this.fileStageRepository = new FileStageRepository();
    }

    @Override
    public List<Cinema> readAll() throws IOException {
        List<Cinema> cinemaList = new ArrayList<>();

        Path stageFilePath = Path.of("dat/cinemas.txt");

        List<String> lines = Files.readAllLines(stageFilePath);

        for(int i = 0; i < lines.size()/NUMBER_OF_CINEMA_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_CINEMA_ROWS);
            Long id = Long.parseLong(idString);
            String cinemaName = lines.get(i * NUMBER_OF_CINEMA_ROWS + 1);
            String cinemaStreet = lines.get(i * NUMBER_OF_CINEMA_ROWS + 2);
            String cinemaHouseNumber = lines.get(i * NUMBER_OF_CINEMA_ROWS + 3);
            String cinemaPostalCode = lines.get(i * NUMBER_OF_CINEMA_ROWS + 4);
            String cinemaCity = lines.get(i * NUMBER_OF_CINEMA_ROWS + 5);
            String projectionsGroup = lines.get(i * NUMBER_OF_CINEMA_ROWS + 6);
            String[] projectionsIds = projectionsGroup.split("\\s+");



            List<Projection> projectionList = new ArrayList<>();

            for(String projectionIdString : projectionsIds) {
                Long projectionId = Long.parseLong(projectionIdString);
                if(fileProjectionRepository.readById(projectionId) instanceof Projection p) {
                    projectionList.add(p);
                }
            }

            String stagesGroup = lines.get(i * NUMBER_OF_CINEMA_ROWS + 7);
            String[] stagesIds = stagesGroup.split("\\s+");

            List<Stage> stagesList = new ArrayList<>();

            for(String stagesIdString : stagesIds) {
                Long stageId = Long.parseLong(stagesIdString);
                Stage stage = fileStageRepository.readById(stageId);
                stagesList.add(stage);
            }

            cinemaList.add(new Cinema(id, cinemaName,
                    new Address(cinemaStreet, cinemaHouseNumber, Integer.parseInt(cinemaPostalCode),
                            City.valueOf(cinemaCity)),
                    projectionList, stagesList));
        }

        return cinemaList;
    }
}
