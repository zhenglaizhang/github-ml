package net.zhenglai.ml.lib

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.script.Message

/**
  * Created by Zhenglai on 7/17/16.
  */
object MutableColEventer {

  object ObservableArray extends ArrayBuffer[Int] with mutable.ObservableBuffer[Int] {
    subscribe(new Sub {
      override def notify(pub: Pub, event: Message[Int]
        with mutable.Undoable): Unit = {
        Console.println(s"Event: $event from $pub")
      }
    })

  }

  ObservableArray += 1
  ObservableArray -= 1

}
