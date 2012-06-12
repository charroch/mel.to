package controllers

import play.api._
import db.DB
import play.api.mvc._
import models.Task

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(Task.all()))
  }

  def postmark = Action(parse.json) {
    request =>
      Task.create(request.body.toString())
      Ok
  }

}