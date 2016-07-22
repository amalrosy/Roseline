package com.geekcap.informit.akka;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.kernel.Bootable;

public class MyKernel implements Bootable
{
	final ActorSystem system = ActorSystem.create("mykernel");

	public void shutdown() 
	{
		// Shutdown our actor system
		system.shutdown();
	}

	public void startup() 
	{
		// Create our actors
		system.actorOf( Props.create( HelloWorldActor.class ), "HelloWorldActor" );
	}

}
