package menu.commands.exercise.alexstreamapi;

import java.util.HashMap;
import java.util.List;

@FunctionalInterface
public interface PrintFromMap<T, K >{
    void print(HashMap <K, List<T>> map);
}
