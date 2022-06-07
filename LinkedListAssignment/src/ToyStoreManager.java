/*
 * Stewart Lovell
 * ToyStoreManager.java
 * 5/22/2022
 */

/**
 * ToyStoreManager class, constructs a linked list of ToyNodes and includes methods to interact with the list
 */
public class ToyStoreManager {

    // fields
    private ToyNode store;

    // parameterized constructor

    /**
     * Parameterized constructor for the ToyStoreManager class.
     * Creates a linked list of ToyNode objects to represent the store's inventory
     * @param toys A String of toys to be entered into the list
     */
    public ToyStoreManager (String toys) {

        // if the given string is null or empty
        if (toys == null || toys.equals("")) {
            // throw a new IllegalArgumentException
            throw new IllegalArgumentException("String is empty or null");
        }

        // split the string of toys on a blank space, separating each toy
        String[] splitToys = toys.split(" ");

        // for every toy-price pair in the string array
        for (String s : splitToys) {
            // split the strings again, this time on the dash "-", separating name from price
            String[] splitToysAgain = s.split("-");
            // isolate the toyName as a String
            String toyName = splitToysAgain[0];
            // isolate the price as a Double
            double toyPrice = Double.parseDouble(splitToysAgain[1]);
            // call findToy with the toyName and capture the returned ToyNode
            ToyNode toy = findToy(toyName);

            // if the returned ToyNode is not null (it already exists within the list)
            if (toy != null) {
                // increment the toyCount
                toy.setCount(toy.getCount()+1);
            } else { // else the ToyNode is not in the list
                // add the node to the front of the list with a count of 1
                store = new ToyNode(toyName, toyPrice, 1, store);
            }
        }
    }

    // methods

    /**
     * Searches through the list of ToyNodes and compares each node's name with the name given as a parameter.
     * If a match is found, returns that node, otherwise returns null
     * @param toyName Name to be compared to each node's name
     * @return Node of matched name if found, null otherwise
     */
    public ToyNode findToy(String toyName) {
        // create a temporary reference to the beginning of the list
        ToyNode current = store;
        // visit each node in the list
        while (current != null) {
            // if the name of the current node is equal to the given name
            if (toyName.equalsIgnoreCase(current.getName())) {
                // return the current node
                return current;
            }
            // match not found on this node, move to the next node
            current = current.getNext();
        }
        // if the loop ends without finding a match, return null
        return null;
    }

    /**
     * Compares the count (occurrences of the node) of each node in the list, returning the name of the node with the highest count
     * @return Name of the node with the highest count
     */
    public String getMostFrequentToy() {
        // create a temporary reference to the beginning of the list
        ToyNode current = store;
        // create a variable to be compared to each node's count, reassigned if the current node's count is larger
        int count = 0;
        // create a string to hold the name of the most purchased toy
        String mostFrequent = "";
        // visit each node in the list
        while (current != null) {
            // if the current node's count is greater than our holder variable
            if (current.getCount() > count) {
                // set our holder variable equal to the current node's count
                count = current.getCount();
                // set mostFrequent equal to the current node's name
                mostFrequent = current.getName();
            }
            // move on to the next node and repeat
            current = current.getNext();
        }
        // after visiting each node, return mostFrequent (name of most purchased toy)
        return mostFrequent;
    }

    /**
     * Creates a String representation of the list and returns it
     * @return String representation of the list
     */
    @Override
    public String toString() {
        // initialize string to be returned
        String s = "[";

        // create a temporary reference to the beginning of the list
        ToyNode current = store;
        // visit each node in the list
        while (current != null) {
            // concatenate the current node's toString onto the String we will be returning
            s += current.toString();
            // as long as the next node in the list is not null, concatenate ", " onto the String to be returned
            if (current.getNext() != null) {
                s += ", ";
            }
            // move on to the next node in the list
            current = current.getNext();
        }
        // return the String representation of the list
        return s += "]";
    }
}
