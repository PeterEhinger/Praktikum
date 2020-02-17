package edu.unibw.se.gdp.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Saves <code>double</code> values in a named FIFO (first-in-first-out) queue.
 * 
 * @author Andrea Baumann
 */
public class DoubleContainer {

    private static final HashMap<String, ArrayList<Double>> DOUBLE_CONTAINER =
            new HashMap<>();

    private DoubleContainer() {}

    /**
     * Appends the value to the end of a queue with the given name.
     * @param name the queues name to which the value is appended
     * @param value the value itself
     */
    public static void appendLast(String name, double value) {
        if (!DOUBLE_CONTAINER.containsKey(name)) {
            DOUBLE_CONTAINER.put(name, new ArrayList<>());
        }
        DOUBLE_CONTAINER.get(name).add(value);

    }

    /**
     * Returns the first element of the queue with the given name.
     * @param name the name of the queue
     * @return the first element of the queue with the given name
     * @throws java.util.NoSuchElementException if there is no queue with the given name or the queue is empty
     */
    public static double removeFirst(String name) {
        if (DOUBLE_CONTAINER.containsKey(name)) {
            if (!DOUBLE_CONTAINER.get(name).isEmpty()) {
                return DOUBLE_CONTAINER.get(name).remove(0);
            }
        }
        throw new NoSuchElementException("Queue '" + name + "' contains no elements.");
    }

    /**
     * Tests if the queue with the given name is empty.
     * @param name the name of the queue
     * @return true if the queue with the given name contains no items; false otherwise.
     */
    public static boolean isEmpty(String name) {
        if (!DOUBLE_CONTAINER.containsKey(name)) {
            return true;
        } else {
            return DOUBLE_CONTAINER.get(name).isEmpty();
        }
    }
}
