package org.saucedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;


public class BasePage {
    public void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            System.out.println(" Waiting ...");
        }
    }

    public static HashMap<String, Float>
    sortByValue(HashMap<String, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Float> > list
                = new LinkedList<Map.Entry<String, Float> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Float> temp
                = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        //System.out.println(temp);
        return temp;
    }

}
