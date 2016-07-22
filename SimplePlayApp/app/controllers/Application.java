package controllers;

import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import play.*;
import play.libs.Akka;
import play.mvc.*;
import views.html.*;
import static akka.pattern.Patterns.ask;

import actors.HelloLocalActor;
import com.geekcap.informit.akka.MyMessage;

import com.fasterxml.jackson.databind.JsonNode;

import models.Employee;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static ActorSystem actorSystem = ActorSystem.create( "play" );
	
	static {
		actorSystem.actorOf( Props.create( HelloLocalActor.class ), "HelloLocalActor" );
	}
	
    public static Result index() {
        return ok(index.render("Hi, Your new application is ready."));
    }
	
	
	public static Result getEmployee( String id ) {
		Employee employee = Employee.searchById( id );
		if( employee != null ) {
			return ok( Json.toJson( employee ) );
		}
		return notFound( "No employee found with id: " + id );
	}
	
	public static Result delEmployee( String id ) {
		Employee employee = Employee.removeById( id );
		if( employee != null ) {
			return ok( Json.toJson( employee ) + " has been removed" );
		}
		return notFound( "No employee found with id: " + id );
	}
	
	public static Result list() {
		return ok( Json.toJson( Employee.findAll() ) );
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result addEmployee() {
		JsonNode jsonNode = Controller.request().body().asJson();
		Employee employee = Json.fromJson( jsonNode, Employee.class );
		employee.save();
		return created();
	}
	


}
