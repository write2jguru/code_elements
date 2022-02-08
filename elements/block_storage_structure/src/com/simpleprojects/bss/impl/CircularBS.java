/**
 * This class implements the main interface of Storage Structure
 *
 * @author XXXXXXXXXXX
 * @version 1.0
 * @since 2021-02-8
 */
package com.simpleprojects.bss.impl;

import com.simpleprojects.bss.CircularBSInterface;
import com.simpleprojects.bss.exceptions.NoBlockException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularBS<T> implements CircularBSInterface<T> {

    private final int  defaultSize =10;
    private final int maxSize = 19;
    private int startIndex;
    private int endIndex;
    private int size=0;



    private T[] blocks;

    private Class blockType;

    public CircularBS(Class<T> c) {

        this.blockType =c;
        this.startIndex =0;
        this.blocks = (T[]) Array.newInstance(blockType, defaultSize);
        this.endIndex = this.blocks.length-1; //Default position of endIndex

    }

    @Override
    public void insert(T newBlock) {

        /**
         * Check do we need to increase the block size
         */
        if(!this.isFull()) {
            this.increaseTheCapacity(this.blockType);
        }

        //System.out.println("Condition: "+( this.endIndex+1< this.blocks.length | this.blocks[this.endIndex+1]==null));
        /**
         * Check if the storage structure is empty & endIndex is set at the end. (Initial condition)
         */
        this.endIndex = this.nextEndIndex();
        this.blocks[this.endIndex] = newBlock;
        this.size++;

    }

    @Override
    public void archive() {

        if(this.size()==0) throw new NoBlockException("Block Storage is empty");

        /**
         * Start archiving block from the start position
         */
        this.startIndex = this.startIndex == this.blocks.length ? 0 : this.startIndex;
        this.blocks[this.startIndex]=null;
        this.startIndex++;
        this.size--;

        //System.out.println("Pointer: at Archive "+this.toString());

    }

    @Override
    public void archiveAll() {

    }

    @Override
    public T getFront() {
        if(this.size==0) throw new NoBlockException("Storage is empty!");
        return this.blocks[this.endIndex];
    }

    @Override
    public T getBack() {
        if(this.size==0) throw new NoBlockException("Storage is empty!");
        return this.blocks[this.startIndex];

    }

    @Override
    public int getStorageCapacity() {
        return this.blocks.length;
    }

    @Override
    public int size() {
        return  this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean isFull() {
        return this.size != this.blocks.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(blocks) +
                " NDX => [ start: "+this.startIndex+", end: "+this.endIndex+"]"+
                ", SIZE: "+this.size;

    }

    private void increaseTheCapacity(Class<T> c) {

        if(this.blocks.length==this.maxSize) //Reached to maximum capacity
            return;
        T[] temp = (T[]) Array.newInstance(c, defaultSize+9);
        for(int i=0; i<this.blocks.length;i++)
            temp[i] = this.blocks[i];
        this.blocks = temp;

    }

    private int nextEndIndex() {

        int _next =  this.endIndex == this.blocks.length-1 ?  0 : this.endIndex+1;

        if(_next == this.startIndex && this.blocks[this.startIndex] != null)
            this.archive();
        return _next;

    }

}
