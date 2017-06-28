<!DOCTYPE html>
<html>
<head>
<title>Capital Of Country</title>
<script type="text/javascript"
	src="http://cdn.sockjs.org/sockjs-0.3.4.js"></script>
<script type="text/javascript">
	var stompClient = null;

	function setConnected(connected) {
		document.getElementById('connect').disabled = connected;
	}

	function connect() {
		alert("connection");
		if (window.WebSocket) {
			message = "supported";
			console.log("BROWSER SUPPORTED");
		} else {
			console.log("BROWSER NOT SUPPORTED");
		}
		var country = document.getElementById('country').value;
		alert(message);
		var socket = new SockJS(
				"http://localhost:8080/Ch10_Spring_Message_Handler/webS/myHandler_sockjs");
		socket.onopen = function() {
			//event handler when the connection has been established
			console.log('Connection open: ');
			socket.send(country);
		};
		socket.onmessage = function(message) {
			//event handler when data has been received from the server
			alert(message.data);
			console.log('message arrived: '+message);
			showResult(message.data);

		};
		socket.onclose = function() {
			//event handler when the socket has been properly closed
			alert("connection closed");
			console.log('Connection closing: ');
			showResult(message.data);
		}
		socket.onerror = function() {
			//event handler when an error has occurred during communication
			alert("ERROR");
			console.log('Connection error: ');
			showResult(message.data);
		}
	}

	function showResult(message) {
		var response = document.getElementById('messageDiv');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(message));
		response.appendChild(p);
	}
</script>
</head>
<body>
	
	<h1>WebSocket</h1>
	<h1>Select Country to Know it's CAPITAL</h1>
	<div>
		<div>
			<select id="country">
				<option value="India">INDIA</option>
				<option value="USA">U.S.A</option>
			</select><br>
			<br> <br>
			<button id="connect" onclick="connect();">SHOW CAPITAL</button>
			<br /> <br />
		</div>
		<div id="messageDiv">
			<p>CAPITAL WILL BE HERE</p>
			<p id="msgResponse"></p>
		</div>
	</div>
</body>
</html>