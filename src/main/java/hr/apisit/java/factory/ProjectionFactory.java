package hr.apisit.java.factory;

import hr.apisit.java.repository.AbstractCinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryFactory;
import hr.apisit.java.repository.CinemaRepositoryType;
import hr.apisit.java.repository.CrudRepository;

public class ProjectionFactory extends AbstractCinemaRepositoryFactory {
    @Override
    public CrudRepository createRepository() {
        return CinemaRepositoryFactory.create(CinemaRepositoryType.PROJECTION_REPOSITORY_TYPE);
    }
}
