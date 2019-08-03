package sandbox.exercises.MonoidAndSemiGroup

import cats._

object Boolean {
  val boolAndInstance: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = x && y

    override def empty: Boolean = true
  }

  val boolOrInstance: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = x || y

    override def empty: Boolean = false
  }

  // exclusive OR and exclusive NOR are listed in the book, I don't see the point
}
