package models

case class UserData(username:String, password:String)
case class UserSend(username:String, toUser:String, body:String, timestamp:String)
case class SendMessage(toUser:String, body:String)
case class MessageItem(id:Int, toUser:String, fromUser:String, body:String, timestamp:String)