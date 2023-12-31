package hr.apisit.java.main;

import hr.apisit.java.domain.*;
import hr.apisit.java.repository.*;
import hr.apisit.java.sorter.CinemaSorter;
import hr.apisit.java.thread.ProjectionCounterThread;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileMain {

    private static <T> T selectFromList(List<T> inputList, Scanner dataInput) {

        Integer indeks = 0;

        Boolean wrongInput = true;

        do {
            System.out.println("Unesite Vaš odabir:");

            for (int i = 0; i < inputList.size(); i++) {
                System.out.println((i + 1) + ") " + inputList.get(i));
            }

            indeks = Main.checkNumericInput(Integer.class, dataInput,
                    "Odabir > ",
                    "Unijeli ste neispravan format broja!");

            if(indeks >= 1 && indeks <= inputList.size()) {
                wrongInput = false;
            }
            else {
                System.out.println("Unijeli ste neispravan odabir, molimo pokušajte ponovno!");
            }
        }
        while(wrongInput);

        return inputList.get(indeks - 1);
    }

    public static void main(String[] args) {

        //ProjectionCounterThread thread = new ProjectionCounterThread(new FileCinemaRepository());
        //new Thread(thread).start();

        Scanner dataInput = new Scanner(System.in);
        System.out.println("Dobro došli u Cinema Planet sustav.");

        //FileCinemaRepository fileCinemaRepository = new FileCinemaRepository();
        CrudRepository fileCinemaRepository = CinemaRepositoryFactory.create(CinemaRepositoryType.CINEMA_REPOSITORY_TYPE);
        CrudRepository fileSeatRepository = CinemaRepositoryFactory.create(CinemaRepositoryType.SEAT_REPOSITORY_TYPE);
        try {

            List<Cinema> cinemaList = fileCinemaRepository.readAll();

            FileProjectionRepository fileProjectionRepository = new FileProjectionRepository();
            List<Projection> projectionList = fileProjectionRepository.readAll();

            FileTicketRepository fileTicketRepository = new FileTicketRepository();
            List<Ticket> ticketList = fileTicketRepository.readAll();
            List<Seat> availableSeatList = fileSeatRepository.readAll();
            CinemaTicketRegister cinemaTicketRegister = new CinemaTicketRegister(
                    ticketList, new ArrayList<>(), availableSeatList);

            cinemaTicketRegister.updateTickets();

            //cinemaList.get(0).getProjectionList().stream().sorted(new CinemaSorter()).collect(Collectors.toList());

            System.out.println("Ovo su prazna sjedala po kino projekcijama: ");
            Map<Projection, List<Seat>> seatReport = generateSeatReport(cinemaList);

            for(Projection projection : seatReport.keySet()) {
                System.out.println("Projection: " + projection.getName());
                System.out.println("Seats:");
                for(Seat seat : seatReport.get(projection)) {
                    System.out.print("Seat: " + seat.getRowName() + " " + seat.getPositionInRow() + "\n");
                }
            }

            Cinema chosenCinema = selectFromList(cinemaList, dataInput);
            Projection chosenProjection = selectFromList(chosenCinema.getProjectionList(), dataInput);
            System.out.println("Chosen projection: " + chosenProjection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Projection, List<Seat>> generateSeatReport(List<Cinema> cinemaList) {
        Map<Projection, List<Seat>> seatReport = new TreeMap<>(new CinemaSorter());

        for(Cinema cinema : cinemaList) {
            for(Projection projection : cinema.getProjectionList()) {
                seatReport.put(projection, new ArrayList<>());
                Stage projectionStage = projection.getStage();
                List<Seat> seatList = projectionStage.getSeatList();
                seatReport.get(projection).addAll(seatList);
            }
        }

        return seatReport;
    }

}
