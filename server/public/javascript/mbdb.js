"use strict"

let thisUser = "";
let globalMessages = [];

class Message {
    constructor (body, target, from, time) {
        this.body = body;
        this.from = from;
        this.to = target;
        this.time = time;
    }

    equals(other) {
      return this.body == other.body && this.from == other.from && this.to == other.to && this.time == other.time 
    }
}

const ce = React.createElement
const csrfToken = document.getElementById("csrfToken").value;
const validateRoute = document.getElementById("validateUserRoute").value;
const createRoute = document.getElementById("createUserRoute").value;
function assignUsername(uname) {thisUser = uname;}
function fetchMessages() {
  await fetch(getMessagesRoute.value).then(res => res.json()).then(messages => globalMessages);
}

function messageAlreadyExists(newmsg) {
  if (messages.length != 0) {
    for (var i = 0; i < messages.length; i++) {
        if (messages[i].equals(newmsg)) return true;
    }
    return false;
  } else {
    return false;
  }
}

class MainComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { loggedIn: false };
  }

  render() {
    if (this.state.loggedIn) {
      return ce(MessageComponent, { doLogout: () => this.setState( { loggedIn: false})});
    } else {
      return ce(LoginComponent, { doLogin: () => this.setState( { loggedIn: true }) });
    }
  }
}

class LoginComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loginName: "", 
      loginPass: "",
      createName: "", 
      createPass: "",
      loginMessage: "",
      createMessage: ""
    };
  }

  render() {
    return ce('div', null,
      ce('h2', null, 'Login:'),
      ce('br'),
      'Username: ',
      ce('input', {type: "text", id: "loginName", value: this.state.loginName, onChange: e => this.changerHandler(e)}),
      ce('br'),
      'Password: ',
      ce('input', {type: "password", id: "loginPass", value: this.state.loginPass, onChange: e => this.changerHandler(e)}),
      ce('br'),
      ce('button', {onClick: e => this.login(e)}, 'Login'),
      ce('span', {id: "login-message"}, this.state.loginMessage),
      ce('h2', null, 'Create User:'),
      ce('br'),
      'Username: ',
      ce('input', {type: "text", id: "createName", value: this.state.createName, onChange: e => this.changerHandler(e)}),
      ce('br'),
      'Password: ',
      ce('input', {type: "password", id: "createPass", value: this.state.createPass, onChange: e => this.changerHandler(e)}),
      ce('br'),
      ce('button', {onClick: e => this.createUser(e)}, 'Create User'),
      ce('span', {id: "create-message"}, this.state.createMessage)
    );
  }

  changerHandler(e) {
    this.setState({ [e.target['id']]: e.target.value });
  }

  login(e) {
    const username = this.state.loginName;
    const password = this.state.loginPass;
    fetch(validateRoute, { 
      method: 'POST',
      headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken },
      body: JSON.stringify({ username, password })
    }).then(res => res.json()).then(data => {
      if(data) {
        assignUsername(username);
        this.props.doLogin();
      } else {
        this.setState({ loginMessage: "Login Failed" });
      }
    });
  }

  createUser() {
    const username = this.state.createName;
    const password = this.state.createPass;
    fetch(createRoute, { 
      method: 'POST',
      headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken },
      body: JSON.stringify({ username, password })
    }).then(res => res.json()).then(data => {
      if(data) {
        assignUsername(username);
        this.props.doLogin();
      } else {
        this.setState({ createMessage: "User Creation Failed"});
      }
    });
  }
}

class UserComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {users: []}
  }



  render() {
    let stuff = ce('select', {onClick: e => this.populateUserList(), onChange: e => this.setTarget(e), id:"userDropDown"}, 
    ce('option', {value: "Everyone"}, "Everyone"),
);
    return stuff
  }
}

class MessageComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { messages: [], users: [], newMessage: "", taskMessage: "", toUser: "Everyone"};
  }

  componentDidMount() {
    this.populateUserList();
    this.loadMessages2();
  }

  render() {
    return ce('div', null,
      'Messages',
      ce('br'),
      ce('textarea', {rows:15, cols:80, readOnly:true, id:"messageArea"}),
      ce('br'),
      ce('div', null,
        ce('input', {type: 'text', value: this.state.newMessage, onChange: e => this.handleChange(e) }),
        ce('select', {onClick: e => this.populateUserList(), onChange: e => this.setTarget(e), id:"userDropDown"}, 
            ce('option', {value: "Everyone"}, "Everyone")
        ),
        ce('button', {onClick: e => this.handleSendClick(e)}, 'Send Message'),
        this.state.taskMessage
      ),
      ce('br'),
      ce('span', {}, "Logged in as "),
      ce('span', {style: {fontWeight:"bold"}}, thisUser),
      ce('br'),
      ce('span', {}, "If user drop-down doesn't change try a second time."),
      ce('br'),
      ce('button', { onClick: e => this.disconnect(e) }, 'Log out')
    );
  }

  ///////////////////////////////////////////////////////////////////////////

  disconnect(e) {
    globalMessages = [];
    this.props.doLogout();
  }

  setTarget(e) {
    this.setState({toUser: e.target.value});
    document.getElementById("userDropDown").value = this.state.toUser;
    document.getElementById("userDropDown").text = this.state.toUser;
  }

  populateUserList() {
    fetch(listUsersRoute.value).then(res => res.json()).then(users => this.setState({users}));
    let userdropdown = document.getElementById("userDropDown");
    var index = 0;
    for (var user of this.state.users) {
      if (userdropdown.innerHTML.indexOf('value="' + user + '"') == -1 && user != thisUser) {
      let newopt = document.createElement("option");
        newopt.value = user;
        newopt.text = user;
        userdropdown.add(newopt, userdropdown[index]);
        index++;
      }
    }
  }

  

  loadMessages2() {
    const username = this.state.username;
    fetchMessages();
    this.setState({messages:globalMessages});
    console.log(this.state.messages);
    if (this.state.messages.length == 0) {
      document.getElementById("messageArea").value = "No messages yet.";
    } else {
      let textarea = document.getElementById("messageArea");
      textarea.value = "";
      for (var i = 0; i < messages.length; i++) {
        textarea.value += this.state.messages[i].fromUser + " (to " + this.state.messages[i].toUser + "): " + this.state.messages[i].body + "\n";
      }
    }
  }

  handleChange(e) {
    this.setState({newMessage: e.target.value});
  }

  handleSendClick(e) {
    if (this.state.newMessage.length != 0) {
    let target = this.state.toUser;
    let targetMessage = this.state.newMessage;
    let parseme = target + "`" + targetMessage;
    fetch (sendRoute.value, {
      method: 'POST',
      headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken},
      body: JSON.stringify({parseme})
    }).then(res => res.json()).then( data => {
      if(data) {
        this.setState({ messages:data, taskMessage: "", newMessage: ""});
        console.log(this.state.messages);
        this.loadMessages2();
      } else {
        this.setState({taskMessage:"Failed to Send."}); 
      }
    })
    }
  }
}

ReactDOM.render(
  ce(MainComponent, null, null),
  document.getElementById('maindiv')
);
