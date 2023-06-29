package hr.apisit.java.repository;

import hr.apisit.java.domain.Seat;

import java.io.IOException;
import java.util.List;

public interface CrudRepository<T, ID> {

    List<T> readAll() throws IOException;

    T readById(ID id) throws IOException;
}
