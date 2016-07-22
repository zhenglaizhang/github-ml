package net.zhenglai.ml.lib.arm

/**
  * Created by Zhenglai on 7/22/16.
  */
class UseResource(r: scala.io.Source) {
  val succ = (x: Int) ⇒ {
    r.length
    x + 1
  }
  // it's a shorthand definition as
  val succ2 = new Function[Int, Int] {
    override def apply(v1: Int): Int = {
      v1 + 1
    }
  }

  def use[T](r: T): Boolean = {
    true
  }
}

// TODO import someobject._
// TODO to mock a mockingbird



