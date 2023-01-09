package lambda;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

class LambdaLearn {

    final static Logger log = LoggerFactory.getLogger(LambdaLearn.class);

    @Test
    void singleParameter(){
        List<String> mapped = Stream.of("hello", "world")
            .map(word -> word + "!")
            .collect(Collectors.toList());

        assertEquals(asList("hello!", "world!"), mapped);
        log.info("Result = {}", join(", ", mapped));
    }


    @Test
    void reduceTest1() {
        // The reduce function uses the functional interface BinaryOperator<T>, which takes two objects of the *same type* as its inputs.
        String result = Stream.of("hello1", "world1").reduce("", (a, b) -> a + "-" + b);

        assertEquals(result, "-hello1-world1");
        log.info("Result = {}", result);
    }

    @Test
    void usingFunctionToReduce() {
        String result = Stream.of("hello2", "world2").reduce("", (a, b) -> combineWithoutTrailingDash(a, b));

        assertEquals(result, "hello2-world2");
        log.info("Result = {}", result);
    }

    @Test
    void usingFunctionToReduceWithMethodReference() {
        String result = Stream.of("hello3", "world3").reduce("", LambdaLearn::combineWithoutTrailingDash);

        assertEquals(result, "hello3-world3");
        log.info("Result = {}", result);
    }

    @Test
    void usingBiFunction() {
        // The BiFunction interface allows us to use parameters of *different types*.
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> biResult = new ArrayList<>();
        for (int i=0; i < list1.size(); i++) {
            biResult.add(list1.get(i) + list2.get(i));
        }

        for (String s : biResult) {
            log.info("Result = {}", s);
        }

        // We can generalize this specialized function using a BiFunction as the combiner:
        List<String> listString = Arrays.asList("x", "y", "z");
        List<Integer> listInt = Arrays.asList(9, 8, 7);

        List<String> biLambdaResult = listCombiner(listString, listInt, (letter, number) -> letter + number);
        for (String s : biLambdaResult) {
            log.info("Result = {}", s);
        }
    }

    @Test
    void withExtractedMethodAsReference () {
        List<Double> list3 = Arrays.asList(1.0d, 2.5d, 3.3d);
        List<Float> list4 = Arrays.asList(0.5f, 0.1f, 7.6f);

        List<Boolean> biLambdaResultBool = listCombiner(list3, list4, LambdaLearn::firstIsGreaterThanSecond);
        for (Boolean s : biLambdaResultBool) {
            log.info("Result = {}", s);
        }
    }

    private static String combineWithoutTrailingDash(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        return a + "-" + b;
    }

    private static <T, U, R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    private static boolean firstIsGreaterThanSecond(Double a, Float b) {
        return a > b;
    }
}
