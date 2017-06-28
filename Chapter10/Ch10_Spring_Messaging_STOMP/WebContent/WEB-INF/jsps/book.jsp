<!DOCTYPE html>
<html>
<head>
    <title> WebSocket</title>
    <script type="text/javascript" src="http://cdn.sockjs.org/sockjs-0.3.4.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">
	
        var stompClient = null; 

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('bookDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('bookResponse').innerHTML = '';
        }

        function connect() {
        	alert("connection");
        	if (window.WebSocket){
        		message="supported";
        	     console.log("BROWSER SUPPORTED");
        	} else {
        	     console.log("BROWSER NOT SUPPORTED");
        	}
        	        	
        	alert(message);
            var socket = new SockJS('book');
			stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
            	alert("in client");
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/showOffer', function(bookResult){
                	alert("subscribing");
                	showResult(JSON.parse(bookResult.body).result);
                	
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function sendBook() {
            var bookName = document.getElementById('bookName').value;
            stompClient.send("/bookApp/book", {}, JSON.stringify({ 'bookName': bookName }));
        }

        function showResult(message) {
            var response = document.getElementById('bookResponse');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
    </script>
</head>
<body>
<h1> WebSocket Book Offers</h1>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button><br/><br/>
    </div>
    <div id="bookDiv">
        <label>SELECT BOOK NAME</label>
         <select id="bookName" name="bookName">
         	<option> Core JAVA </option>    
        	<option> Spring 5.0 </option>
        	<option> Spring 4.0 </option>
         </select>
        <button id="sendBook" onclick="sendBook();">Send to Add</button>
        <p id="bookResponse"></p>
    </div>
</div>
</body>
</html>