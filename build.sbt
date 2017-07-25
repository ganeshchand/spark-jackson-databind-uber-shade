name := "shade-jackson-databind"

version := "1.0"

scalaVersion := "2.11.8"

assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

test in assembly := {}

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.9",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.9"
)

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename(("com.fasterxml.jackson.**") -> "shadejackson.@1").inAll
)

// To exclude Scala library.
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
        