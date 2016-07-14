package net.zhenglai.ml.indepth

import java.util

/**
  * Created by Zhenglai on 7/14/16.
  */
package test {

  class Foo

}

object Implicit {

  def findAnInt(implicit x: Int) = x

  findAnInt
  findAnInt(13)
  implicit val y = 12
  findAnInt
  findAnInt(14)


  // entity
  // binding
  class Foo {
    def x = 5
  }

  // Foo is bound locally
  val z = new Foo

  import test.{Foo ⇒ Bar}

  val b = new Bar

  import java.util.{List ⇒ JList}
  import java.{io ⇒ jio}

  val l: JList[Int] = new util.ArrayList[Int]()


  object holder {

    trait Foo

    object Foo {
      implicit val x = new Foo {
        override def toString = "Companion Foo"
      }
    }
    // trait & object Foo should be :paste in REPL to becomme companion

    def method(implicit foo: Foo) = println(foo)

    method
  }

}
