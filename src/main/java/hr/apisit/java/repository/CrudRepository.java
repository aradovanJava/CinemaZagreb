package hr.apisit.java.repository;

import hr.apisit.java.domain.BaseEntity;
import hr.apisit.java.domain.Seat;
import hr.apisit.java.domain.Ticket;

import java.io.IOException;
import java.util.List;

public interface CrudRepository<T extends BaseEntity, ID> {

    List<T> readAll() throws IOException;

    default T readById(ID id) throws IOException {
        return readAll().stream()
                .filter(object -> object.getId().equals(id))
                .findFirst()
                .get();
    }
}
