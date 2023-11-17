package multitheard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class Bety {

    public static void main(String[] args) {
        Pet<List<String>> pets = new Pet<>();
        pets.collection = new ArrayList<>();
        pets.collection.add("DOG");
        System.out.println(pets.collection.toString());
    }
}

    class Pet<T extends Collection>{
        T collection;
    }




