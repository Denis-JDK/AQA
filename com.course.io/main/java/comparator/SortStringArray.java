package comparator;

import java.util.*;

public class SortStringArray {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        listString.add("lirst");
        listString.add("airstLenght");
        listString.add("birstarray");
        listString.add("cirstE");
        listString.add("jir");
        listString.add("ai");

        Collections.sort(listString, new Comparator<String>()//new SortListString()
                 {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                }else if (o1.length()<o2.length()){
                    return -1;
                } else
                return 0;
            }
        }
        );

        System.out.println(listString);

    }




}
class SortListString implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {

        if (o1.length()>o2.length()){
            return 1;
        }else if (o1.length()<o2.length()){
            return -1;
        } else
            return 0;
    }
}