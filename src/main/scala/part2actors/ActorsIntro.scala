package part2actors


import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }


object ActorsIntro extends App {
  
    // 1- actor system
    object ActorMain {

      final  case class SayHello(name:String)

      def apply(): Behavior[SayHello] = Behaviors.setup { context =>
        println("ActorMain Starting to setup")
        val helloWorldActor=context.spawn(HelloWorld(),"helloworld")
        Behaviors.receiveMessage{message =>
          helloWorldActor ! HelloWorld.Message("Hello World")
          Behaviors.same}
      }
    }

    object HelloWorld{

      final case class Message(msg:String)

      def apply():Behavior[Message]=Behaviors.receive{ (context,message)=>
        context.log.info(s"$message")
        Behaviors.same
      }
    }

    val actorSystem=ActorSystem(ActorMain(),"FirstActorSystem")

    println(s"Actor System Started with name : ${actorSystem.name}")

    val anotherActorSystem=ActorSystem(Behaviors.empty[String],"NothingActorSystem")
     println(s"Another Actor Sytem ${anotherActorSystem.name}")


}
