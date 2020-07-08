package grammar.FP;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream
 *
 * @author Li Yun
 * @date 2020/4/9 17:28
 */
public class StreamTest {

  @Test
  public void testAsAFunction(){
    System.out.println(10 % 1);

    List<Integer> result =
        IntStream.rangeClosed(1, 10)
            .filter(i -> i >= 5) //&& i !=5
            .flatMap(i -> i >= 8 ? IntStream.of(i):IntStream.of(i+10))
            .boxed()
            .collect(Collectors.toList());
    System.out.println(result);


//    [10, 5, 1]
    List<Integer> result2 =
        IntStream.rangeClosed(1, 10)
            .filter(i -> 10 % i == 0) // 1,2,5,10
            .map(i -> i == 5 ? i : 10 / i)
//                    .flatMap(i -> i == 5 ? IntStream.of(i) : IntStream.of(i, 10 / i))
            .boxed()
            .collect(Collectors.toList());
    System.out.println(result2);


    List<Integer> result1 = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      if (10 % i == 0) {
//        result1.add(i);
        if (i != 5) {
          result1.add(10 / i);
        }
      }
    }
    System.out.println(result1);
  }

  @Test
  public void testF(){
    List<Integer> together = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4))
        .flatMap(numbers -> numbers.stream())
        .collect(Collectors.toList());
    System.out.println(together);
  }

}
