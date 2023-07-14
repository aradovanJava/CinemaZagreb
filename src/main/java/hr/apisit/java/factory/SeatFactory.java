package hr.apisit.java.factory;

import hr.apisit.java.repository.AbstractCinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryType;
import hr.apisit.java.repository.CrudRepository;

public class SeatFactory extends AbstractCinemaRepositoryFactory {
    @Override
    public CrudRepository createRepository() {
        return CinemaRepositoryFactory.create(CinemaRepositoryType.SEAT_REPOSITORY_TYPE);
    }
}
