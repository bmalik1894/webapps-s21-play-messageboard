"use strict"

const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute.replace("https","wss"));
let canvas = document.getElementById("canvasId");
let ctx = canvas.getContext("2d");
ctx.font = "20px Arial";
ctx.fillStyle = "white";
ctx.fillRect(0,0, canvas.width, canvas.height);
console.log(canvas.width + " " + canvas.height);

// sprite constructor and initializer
class Sprite {
    constructor(name, color, x, y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }
}
// sprite creation function
function sprite(name, color, x, y) { return new Sprite(name, color, x, y); }

// Main functionality
socket.onopen = (event) => socket.send("New user connected.");
socket.onmessage = (event) => updateCanvas(event.data);
socket.onclose = (event) => {socket.send("User disconnected."); console.log("Lost connection.");}
window.onbeforeunload = (event) => socket.send("User disconnected.");

// Key functions
document.onkeydown = function (event) {
    const eventKey = getKey(event.key);
    if (eventKey != "garbage") {
        updateServer(eventKey);
    }
}

function getKey(key) {
    if (key == 'ArrowLeft' || key == 'a') return "left";
    else if (key == 'ArrowUp' || key == 'w') return "up";
    else if (key == 'ArrowRight' || key == 'd') return "right";
    else if (key == 'ArrowDown' || key == 's') return "down";
    else return "garbage";
}

function updateServer(key) {
    socket.send(key);
}

// main drawing function
function updateCanvas(eventData) {
    // Redraw background
    ctx.fillStyle = 'white';
    ctx.fillRect(0,0, canvas.width, canvas.height);

    // parse data
    let sprites = [];
    if (eventData.includes(";")) { // Multiple Users
        let data = eventData.split(';');
        data.forEach(function(value) {
            let user = value.split(",");
            sprites.push(sprite(user[0], user[1], user[2], user[3]));
        });
    } else { // Single User
        let data = eventData.split(",");
        sprites.push(sprite(data[0], data[1], data[2], data[3]));
    }

    // draw each sprite
    console.log("Current Users:");
    sprites.forEach(function (sprite) {
        console.log(sprite.name + "(" + sprite.color + ")" + ": (" + sprite.x + ", " + sprite.y + ")");
        ctx.fillStyle = sprite.color;
        ctx.fillRect(parseInt(sprite.x), parseInt(sprite.y), 30, 30);
        ctx.fillText(sprite.name, parseInt(sprite.x), parseInt(sprite.y) + 50);
    });
}
