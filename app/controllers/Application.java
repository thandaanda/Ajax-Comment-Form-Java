package controllers;

import models.Comment;
import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render(Comment.find.all()));
	}

	public static Result postComment(String comment) {

		Comment.create(comment);
		return ok();
	}
	
	public static Result javascriptRoutes()
	{
		response().setContentType("text/javascript");
		return ok(
		        Routes.javascriptRouter("jsRoutes",
		            controllers.routes.javascript.Application.postComment()));
	}

}
