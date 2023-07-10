package hr.apisit.java.thread;

import hr.apisit.java.domain.Cinema;
import hr.apisit.java.repository.FileCinemaRepository;
import hr.apisit.java.repository.FileProjectionRepository;

import java.io.IOException;
import java.util.List;

public class ProjectionCounterThread implements Runnable {

    private FileCinemaRepository repo;

    public ProjectionCounterThread(FileCinemaRepository repo) {
        this.repo = repo;
    }
    @Override
    public void run() {

        while(true) {
            try {
                List<Cinema> cinemaList = repo.readAll();

                cinemaList.stream()
                        .forEach(c -> System.out.println(c.getName()
                                + ":" + c.getProjectionList().size()));

                Thread.sleep(5000);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
