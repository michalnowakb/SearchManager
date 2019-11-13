package com.sparta.mjn;

import com.sparta.mjn.exceptions.ChildNotFoundException;
import com.sparta.mjn.search.BinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SearchTest
{
    BinarySearchTree binarySearchTree;
    int[] arrayToAdd = new int[]{3,6,5,9,15,2,1};
   @Before
   public void Setup(){
//       Random random = new Random();
//       int value = random.nextInt(30);
       binarySearchTree = new BinarySearchTree(20);
       binarySearchTree.addElement(6);
       binarySearchTree.addElement(22);
       binarySearchTree.addElement(9);
       binarySearchTree.addElement(13);
       binarySearchTree.addElement(3);

//       binarySearchTree.addElements(arrayToAdd);

   }
    @Test
    public void checkRoot()
    {
        assertEquals(binarySearchTree.getRootElement(),20);
    }
    @Test
    public void checkLeftChild()
    {
//        try{
//            System.out.println(binarySearchTree.getLeftChild(20));
//
//            assertEquals(binarySearchTree.getLeftChild(20),6);
//        } catch (ChildNotFoundException e){
//            e.printStackTrace();
//        }
    }

    @Test
    public void checkAddElement(){
       //assertEquals();
    }
    @Test
    public void checkAddElementsSize(){
       int[] array = new int[]{3,6,5,9,15,2,1};
       assertEquals(array.length + 1,binarySearchTree.getNumberOfElements());
    }

    @Test
    public void checkFindElement(){
       assertTrue(binarySearchTree.findElement(22));
    }

    @Test
    public void checkSortedTreeAsc(){
       int[] array = new int[]{3,6,5,9,15,2,1};
    }
}
