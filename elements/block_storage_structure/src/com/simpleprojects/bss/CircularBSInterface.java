/**
 * This is a main interface which models key functionalities of
 * Storage Structure
 *
 * @author XXXXXXXXXXX
 * @version 1.0
 * @since 2021-02-8
 */

package com.simpleprojects.bss;

public interface CircularBSInterface <T> {

    /**
     * This method adds a new block to the storage structure, if the structure is full, it will double the size to accomoddate the new block.
     * Note that the data type of the newBlock is generic, it can be any java type
     * @param newBlock insert generic block in storage
     */
    void insert(T newBlock);

    /**
     * This method archives/removes and returns the first block in the structure. If the structure is empty, it throws a NoBlockException
     */
    void archive();


    /**
     * This method removes all the blocks in the structure. It throws NoBlockException, if there is no block to remove (i.e it is empty).
     */
    void archiveAll();

    /**
     *
     * @return returns the first block currently in the storage structure (without removing the block).
     * if nothing is in the storage structure it will throw NoBlockExceptions.
     */
    T getFront();

    /**
     *
     * @return returns the last block currently in the storage structure (without removing the block).
     * If nothing is in the storage structure it will throw NoBlockException
     */
    T getBack();

    /**
     *
     * @return returns the maximum storage capacity. For
     * example, it returns the maximum number of blocks that the storage
     * structure can accommodate.
     */
    int getStorageCapacity();

    /**
     *
     * @return returns the number of blocks in the storage structure at a time
     */
    int size();

    /**
     *
     * @return checks if the storage structure empty.
     */
    boolean isEmpty();

    /**
     *
     * @return checks if the storage structure is full.
     */
    boolean isFull();

}
