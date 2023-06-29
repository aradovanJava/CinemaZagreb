package hr.apisit.java.main;

import hr.apisit.java.domain.Cinema;
import hr.apisit.java.domain.Projection;
import hr.apisit.java.repository.FileCinemaRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
        Scanner dataInput = new Scanner(System.in);
        System.out.println("Dobro došli u Cinema Planet sustav.");

        FileCinemaRepository fileCinemaRepository = new FileCinemaRepository();
        try {
            List<Cinema> cinemaList = fileCinemaRepository.readAll();
            Cinema chosenCinema = selectFromList(cinemaList, dataInput);
            Projection chosenProjection = selectFromList(chosenCinema.getProjectionList(), dataInput);
            System.out.println("Chosen projection: " + chosenProjection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
