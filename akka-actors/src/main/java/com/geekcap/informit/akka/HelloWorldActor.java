package com.geekcap.informit.akka;

import akka.actor.UntypedActor;

public class HelloWorldActor extends UntypedActor
{
	@Override
	public void onReceive( Object message ) throws Exception 
	{
		if( message instanceof MyMessage )
		{
			MyMessage myMessage = ( MyMessage )message;
			System.out.println( "Received message: " + message );
			myMessage.setMessage( "Hello, " + myMessage.getMessage() );
			getSender().tell( myMessage, getSelf() );
		}
		else
		{
			unhandled( message );
		}
	}

}
