package hr.apisit.java.sorter;

import hr.apisit.java.domain.Seat;

import java.util.Comparator;

public class SeatSorter implements Comparator<Seat> {
    @Override
    public int compare(Seat s1, Seat s2) {
        if(s1.getPositionInRow().compareTo(s2.getPositionInRow()) != 0) {
            return s2.getPositionInRow().compareTo(s1.getPositionInRow());
        }
        else {
            return s1.getRowName().compareTo(s2.getRowName());
        }
    }
}
