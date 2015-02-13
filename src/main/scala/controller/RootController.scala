package controller

import skinny._

class RootController extends ApplicationController {

  def index = {
    logger.info("Rendering the index.")

    render("/root/index")
  }

  def secured = {
    logger.info("Inside the secured area.")

    render("/root/secured")
  }

}

