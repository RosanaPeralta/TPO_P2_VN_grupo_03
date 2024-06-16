package org.example.util;

import org.example.model.definition.Set;
import org.example.model.normal.StaticSet;

public class SetUtil {
    public static Set copy(Set set) {
        Set aux = new StaticSet();
        Set aux2 = new StaticSet();

        while(!set.isEmpty()) {
            int n = set.choose();
            aux.add(n);
            aux2.add(n);
            set.remove(n);
        }

        while(!aux.isEmpty()) {
            int n = aux.choose();
            set.add(n);
            aux.remove(n);
        }
        return aux2;

    }

    public static void printSet(Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int n = copy.choose();
            System.out.println(n);
            copy.remove(n);
        }
    }
}
