package tdd.interfaces;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /***
     * Gets the maximum size of the circular queue.
     *
     * @return the maximum size of the circular queue.
     */
    int getMaxSize();

    /***
     * Gets the actual size of the circular queue.
     *
     * @return the actual size of the circular queue.
     */
    int getSize();

    /***
     * Adds the element to the circular queue.
     * If the queue is full, the oldest element is overwritten.
     *
     * @param element the element added to the circular queue.
     */
    void add(int element);

    /***
     * Removes and returns the oldest element.
     *
     * @return the removed element.
     * @throws IllegalStateException if the list is empty.
     */
    int removeOldest();

    /***
     * Removes and returns the newest element.
     *
     * @return the removed element.
     * @throws IllegalStateException if the list is empty.
     */
    int removeNewest();

    /***
     * Gets if the list is empty.
     *
     * @return true if the list is empty.
     */
    boolean isEmpty();


    /***
     * Returns the newest element without changing the list
     *
     * @return the newest element.
     * @throws IllegalStateException if the list is empty.
     */
    int peekNewest();

    /***
     * Returns the oldest element without changing the list
     *
     * @return the oldest element.
     * @throws IllegalStateException if the list is empty.
     */
    int peekOldest();
}