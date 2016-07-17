package net.zhenglai.ml.lib

import java.io.{BufferedReader, File, FileReader}

/**
  * Created by Zhenglai on 7/16/16.
  */
class FileLineTraversable(file: File) extends Traversable[String] {
  val x = new FileLineTraversable(new File("test.txt"))

  override def foreach[U](f: (String) ⇒ U): Unit = {
    val input = new BufferedReader(new FileReader(file))
    try {
      var line = input readLine

      if (line != null) {
        do {
          f(line)
          line = input readLine
        } while (line != null)
      }
    } finally {
      input close
    }
  }

  // when called within REPL, make sure entire file content aren't enumerated
  override def toString = s"{Lines of ${file getAbsolutePath}}"

  for {
    line ← x
    word ← line.split("\\s+")
  } yield word
}
