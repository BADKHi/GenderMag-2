import java.io.*;
import java.util.*;
public class test2 {

   
static int x = -1;
 

static String []heap = new String[1000];
 
static void heapForm(String k) {
    x++;
 
    heap[x] = k;
 
    int child = x;
 
    String tmp;
 
    int index = x / 2;
 
    while (index >= 0) {
 
        if (heap[index].compareTo(heap[child]) > 0)
        {
 
            // Swapping the current index
            // with its child
            tmp = heap[index];
            heap[index] = heap[child];
            heap[child] = tmp;
            child = index;
 
            // Moving upward in the
            // heap
            index = index / 2;
        }
        else
        {
            break;
        }
    }
}
 
//heap sort
static void heapSort() {
    int left1, right1;
 
    while (x >= 0)
    {
        String k;
        k = heap[0];
 
        // Taking output of
        // the minimum element
        System.out.print(k + " ");
 
        // Set first element
        // as a last one
        heap[0] = heap[x];
 
        // Decrement of the
        // size of the string
        x = x - 1;
 
        String tmp;
 
        int index = 0;
 
        int length = x;
 
        // Initializing the left
        // and right index
        left1 = 1;
 
        right1 = left1 + 1;
 
        while (left1 <= length) {
 
            if (heap[index].compareTo(heap[left1]) <= 0 && heap[index].compareTo(heap[right1]) <= 0) {
                break;
            }
 
            else
            {
 
                // Swapping
                if (heap[left1].compareTo(heap[right1])< 0) {
                    tmp = heap[index];
                    heap[index] = heap[left1];
                    heap[left1] = tmp;
                    index = left1;
                }
                else 
                {
                    tmp = heap[index];
                    heap[index] = heap[right1];
                    heap[right1] = tmp;
                    index = right1;
                }
            }
 
            // Changing the left index
            // and right index
            left1 = 2 * left1;
            right1 = left1 + 1;
        }
    }
}
 
static void sort(String k[], int n)
{
 
    
    for (int i = 0; i < n; i++)
    {
        heapForm(k[i]);
    }
 
    // Calling heap sort function
    heapSort();
}
    public static void main(String[] args) throws IOException {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
       
        // loads data from file
        BufferedReader bf = new BufferedReader(
            new FileReader("/Users/mekhiwood-brock/Data-Structures/Unit 9/GenderMag2/src/movieNames.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();
       
        // storing the data in arraylist to array
        String[] array
            = listOfStrings.toArray(new String[0]);
       
        // printing each line of file
        for (String str : array) {
            System.out.println(str);
        }
        int n = array.length;

        sort(array, n);
    }
}
