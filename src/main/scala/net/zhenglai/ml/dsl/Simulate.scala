package net.zhenglai.ml.dsl

/**
  * Created by Zhenglai on 7/15/16.
  */
object Simulate {

  object Now

  object Execute

  object simulate {
    def once(behavior: () ⇒ Unit) = new {
      // use .type member to access singleton's type
      def right(now: Now.type): Unit = behavior()

      def wait(sec: Int) = new {
        Thread.sleep(sec)

        def andThen(exec: Execute.type) = behavior()
      }
    }
  }

}

object SimulateTest {

  import Simulate._

  def action() = println("some action...")

  simulate.once(() ⇒ println("simulating 1st")).right(Now)
  simulate once (() ⇒ println("simulating 2nd")) right Now
  simulate once { () ⇒ println("simulating 3rd") } right Now
  simulate once action right Now

  simulate once { () ⇒ println("simulating wait...") } wait 2000 andThen Execute
}
