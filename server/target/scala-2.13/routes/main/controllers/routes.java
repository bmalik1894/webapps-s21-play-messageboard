// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Tue May 04 08:38:43 CDT 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMessageboarddb Messageboarddb = new controllers.ReverseMessageboarddb(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWebSocket WebSocket = new controllers.ReverseWebSocket(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDrawSocket DrawSocket = new controllers.ReverseDrawSocket(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMessageboard Messageboard = new controllers.ReverseMessageboard(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMessageboarddb Messageboarddb = new controllers.javascript.ReverseMessageboarddb(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWebSocket WebSocket = new controllers.javascript.ReverseWebSocket(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDrawSocket DrawSocket = new controllers.javascript.ReverseDrawSocket(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMessageboard Messageboard = new controllers.javascript.ReverseMessageboard(RoutesPrefix.byNamePrefix());
  }

}
