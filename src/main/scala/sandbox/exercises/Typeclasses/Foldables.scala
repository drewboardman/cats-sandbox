package sandbox.exercises.Typeclasses
import cats.{Applicative, Monad}
import cats.implicits._
import sandbox.utils.{Branch, Branch2, Leaf, Leaf2, Tree, Tree2}

object Foldables {
  def fold[A, B](tree: Tree[A])(f: A => B)(g: (B, B) => B): B = tree match {
    case Leaf(v) => g(v)
    case Branch(l, r) => f(fold(l)(f)(g), fold(r)(f)(g))
  }

  def fold[A, B](tree: Tree2[A])(f: A => B)(g: (A, B, B) => B): B = tree match {
    case Leaf2(v) => f(v)
    case Branch2(v, l, r) => g(v, fold(l)(f)(g), fold(r)(f)(g))
  }
}



object Test {
  sealed trait One[T]
  case class OneA[T](t: T) extends One[T]

  def fold[V, U](o: One[V])(f: V => U): U = o match {
    case OneA(t) => f(t)
  }

  sealed trait Two[T]
  case class TwoA[T](t: T) extends Two[T]
  case class TwoB[T](t1: T, t2: T) extends Two[T]

  def fold[V, U](two: Two[V])(f: V => U)(g: (V, V) => U): U = two match {
    case TwoA(t) => f(t)
    case TwoB(t1, t2) => g(t1, t2)
  }

  sealed trait MyList[A]
  case class Nil[A]() extends MyList[A]
  case class Cons[A](head: A, tail: MyList[A])

  def fold[V, U](list: MyList[V])(f: => U)(g: (V, U) => U): U = list match {
    case Nil() => f
    case Cons(h, t) => g(h, fold(t)(f)(g))
  }

  def map2[F[_] : Monad, A, B](v: F[A], u: F[A])(f: (A, A) => B): F[B] = v.flatMap { vv =>
    u.map { uu =>
      f(vv, uu)
    }
  }

  def map2[F[_] : Monad, A, B](v: F[A], u: F[A])(f: (A, A) => B): F[B] = for {
    vv <- v
    uu <- u
  } yield f(vv, uu)

  def map2b[F[_] : Applicative, A, B](v: F[A], u: F[A])(f: (A, A) => B): F[B] = {
    val x: F[A => B] = Applicative[F].ap(Applicative[F].pure(f.curried))(v)
    val y: F[B] = Applicative[F].ap(x)(u)
    y
  }

  def map2b[F[_] : Applicative, A, B](v: F[A], u: F[A])(f: (A, A) => B): F[B] = Applicative[F].pure(f.curried) <*> v <*> u
}
