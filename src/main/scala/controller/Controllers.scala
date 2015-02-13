package controller

import skinny._
import skinny.controller.AssetsController

object Controllers {

  def mount(ctx: ServletContext): Unit = {
    root.mount(ctx)
    oauth.mount(ctx)
    AssetsController.mount(ctx)
  }

  object root extends RootController with Routes {
    val indexUrl = get("/")(index).as('index)
    val securedUrl = get("/secured")(secured).as('secured)
  }

  object oauth extends OAuthController with Routes {
    val loginUrl = get("/auth")(loginRedirect).as('login)
    val callbackUrl = get("/auth/callback")(callback).as('callback)
  }
}

