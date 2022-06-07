/*
 * Stewart Lovell
 * ToyNode.java
 * 5/22/2022
 */

/**
 * ToyNode class, constructs toy objects as nodes, includes methods to interact with each node
 */
public class ToyNode {

    // fields
    private String name;
    private double price;
    private int count;
    private ToyNode next;

    /**
     * Parameterized constructor for the ToyNode class - Constructs a toy as a node
     * @param name Name of toy
     * @param price Price of toy
     * @param count Number of times that this toy appears in the list
     * @param next A reference to the next node in the list
     */
    public ToyNode(String name, double price, int count, ToyNode next) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.next = next;
    }

    // getters & setters

    /**
     * Gets this node's count and returns it
     * @return Count of this node
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Sets this node's count
     * @param count Number to set this node's count to
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets this node's name and returns it
     * @return Name of this node
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets this node's price and returns it
     * @return Price of this node
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the next node in the list and returns it
     * @return Next node in the list
     */
    public ToyNode getNext() {
        return this.next;
    }

    /**
     * Sets the next node in the list equal to node given as a parameter
     * @param next Node to be set equal to the next node in the list
     */
    public void setNext(ToyNode next) {
        this.next = next;
    }

    /**
     * Creates a string representation of this node and returns it
     * @return String representation of this node
     */
    @Override
    public String toString() {
        return "Toy:" + this.name + " Price:" + this.price + "=" + this.count;
    }
}
