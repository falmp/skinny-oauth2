package controller

import skinny.Logging
import skinny.controller.feature.{SkinnySessionOAuth2LoginFeature, GoogleLoginFeature}
import skinny.filter.SkinnyFilter
import skinny.oauth2.client.google.GoogleUser

class OAuthController extends ApplicationController
    with GoogleLoginFeature
    with SkinnyFilter
    with Logging {

  override protected def redirectURI = "http://localhost:8080" + url(Controllers.oauth.callbackUrl)

  override protected def saveAuthorizedUser(ghUser: GoogleUser): Unit = {
    session.setAttribute("currentUser", ghUser)

    logger.info("User " + ghUser.displayName + " is authorized: " + ghUser)
  }

  override protected def handleWhenLoginSucceeded(): Any = {
    logger.info("You have successfully registered and logged in.")
    redirect302("/") // TODO reverse controller
  }

  override protected def handleWhenLoginFailed(): Any = {
    logger.warn("Login failed. Please try again.")
    redirect302("/") // TODO reverse controller
  }
}

