package net.zhenglai.test

import net.zhenglai.ml.lib.Partitioner
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Zhenglai on 7/22/16.
  */
class PartitionerSpec extends FlatSpec with Matchers {
  "Partitioner.partition" should "seperate list successfully" in {
    Partitioner.partition(List("20", "30", "10", "40")) should ===(List(20, 10) → List(30, 40))
  }
}
