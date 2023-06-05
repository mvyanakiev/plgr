package bifunction;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BiFunctionLearnTest {

    @Test
    void singleParameter(){

        List<String> mapped = Stream.of("hello", "world")
            .map(word -> word + "!")
            .collect(Collectors.toList());

        assertThat(mapped).containsExactly("hello!", "world!");
    }

    // The reduce function uses the functional interface BinaryOperator<T>, which takes two objects of the SAME type as its inputs.
    @Test
    void doubleParameter() {
        String result = Stream.of("hello", "world")
            .reduce("", (a, b) -> b + "-" + a);

        assertThat(result).isEqualTo("world-hello-");
    }

    // without ending dash with method reference
    @Test
    void lambdaMethodReference(){
        String result = Stream.of("hello", "world")
            .reduce("", this::combineWithoutTrailingDash);

        assertThat(result).isEqualTo("world-hello");
    }

    private String combineWithoutTrailingDash(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        return b + "-" + a;
    }

    // The BiFunction interface allows us to use parameters of different types, with a return value of a third type
    @Test
    void usingBiFunction() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> result = listCombiner(list1, list2, (letter, number) -> letter + number);

        assertThat(result).containsExactly("a1", "b2", "c3");
    }


    private static <T, U, R> List<R> listCombiner(
        List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
