package net.zhenglai.ml.parallel

/**
  * Created by Zhenglai on 7/26/16.
  */
object Conf {

  val parallelismOfComputation = Runtime.getRuntime.availableProcessors()

  val parallelismOfIO = Runtime.getRuntime.availableProcessors() * 2;

  def parallelism(blockingCoefficient: Double) = Runtime.getRuntime.availableProcessors() / (1 - blockingCoefficient)

  // numOfThreads = numOfAvailableCores / (1 - blocking coefficient)
  // we can use profiling or java.lang.management api to calculate the time of a thread spends on system/IO ops vs.
  // on CPu-intensive tasks
  // IO-intensive have large blocking coefficient

  // prefer java.util.concurrent.{Executor, Lock, CountdownLatch, CyclicBarrier...} new threading api
}
