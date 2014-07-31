package pl.allegro.itm.confitura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

import static java.util.Comparator.comparing;
import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.toList;

public class JamJars {

    public List<JarBox> giveMeMyJars(List<Shelf> shelves, int jarsInBox) {
        BiConsumer<LinkedList<List<Jar>>, Jar> accumulator = (lists, jar) -> {
            if (lists.isEmpty() || lists.getLast().size() == jarsInBox) {
                lists.add(new ArrayList<>());
            }
            lists.getLast().add(jar);
        };
        BinaryOperator<LinkedList<List<Jar>>> combiner = (lists1, lists2) -> {
            throw new UnsupportedOperationException("Combine not supported");
        };

        return shelves.stream()
                .flatMap(Shelf::getJarStream)
                .filter(Jar::isFresh)
                .sorted(comparing(Jar::flavor).reversed())
                .collect(of(LinkedList::new, accumulator, combiner))
                .stream()
                .map(JarBox::new)
                .collect(toList());
    }
}
