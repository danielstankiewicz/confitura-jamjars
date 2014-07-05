package pl.allegro.itm.confitura;

import java.util.List;
import java.util.stream.Stream;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.partition;
import static java.util.Comparator.comparing;

public class JamJars {

    public List<JarBox> giveMeMyJars(List<Shelf> shelves, int jarsInBox) {
        Stream<Jar> sorted = shelves.stream()
                .flatMap(Shelf::getJarsStream)
                .filter(Jar::isFresh)
                .sorted(comparing(Jar::flavor).reversed());
        return from(partition((Iterable<Jar>) sorted::iterator, jarsInBox)).transform(
                JarBox::new).toList();
    }

}
