package hr.apisit.java.sorter;

import hr.apisit.java.domain.Projection;

import java.util.Comparator;

public class CinemaSorter implements Comparator<Projection> {

    public CinemaSorter() {

    }
    @Override
    public int compare(Projection p1, Projection p2) {
        int sortResult = 0;

        sortResult = p1.getName().compareTo(p2.getName());

        if(sortResult == 0) {
            sortResult = p1.getDateTime().compareTo(p2.getDateTime());
        }

        return sortResult;
    }
}
