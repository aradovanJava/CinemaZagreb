package hr.apisit.java.repository;

import java.io.IOException;
import java.util.List;

public class CinemaRepositoryFactory {
    private CinemaRepositoryFactory() {

    }

    public static CrudRepository create(CinemaRepositoryType type) {
        return switch(type) {
            case CINEMA_REPOSITORY_TYPE -> new FileCinemaRepository();
            case PROJECTION_REPOSITORY_TYPE -> new FileProjectionRepository();
            case SEAT_REPOSITORY_TYPE -> new FileSeatRepository();
            case STAGE_REPOSITORY_TYPE -> new FileStageRepository();
            default -> throw new IllegalArgumentException("Wrong type " + type);
        };
    }

}
