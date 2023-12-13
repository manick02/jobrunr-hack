package org.example.problem;

import org.example.problems.PalindromeLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PanlindromeLinkedListTest {

    @Test
    public void ConstructionTest() {
        PalindromeLinkedList linkedList = new PalindromeLinkedList(Collections.EMPTY_LIST);
        assertNotNull(linkedList);
    }

    @Test
    public void checkPalindrome(){
        List<Integer> list = Arrays.asList(1, 2, 2, 1);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList(list);
        assertTrue(palindromeLinkedList.isPalindrpme());
    }

    @Test
    public void checkNotPalindrome(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList(list);
        assertFalse(palindromeLinkedList.isPalindrpme());
    }

    @Test
    public void checkPalindromOdd() {
        List<Integer> list = Arrays.asList(1, 2, 2,2,1);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList(list);
        assertTrue(palindromeLinkedList.isPalindrpme());
    }

    @Test
    public void checkNotPalindromOdd() {
        List<Integer> list = Arrays.asList(1, 2, 2,3,1);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList(list);
        assertFalse(palindromeLinkedList.isPalindrpme());
    }
}
