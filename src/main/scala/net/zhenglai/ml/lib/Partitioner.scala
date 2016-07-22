package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/22/16.
  */
object Partitioner {
  //  def apply[T](target: List[T]): (List[T], List[T]) = {
  //    target map (_) partition( )
  //  }

  def partition: List[String] ⇒ (List[Int], List[Int]) = {
    a ⇒ a map (_.toInt) partition (_ < 30)
  }

  // partition(List("40", "30", "20"))

  def partition2(a: List[String])(p: Int ⇒ Boolean): (List[Int], List[Int]) = {
    a map (_.toInt) partition p
  }

  // partition2(List
}
