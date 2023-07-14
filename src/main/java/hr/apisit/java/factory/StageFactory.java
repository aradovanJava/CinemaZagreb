package hr.apisit.java.factory;

import hr.apisit.java.repository.AbstractCinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryType;
import hr.apisit.java.repository.CrudRepository;

public class StageFactory extends AbstractCinemaRepositoryFactory {
    @Override
    public CrudRepository createRepository() {
        return CinemaRepositoryFactory.create(CinemaRepositoryType.STAGE_REPOSITORY_TYPE);
    }
}
