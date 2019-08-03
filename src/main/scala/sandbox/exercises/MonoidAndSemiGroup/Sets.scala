package sandbox.exercises.MonoidAndSemiGroup

import cats.Monoid

object Sets {
  /**
   * I'm going to assume that they literally mean Set, and not all collections
   */

  def setsInstance[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x ++ y

    override def empty: Set[A] = Set.empty
  }

  val intSetInstance: Monoid[Set[Int]] = setsInstance[Int]
}
