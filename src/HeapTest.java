import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyThrows() {
        new Heap().peek();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyThrows() {
        new Heap().pop();
    }    
    
    @Test
    public void testHeapIsEmpty() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testPeek_HeapContainsOneValue() {
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.peek());
    }    

    @Test
    public void testPop_ContainsOneValue() {
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.pop());
    }    

    @Test
    public void testPeek_RootIsSmallestValue() {
        Heap heap = new Heap();
        heap.add(10); heap.add(100); heap.add(1000);
        assertEquals(10, heap.peek());
    }
    
    @Test
    public void testDuplicateValues() {
        Heap heap = new Heap();
        heap.add(5); heap.add(5);
        assertEquals(2, heap.size());
        assertEquals(5, heap.peek());
    }    

    @Test
    public void testThreeValues_HighestToLowest() {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        assertEquals(3, heap.size());
        assertEquals(1, heap.pop());
        assertEquals(2, heap.size());
        assertEquals(2, heap.pop());
        assertEquals(1, heap.size());
        assertEquals(3, heap.pop());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testAddNegativeNumbers() {
        Heap heap = new Heap();
        heap.add(0); heap.add(-1);
        assertEquals(-1, heap.peek());
    }

    @Test
    public void testAddAndRemove_CheckBehaviorWithPeekandSize() {
        Heap heap = new Heap();
        heap.add(5);
        assertEquals(5, heap.peek());
        assertEquals(1, heap.size());

        heap.pop();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

        heap.add(5);
        assertEquals(5, heap.peek());
        assertEquals(1, heap.size());
    }
}
