package com.codekam.akkaactors.actors

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }

/**
  * actor that create another actor is guardian actor
  */
object GreeterMain {
  
    final case class SayHello(name:String)

    def apply():Behavior[SayHello] = Behaviors.setup{context =>
        val greeter = context.spawn(Greeter(),"greeter")

        Behaviors.receiveMessage(message=>{
            context.log.info("==== Received Message")
            Behaviors.same
        })
    }
}

object ExecuteActors extends App{
    print("Starting Quick Start Actor")
    val greeterMain=ActorSystem(GreeterMain(),"AkkaQuickStart")

    greeterMain ! GreeterMain.SayHello("Charles")
}
