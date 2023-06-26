package hr.apisit.java.main;

import hr.apisit.java.domain.Address;
import hr.apisit.java.domain.Cinema;
import hr.apisit.java.domain.City;
import hr.apisit.java.domain.Projection;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataInput = new Scanner(System.in);
        List<Cinema> cinemaList = enterCinemas(dataInput);
        dataInput.close();
    }

    private static List<Projection> enterProjections(Scanner dataInput) {
        return null;
    }

    //https://codereview.stackexchange.com/questions/262817/generic-scannersystem-in-parsing
    private static Address enterAddress(Scanner dataInput) {
        Boolean wrongInput = true;
        String cinemaStreet = "";
        String cinemaHouseNumber = "";
        Integer postalCode = 0;
        City chosenCity = null;

        while(wrongInput) {
            System.out.print("Unesite ulicu kina: ");
            cinemaStreet = dataInput.nextLine();
            System.out.print("Unesite kućni broj kina: ");
            cinemaHouseNumber = dataInput.nextLine();
            Integer initialValue = 0;
            postalCode = checkIntegerInput(dataInput,
                    "Unesite poštanski broj mjesta gdje se kino nalazi:",
                    "Unijeli ste neispravan poštanski broj, molimo pokušajte ponovno!");
            dataInput.nextLine();
            Integer chosenCityNumber = 0;
            Boolean wrongCityOrdinal = false;
            do {
                System.out.println("Odaberite grad u kojem se kino nalazi: ");

                Integer counter = 1;

                for (City city : City.values()) {
                    System.out.println(counter + ") " + city.getCityName());
                    counter++;
                }

                System.out.print("Odaberite grad: ");
                chosenCityNumber = dataInput.nextInt();
                dataInput.nextLine();

                wrongCityOrdinal = chosenCityNumber < 1 || chosenCityNumber > City.values().length;

                if(wrongCityOrdinal) {
                    System.out.println("Unijeli ste neispravni redni broj grada! Molimo ponovite unos.");
                }
            }
            while(wrongCityOrdinal);

            chosenCity = City.values()[chosenCityNumber - 1];

            wrongInput = false;
        }

        return new Address(cinemaStreet, cinemaHouseNumber, postalCode, chosenCity);
    }



    private static Integer checkIntegerInput(Scanner dataInput, String inputMessage,
                                             String errorMessage) {
        Boolean wrongInput = true;
        Integer integerInput = 0;

        while(wrongInput) {

            System.out.print(inputMessage);

            try {
                integerInput = dataInput.nextInt();
                wrongInput = false;
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
                dataInput.nextLine();
            }
        }

        return integerInput;
    }

    private static Long checkLongInput(Scanner dataInput, String inputMessage,
                                             String errorMessage) {
        Boolean wrongInput = true;
        Long longInput = 0l;

        while(wrongInput) {

            System.out.print(inputMessage);

            try {
                longInput = dataInput.nextLong();
                wrongInput = false;
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
                dataInput.nextLine();
            }
        }

        return longInput;
    }

    private static List<Cinema> enterCinemas(Scanner dataInput) {
        List<Cinema> cinemaList = new ArrayList<>();
        Integer numberOfCinemas = checkIntegerInput(dataInput,
                "Unesite broj kina koja želite unijeti: ",
                "Unijeli ste neispravan broj, molimo pokušajte ponovno!");

        for(int i = 1; i <= numberOfCinemas; i++) {
            Integer cinemaId = checkIntegerInput(dataInput,
                    "Unesite identifikator " + i + ". kina: ",
                    "Unijeli ste neispravni identifikator " + i + ". kina: ");
            dataInput.nextLine();
            System.out.print("Unesite naziv" + i + ". kina: ");
            String cinemaName = dataInput.nextLine();
            Address cinemaAddres = enterAddress(dataInput);
        }

        return cinemaList;
    }
}