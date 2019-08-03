package sandbox

import sandbox.exercises.PrintableInstances._
import sandbox.exercises.PrintableSyntax._
import sandbox.utils.Cat

object Main extends App {
  val cat = Cat("drew", 31, "white")
  cat.print
}
