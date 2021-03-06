import scala.reflect.runtime.universe._
import scala.reflect.macros.{Context => Ctx}

object Impls {
  def foo[U: c.TypeTag](c: Ctx) = {
    import c.universe._
    val U = implicitly[c.TypeTag[U]]
    val body = Apply(Select(Ident(definitions.PredefModule), newTermName("println")), List(Literal(Constant(U.toString))))
    c.Expr[Unit](body)
  }
}