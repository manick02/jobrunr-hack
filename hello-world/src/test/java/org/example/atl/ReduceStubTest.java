package org.example.atl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReduceStubTest {

    @Test
    public void testReduceMin() {
        List<String> list = Arrays.asList("C1", "C2");
        String concatedString = list.stream().reduce("", (element, concat) -> element + concat);
        assertEquals("C1C2",concatedString);
    }

    @Test
    public void testReduceMinMax(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int sum = list.stream().reduce(0,(partialsum,element)->partialsum+element);
        assertEquals(15,sum);

    }
}
