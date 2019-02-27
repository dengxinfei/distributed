package com.dking.distributed.bitSet;

import java.util.BitSet;

/**
 * @ClassName TestBitSet
 * @Author xinfei
 * @Date 2018/10/22 13:43
 **/
public class TestBitSet {


    public static void main(String[] args) {
        System.out.println("Hello World");
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(3);
        bitSet.set(5);
        for(int i = 0; i < bitSet.length(); i++){
            System.out.print(bitSet.get(i) + " : ");
        }







    }





}
