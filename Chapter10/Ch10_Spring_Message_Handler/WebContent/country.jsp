<!DOCTYPE html>
<html>
<head>
<title>Capital Of Country </title>
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
		alert(country);
		var socket = new WebSocket("ws://localhost:8080/Ch10_Spring_Message_Handler/webS/myHandler");
		var i=0;
        socket.onmessage=function(data){
        	showResult("Message Arrived"+data.data+i++)
        	
        };
        setConnected(true);
        socket.onopen = function(e) {
            console.log("Connection established!");
            socket.send(country);
            console.log("sending data");
        };
       
       
	}
	
	function disconnect() {
	    if (socket != null) {
	    	socket.close();
	    }
	    setConnected(false);
	    console.log("Disconnected");
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