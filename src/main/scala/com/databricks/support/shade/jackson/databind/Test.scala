package com.databricks.support.shade.jackson.databind

import java.io.StringWriter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object Test {

  case class Person(name: String, age: Int)

  def run = {
    val person = Person("fred", 25)
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    // serialize Person to JSON
    val out = new StringWriter
    mapper.writeValue(out, person)
    val json = out.toString()
    println(json)

    // deserialize JSON to Person
    val person2 = mapper.readValue(json, classOf[Person])
    println(person2)
  }

  def testCantChangeThis = {
    import com.databricks.support.java.jackson.databind.module.CantChangeThis
    System.out.println(new CantChangeThis().value)
  }

  def main(args: Array[String]): Unit = {
    run
    testCantChangeThis
  }

}
