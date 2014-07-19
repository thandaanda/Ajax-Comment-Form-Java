package controllers;

import models.Comment;
import play.Logger;
import play.Routes;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render(Comment.find.all()));
	}

	public static Result postComment(String comment) {

		Comment comment2 = Comment.create(comment);
		
		
		return ok(Json.toJson(comment2));
	}

	public static Result deleteComment(Long id) {
		Comment.find.byId(id).delete();
		return ok();
	}

	public static Result editComment(Long id, String comment) {
		Comment comment2 = Comment.find.byId(id);
		comment2.comment = comment;
		comment2.save();
		return ok();
	}

	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes",
				controllers.routes.javascript.Application.postComment(),
				controllers.routes.javascript.Application.deleteComment(),
				controllers.routes.javascript.Application.editComment()));
	}

}
