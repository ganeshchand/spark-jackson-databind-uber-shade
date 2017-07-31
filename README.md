## Goal: I need to use jackson-databind version 2.7.9. Databricks platform provides 2.6.5



* `$ sbt assembly`
* Upload `./target/scala-2.11/shade-jackson-databind-1.0.jar`
* Run the following command:
```scala
import com.databricks.support.shade.jackson.databind.Test
Test.run

// it should print: 
// {"name":"fred","age":25}
// Person(fred,25)

```

`jackson-databind` has compile time dependencies on:

* com.fasterxml.jackson.core » jackson-annotations
* com.fasterxml.jackson.core » jackson-core

`jackson-module-scala` has compile time dependencies on:
* com.fasterxml.jackson.core » jackson-core
* com.fasterxml.jackson.core » jackson-annotations
* com.fasterxml.jackson.core » jackson-databind
* com.fasterxml.jackson.module » jackson-module-paranamer
* org.scala-lang » scala-library	
* org.scala-lang » scala-reflect


