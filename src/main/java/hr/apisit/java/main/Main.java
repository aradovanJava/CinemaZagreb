package hr.apisit.java.main;

import hr.apisit.java.domain.*;
import hr.apisit.java.util.LocalDateUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    /**Služi zua upis brojeva
     * Metoda prima tip podatka koji očekuje,
     * Scanner objekt te poruku prije unosa i
     * poruku kada se pojavi greška unosa(Unese se krivi tip podatka)
     *
     * @param numberType Klasa kojeg tipa je traženi unos (npr. Integer.class)
     * @param data Scanner objekt za unos brojeva
     * @param inputMessage Poruka koja se ispisuje prije unosa podatka
     * @param errorMessage Poruka koja se ispisuje pri greški unosa
     *
     * @return Uneseni broj ukoliko je varijabla istog tipa kao zapisani traženi tip
     *
     * @param <T> Klasa čiji objekt se očekuje, a koja nasljeđuje Number klasu, npr. Integer, Long, Double, itd.
     */
    protected static <T extends Number> T checkNumericInput(Class<T> numberType, Scanner data, String inputMessage, String errorMessage)
    {
        while (true)
        {
            try {
                System.out.print(inputMessage);

                if (numberType.equals(Integer.class)) {
                    T number = numberType.cast(data.nextInt());
                    data.nextLine();
                    return number;
                }
                else if (numberType.equals(Long.class)) {
                    T number = numberType.cast(data.nextLong());
                    data.nextLine();
                    return number;
                }
                else if (numberType.equals(Float.class)) {
                    T number = numberType.cast(data.nextFloat());
                    data.nextLine();
                    return number;
                }
                else if (numberType.equals(Double.class)) {
                    T number = numberType.cast(data.nextDouble());
                    data.nextLine();
                    return number;
                }
                else if (numberType.equals(Byte.class)) {
                    T number = numberType.cast(data.nextByte());
                    data.nextLine();
                    return number;
                }
                else if (numberType.equals(Short.class)) {
                    T number = numberType.cast(data.nextShort());
                    data.nextLine();
                    return number;
                }
                else if(numberType.equals(BigDecimal.class)) {
                    T number = numberType.cast(data.nextBigDecimal());
                    data.nextLine();
                    return number;
                }
            }
            catch (InputMismatchException ex)
            {
                System.out.println(errorMessage);
                data.nextLine();
            }
        }
    }

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
            postalCode = checkNumericInput(Integer.class, dataInput,
                    "Unesite poštanski broj mjesta gdje se kino nalazi:",
                    "Unijeli ste neispravan poštanski broj, molimo pokušajte ponovno!");

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

    private static List<Cinema> enterCinemas(Scanner dataInput) {
        List<Cinema> cinemaList = new ArrayList<>();
        Integer numberOfCinemas = checkNumericInput(Integer.class, dataInput,
                "Unesite broj kina koja želite unijeti: ",
                "Unijeli ste neispravan broj, molimo pokušajte ponovno!");

        for(int i = 1; i <= numberOfCinemas; i++) {
            Integer cinemaId = checkNumericInput(Integer.class, dataInput,
                    "Unesite identifikator " + i + ". kina: ",
                    "Unijeli ste neispravni identifikator " + i + ". kina: ");
            System.out.print("Unesite naziv " + i + ". kina: ");
            String cinemaName = dataInput.nextLine();
            Address cinemaAddres = enterAddress(dataInput);

            List<Projection> projectionList = enterProjections(dataInput);



        }

        return cinemaList;
    }

    private static List<Projection> enterProjections(Scanner dataInput) {

        Integer numberOfProjections = checkNumericInput(Integer.class, dataInput,
                "Unesite broj projekcija koje želite prikazivati u kinu: ",
                "Unijeli ste neispravan broj projekcija, molimo pokušajte ponovno!");

        List<Projection> projectionList = new ArrayList<>();

        for(int projectionsCount = 1; projectionsCount <= numberOfProjections; projectionsCount++) {
            Integer projectionId = checkNumericInput(Integer.class, dataInput,
                    "Unesite identifikator " + projectionsCount + " projekcije: ",
                    "Unijeli ste neispravan identifikator projekcija, molimo pokušajte ponovno!");

            System.out.print("Unesite naziv " + projectionsCount + " projekcije: ");
            String projectionName = dataInput.nextLine();

            LocalDateTime dateTime = LocalDateUtils.enterLocalDateTime(dataInput,
                    "Unesite datum i vrijeme održavanja " + projectionsCount + " projekcije u formatu '"
                                   + LocalDateUtils.DEFAULT_DATE_FORMAT + "':",
                                "Unijeli ste neispravan format datuma, mora biti u formatu "
                                + LocalDateUtils.DEFAULT_DATE_FORMAT + "'");

            List<Seat> seats = enterSeats(dataInput);
        }

        return projectionList;
    }

    private static List<Seat> enterSeats(Scanner dataInput) {
        return new ArrayList<>();
    }
}