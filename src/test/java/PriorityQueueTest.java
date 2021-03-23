import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriorityQueueTest {
    static Stream<Arguments> testcase() {
        return Stream.of(
                arguments(new int[]{3, 10, -1, -22}, new int[]{-22, -1, 3, 10}),
                arguments(new int[]{-6, 1, 100, 5}, new int[]{-6, 1, 5, 100}),
                arguments(new int[]{-41, -1000, -9, -6, -10}, new int[]{-1000, -41, -10, -9, -6}),
                arguments(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11}),
                arguments(new int[]{100, 10 ,20 ,-1 ,-3}, new int[]{-3, -1, 10, 20, 100})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("testcase")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array){

        PriorityQueue<Integer> t = new PriorityQueue<Integer>();
        Integer s;
        int result[] = new int[random_array.length];

        for(int i = 0; i < random_array.length; i++){
            t.offer(random_array[i]);
        }

        for(int i = 0; i < random_array.length; i++){
            result[i] = t.poll();
        }

        assertArrayEquals(correct_array,result);
    }

    @Test
    public void whenExceptionThrown_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()->{
            new PriorityQueue<Integer>(-1,null);
        });
    }
    @Test
    public void whenExceptionThrown_NullPointerException(){
        assertThrows(NullPointerException.class,()->{
            new PriorityQueue<Integer>().offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_NoSuchElementException(){
        assertThrows(NoSuchElementException.class,()->{
            new PriorityQueue<Integer>().remove();
        });
    }
}
