import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class kent
{
    public static void main(String[] args) throws FileNotFoundException {
        //Reading file dog.txt where poem is pasted
        File file = new File("/Users/Rigel Kent/Desktop/dog.txt");
        Scanner scan = new Scanner(file);
       //Map string to integer
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String val = scan.next(); 
            if(map.containsKey(val) == false) // if string is not in the map yet then insert by setting to 1
                map.put(val,1);
            else // otherwise remove and add 1
            {
                int count = (int)(map.get(val)); // current count of word
                map.remove(val);  // remove
                map.put(val,count+1); // put back and add 1
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet(); // retrieving the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); //array list 
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() //sort array 
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) //compare
            {
                return (b.getValue()).compareTo( a.getValue() ); // order
              
            }
        } );
        //display list
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}