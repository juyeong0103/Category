package exam0613;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class exam1005 {

    public static void main(String[] args) {

        Color red1 = Color.RED;
        Color red2 = Color.RED;
        Color blue = Color.BLUE;
        System.out.println(red1);
        System.out.println(red1 == red2);
        System.out.println(red1.equals(red2));
        System.out.println();

        Map<String, Color> map = new HashMap<>();
        map.put("손흥민", red1);
        map.put("황희찬", blue);
        map.put("김민재", blue);
        Set<String> keys = map.keySet();
        for (String key : keys)
            System.out.println(key + " " + map.get(key));
        System.out.println();

        Color blue2 = new Color(0, 0, 255);
        System.out.println(blue == blue2);
        System.out.println(blue.equals(blue2));
        System.out.println();

        map.put("김민재", blue2);
        keys = map.keySet();
        for (String key : keys)
            System.out.println(key + " " + map.get(key));
        System.out.println();
    	
    	
    	
    	
    	
    	
    	
    	
    	

    }
}
