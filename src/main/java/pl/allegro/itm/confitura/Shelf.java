package pl.allegro.itm.confitura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
    
}
