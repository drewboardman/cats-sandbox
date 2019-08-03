package sandbox

import sandbox.exercises.Typeclasses.PrintableInstances._
import sandbox.exercises.Typeclasses.PrintableSyntax._
import sandbox.utils.Cat

object Main extends App {
  val cat = Cat("drew", 31, "white")
  cat.print
}
