package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
public class StreamBenchmark {
    private List<Integer> list;

    @Setup
    public void setup() {
        list = new ArrayList<>();
        Random random = new Random();
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 50000));
        }
    }

    @Benchmark
    public void concurrencia() {
        List<Integer> resultSecuencial = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public void paralelismo() {
        List<Integer> resultParalelo = list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
