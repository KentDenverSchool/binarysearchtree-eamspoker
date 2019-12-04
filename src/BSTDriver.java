import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
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



        results += "Empty Constructor test: \n";
        //Empty Constructor Test
        try{
            //code we want to test

            BinarySearchTree bst = new BinarySearchTree();
           results+= (bst.size() == 0) + " Size should be: 0, Actual: " + st.size() +
                    "\n";
            results+= (bst.isEmpty()) + " IsEmpty should be: true, Actual: " + bst.isEmpty() +
                    "\n";


        } catch(Exception e){
            //what happens if code throws an error

           results+="ERROR: " + e + "\n";

        }



        try{
            //code we want to test
            MinStack exceptionMinStack = new MinStack();

            //try to peek at an empty MinStack
            exceptionMinStack.peek();
            results += "ERROR: Peeked at an empty MinStack\n";

        } catch(Exception e){
            //check if it's the right exception
            if(e instanceof EmptyStackException) {
                results += "true Caught empty stack exception for peek\n";
            } else {
                results += "ERROR: " + e + "\n";
            }

        }







        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(s.nextLine()));
        writer.write(results);

        writer.close();
    }
}
