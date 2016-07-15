package net.zhenglai.ml

import java.io.File

/**
  * Created by Zhenglai on 7/15/16.
  */
package object implicits {

  class FileWrapper(val file: java.io.File) {
    def /(next: String) = new FileWrapper(new File(file, next))

    override def toString = file.getCanonicalPath
  }

  object FileWrapper {
    implicit def wrap(file: java.io.File) = new FileWrapper(file)

    implicit def unrap(wrapper: FileWrapper) = wrapper.file
  }

  //  import FileWrapper.wrap
  //
  //  val cur = new File(".")
  //  cur / "temp.txt"
  //  def useFile(file: java.io.File) = println(file.getCanonicalPath)
  //  useFile(cur / "temp.txt")
}
