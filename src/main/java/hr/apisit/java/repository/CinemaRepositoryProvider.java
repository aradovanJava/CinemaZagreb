package hr.apisit.java.repository;

import hr.apisit.java.factory.CinemaFactory;
import hr.apisit.java.factory.ProjectionFactory;
import hr.apisit.java.factory.SeatFactory;
import hr.apisit.java.factory.StageFactory;

public final class CinemaRepositoryProvider {

    private CinemaRepositoryProvider() {

    }
    public static AbstractCinemaRepositoryFactory getFactory(HallFactory factory) {
        return switch(factory) {
            case CINEMA_FACTORY -> new CinemaFactory();
            case PROJECTION_FACTORY -> new ProjectionFactory();
            case SEAT_FACTORY -> new SeatFactory();
            case STAGE_FACTORY -> new StageFactory();
            default -> throw new IllegalArgumentException("Wrong type " + factory);
        };
    }

}
