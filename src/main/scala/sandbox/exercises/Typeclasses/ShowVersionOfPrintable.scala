package sandbox.exercises.Typeclasses

import cats.Show
import sandbox.utils.Dog

object ShowInstances {
  implicit val dogShow: Show[Dog] =
    Show.show(dog => s"name: ${dog.name}, age: ${dog.age}, color: ${dog.color}.")
}
