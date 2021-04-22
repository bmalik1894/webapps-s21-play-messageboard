package models

case class UserData(username:String, password:String)
case class MessageItem(id:Int, toUser:String, fromUser:String, body:String, timestamp:String)