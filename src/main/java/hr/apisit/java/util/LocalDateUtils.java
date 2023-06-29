package hr.apisit.java.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class LocalDateUtils {
    public static final String DEFAULT_DATE_FORMAT = "dd.MM.yyyy. HH:mm";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

    public static LocalDateTime convertStringToLocalDateTime(String localDateTimeString) {
        return LocalDateTime.parse(localDateTimeString, formatter);
    }

    public static LocalDateTime enterLocalDateTime(Scanner inputData,
                                                   String inputMessage,
                                                   String errorMessage) {
        Optional<LocalDateTime> dateTime = Optional.empty();
        Boolean dateTimeValid = false;

        do {
            System.out.print(inputMessage);
            String dateAndTimeString = inputData.nextLine();

            try {
                dateTime = Optional.of(LocalDateTime.parse(dateAndTimeString, formatter));
                dateTimeValid = true;
            } catch (DateTimeParseException ex) {
                System.out.println(errorMessage);
            }
        }
        while(!dateTimeValid);

        return dateTime.get();
    }
}