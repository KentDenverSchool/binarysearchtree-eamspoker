import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BSTDriver {
    public static void main(String[] args)
            throws IOException{
        Scanner s = new Scanner(System.in);
        String results = "_________MinStack Tests_________"+
                "\n\nTests in format expected: actual: passed:true/false\n\n";


        //Tests
        // in try catch blocks so even if the test errors
        // we always write a log!

        //read in new file for tests
        File testFile = new File("tests.txt");

        Scanner fr = new Scanner(testFile);
        BinarySearchTree bst = new BinarySearchTree();

        results += "Empty Constructor test: \n";
        //Empty Constructor Test
        try{
            //code we want to test
           results += (bst.size() == 0) + " Size should be: 0, Actual: " + bst.size() +
                    "\n";
            results += (bst.isEmpty()) + " IsEmpty should be: true, Actual: " + bst.isEmpty() +
                    "\n";


        } catch(Exception e){
            //what happens if code throws an error

           results+="ERROR: " + e + "\n";

        }



        int keepGoing = 0;
        int size = 0;
        while(fr.hasNextLine()) {
            String nextLine = fr.nextLine();
            if (nextLine.equals("")) {
                keepGoing++;
            } else {
                if(keepGoing == 0) {
                    //put/get/size/isEmpty test
                    results += "\n\nput/get/size/isEmpty test, test format: key value\n";
                    try {
                        String[] elems = nextLine.split(" ");
                        String key = elems[0];
                        String value = elems[1];
                        bst.put(key, value);
                        size++;
                        //check size to see if put elem in the tree
                        results += (bst.size() == size) + " Size should be: " + size + ", Actual: " + bst.size() +
                                "\n";
                        //should no longer be empty
                        results += (!bst.isEmpty()) + " IsEmpty should be: false, Actual: " + bst.isEmpty() +
                                "\n";
                        //check if it put the right value
                        results += (bst.get(key).equals(value)) + " value should equal " + value + ", Actual " +
                                bst.get(key) + "\n";
                        //check contains
                        results += (bst.contains(key)) + " contains should return " + true + ", Actual "
                                + bst.contains(key) + "\n";

                        //print out tree for visibility
                        results += "\nTree printed out: " + bst.toString() + "\n";

                    } catch (Exception e) {
                        //what happens if code throws an error

                        results += "ERROR: " + e + "\n";

                    }
                } else if(keepGoing == 1){
                    //min and max tests
                    results += "\n\nMin/Max tests, test format: key isMin\n";
                    try {
                        String[] elems = nextLine.split(" ");
                        String key = elems[0];
                        boolean min = elems[1].equals("true");

                        //check if min
                        if(min){
                            //check if min equals the expected min
                            results += (bst.min().equals(key)) + " min should return " + key + ", Actual "
                                    + bst.min() + "\n";

                        } else {
                            //check if max equals the expected max
                            results += (bst.max().equals(key)) + " max should return " + key + ", Actual "
                                    + bst.max() + "\n";

                        }
                        //print tree
                        results += "\nTree printed out: " + bst.toString() + "\n";;

                    } catch (Exception e) {
                        //what happens if code throws an error

                        results += "ERROR: " + e + "\n";

                    }
                } else if(keepGoing == 2){
                    //remove tests
                    results += "\n\nRemove tests, test format: key value isEmpty\n";
                    try {
                        String[] elems = nextLine.split(" ");
                        String key = elems[0];
                        String value = elems[1];
                        boolean empty = elems[2].equals("true");

                        Object removed  = bst.remove(key);
                        //System.out.println(removed);
                        size--;
                        //check if size decreased
                        results += (bst.size() == size) + " Size should be: " + size + ", Actual: " + bst.size() +
                                "\n";
                        //check is empty
                        results += (bst.isEmpty() == empty) + " IsEmpty should be: " + empty + " Actual: " +
                                bst.isEmpty() + "\n";
                        if(!empty) {
                            //check if it put the right value
                            results += (removed.equals(value)) + " value should equal " + value + ", Actual " +
                                    removed + "\n";
                            //check contains matches input
                            results += (!bst.contains(key)) + " contains should return " + false + ", Actual "
                                    + bst.contains(key) + "\n";
                            //print tree
                            results += "\nTree printed out: " + bst.toString() + "\n";
                        }

                    } catch (Exception e) {
                        //what happens if code throws an error

                        results += "ERROR: " + e + "\n";

                    }

                }
        }

        }




        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(s.nextLine()));
        writer.write(results);

        writer.close();
    }
}
