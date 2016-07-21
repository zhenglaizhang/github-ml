package net.zhenglai.test

import org.scalacheck.Prop

/**
  * Created by Zhenglai on 7/21/16.
  */
class CategorySpec extends org.specs2.mutable.Specification {

  import net.zhenglai.ml.lib.Category._

  "A Category should" >> {
    val f = (i: Int) => i.toString
    val g = (s: String) ⇒ s.length
    val h = (i: Int) ⇒ i * i

    "satisfy associativity" >> {
      Prop forAll { (i: Int) ⇒
        compose(h, compose(g, f))(i) == compose(compose(h, g), f)(i)
      }
    }

    "satisfy identity" >> {
      Prop forAll { (i: Int) ⇒
        compose(f, id[Int])(i) mustEqual compose(id[String], f)(i)
      }
    }
  }

}
