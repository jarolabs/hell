package com.jarogoose.hell.performance.execute;

import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stopwatch {

  private Stopwatch() {
  }

  public static long millis(Callable task) {
    long time = 0;

    try {
      time = System.currentTimeMillis();
      task.call();
      time = System.currentTimeMillis() - time;
    } catch (Exception e) {
      log.error(e.getMessage());
    }

    return time;
  }

  public static long nanos(Callable task) {
    long time = 0;

    try {
      time = System.nanoTime();
      task.call();
      time = System.nanoTime() - time;
    } catch (Exception e) {
      log.error(e.getMessage());
    }

    return time;
  }

  public static long nanosToMillis(long nanos) {
    return nanos / 1_000_000;
  }
}
