package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class PerformanceTest {

    public static void main(String[] args) {
        Random rand = new Random();
        int count = 5 + rand.nextInt(10);
        List<Calculation> calculations = new ArrayList<>(count);
        RandomCalculationFactory factory = new RandomCalculationFactory(() -> (long) rand.nextInt(1000));
        for (int i = 0; i < count; i++) {
            calculations.add(factory.createCalculation());
        }
        System.out.println("Calculating " + count + " calculations");
        for (Calculation calculation : calculations) {
            System.out.println(calculation.getClass().getSimpleName() + ": " + calculation.calculate());
        }
    }

    static class RandomCalculationFactory {

        private Supplier<Long> generator;

        public RandomCalculationFactory(Supplier<Long> generator) {
            this.generator = generator;
        }

        Random rand = new Random(System.currentTimeMillis());

        public Calculation createCalculation() {
            int r = rand.nextInt(3);
            switch (r) {
                case 0: return new FibonacciCalculation(generator.get());
                case 1: return new FactorialCalculation(generator.get());
                default: return new SumCalculation(generator.get());
            }
        }

    }

    static abstract class Calculation  {

        protected long input;

        public Calculation(long input) {
            this.input = input;
        }

        public abstract String calculate();

    }

    static class FibonacciCalculation extends Calculation {

        public FibonacciCalculation(long input) {
            super(Math.min(input, 20));
        }

        @Override
        public String calculate() {
            return String.valueOf(fib(input));
        }

        private long fib(long i) {
            if (i <= 0) return 0;
            if (i == 1 || i == 2) return 1;
            return fib(i - 2) + fib(i - 1);
        }
    }

    static class FactorialCalculation extends Calculation {

        public FactorialCalculation(long input) {
            super(input);
        }

        @Override
        public String calculate() {
            BigInteger result = BigInteger.ONE;
            for (long i = 1; i <= input; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result.toString();
        }
    }

    static class SumCalculation extends Calculation {

        public SumCalculation(long input) {
            super(input);
        }

        @Override
        public String calculate() {
            BigInteger result = BigInteger.ZERO;
            for (long i = 0; i < input; i++) {
                result = result.add(BigInteger.valueOf(i));
            }
            return result.toString();
        }
    }

}
