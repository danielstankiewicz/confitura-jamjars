package pl.allegro.itm.confitura;

import java.util.*;
import java.util.stream.Stream;

public class Shelf implements Iterable<Jar> {

    private final List<Jar> jars = new ArrayList<>(); 
    
    public Shelf(Jar... jars) {
        this.jars.addAll(Arrays.asList(jars));
    }
    
    public Shelf(Collection<Jar> jars) {
        this.jars.addAll(jars);
    }
    
    @Override
    public Iterator<Jar> iterator() {
        return Collections.unmodifiableCollection(jars).iterator();
    }

    public Stream<Jar> getJarsStream() {
        return jars.stream();
    }
    
}
