package ch.ninecode.cim.tool
{
    import scopt.Read

    import org.slf4j.Logger
    import org.slf4j.LoggerFactory

    sealed abstract class Target (val name: String)
    {
        def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator
    }

    case object scalalanguage       extends Target ("Scala")      { def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator = Scala (parser, options) }
    case object javascriptlanguage  extends Target ("JavaScript") { def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator = JavaScript (parser, options) }

    class TargetReader extends Read[Target]
    {
        val generators: List[Target] = List (scalalanguage, javascriptlanguage)
        def arity = 1
        def reads: String => Target = (s: String) ⇒ generators.find (_.name == s).getOrElse (
            {
                val fallback = scalalanguage
                val log: Logger = LoggerFactory.getLogger (getClass)
                log.error ("""unrecognized target "%s", using %s as a fallback""".format (s, fallback.name))
                fallback
            }
        )
        def languages: List[String] = generators.map (_.name)
    }
}