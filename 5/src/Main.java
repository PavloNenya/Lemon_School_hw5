import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //String[] arr = args;
        String[] arr = {"A", "B", "C", "D","E", "B", "F","C","A","A","D","B","D","B","D","B","D"};
        // A = 3
        // B = 5
        // C = 2
        // D = 4
        // E = 1
        // F = 1
        mostFrequentWord(arr);
        numberOfSameWords(arr);
        numberOfSameWords(arr, "B");
        System.out.println(lastWord(arr));
        System.out.println(firstWord(arr));
    }

    public static String mostFrequentWord(String[] arr) {
        int localCounter;
        int finalCounter = 0;
        String word = "";

        for(int i = 0; i < arr.length - 1; i++) {
            localCounter = 1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i].equals(arr[j])) {
                    localCounter++;
                }
            }
            if(localCounter > finalCounter) {
                finalCounter = localCounter;
                word = arr[i];
            }
        }
        System.out.println("Most frequent word: " + word + "\n" + finalCounter + " times");
        return word;
    }

    public static int numberOfSameWords(String[] arr, String word) {
        int count = 0;
        for(String element: arr) {
            if(element.equals(word)) count++;
        }
        System.out.println("Number of same words: " + word + " " + count);
        return count;
    }

    public static int numberOfSameWords(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String word: arr) {
            if(map.containsKey(word)) map.replace(word, map.get(word)+1);
            else map.put(word, 1);
        }

        map.values().removeAll(Collections.singleton(1));
        System.out.println("Number of words that repeat more than once: ");
        System.out.println(map);
        return count;
    }

     public static String lastWord(String[] arr) {
        return arr[arr.length-1];
     }

    public static String firstWord(String[] arr) {
        return arr[0];
    }
}
