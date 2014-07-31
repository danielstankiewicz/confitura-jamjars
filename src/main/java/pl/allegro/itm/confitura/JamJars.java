package pl.allegro.itm.confitura;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.partition;
import static java.util.Comparator.comparing;

public class JamJars {

    public List<JarBox> giveMeMyJars(List<Shelf> shelves, int jarsInBox) {
        return from(partition(from(shelves)
                .transformAndConcat(shelf -> shelf::iterator)
                .filter(Jar::isFresh)
                .toSortedList(comparing(Jar::flavor).reversed()), jarsInBox))
                .transform(JarBox::new)
                .toList();
    }

}
