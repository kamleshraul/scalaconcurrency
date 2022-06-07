package com.codekam.akkaactors.actors

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }

// Greeter is an actor
object Greeter {

  // type of messages Greeter actor can recieved
  final case class Greet(whom:String,replyTo:ActorRef[Greeted])
  final case class Greeted(whom:String,replyTo:ActorRef[Greet])

  def apply():Behavior[Greet] = Behaviors.receive{
      (context,message) => context.log.info("Hello {}!",message.whom)
      message.replyTo ! Greeted(message.whom,context.self)
      
      Behaviors.same
  }
}

