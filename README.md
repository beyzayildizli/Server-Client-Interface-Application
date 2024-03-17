# Server-Client Interface Application

## Description
This project contains a server-client interface application developed in Java. The server allows multiple clients to connect via sockets and engage in message exchange. Clients can connect to the server to send and receive messages.

## Features

- The server listens for client connections and starts a separate thread for each connection.
- Clients can connect to the server to send messages and receive messages from the server.
- The server can send private messages to selected clients or broadcast general messages to all connected clients.

## Usage

### Starting the Server

1. Run the `ServerForm.java` file.
2. Click on the "Start Server" button to initiate the server. Enter the port number you wish to listen on.
3. Once the server is started, it will begin listening for client connections.

### Connecting as a Client and Sending Messages

1. Run the `ClientForm.java` file.
2. Enter the IP address of the server and the port number it's listening on, then click on the "Connect Server" button to connect.
3. Once connected, you can send messages to the server by clicking the "Send Message" button.
4. Messages received from the server will be displayed in the "Incoming Messages" section.

## Error Handling and Notifications

Errors are returned to the user in detail to ensure a user-friendly design:
- **Invalid Port Number**: If an invalid port number is entered when starting the server, an appropriate error message is displayed to the user.
- **Port in Use or I/O Error**: If the server encounters a situation where the port number it's listening on is already in use by another application or if there's an input/output error, an appropriate error message is displayed to the user.
- **No Connected Clients**: If there are no connected clients when the server is started or when a message is attempted to be sent, an appropriate warning message is displayed to the user.
- **Message Sending Operation**: In case of an error during the process of sending a message from the client to the server, an appropriate error message is displayed to the user.
- **Server Shutdown**: When the server is stopped, an appropriate message is displayed to the user.

## Screenshots

Here's a glimpse of the project:
![serverClientResim](https://github.com/beyzayildizli/Server-Client-Interface-Application/assets/77398074/1b625c58-a05e-446b-8851-a024307c3771)

## Getting Started

To experience the project on your local machine, follow these steps:

1. Clone this repository: `git clone https://github.com/beyzayildizli/Server-Client-Interface-Application.git`
2. Navigate to the cloned directory: `cd Server-Client-Interface-Application`
3. Open the project in your preferred Java IDE.
4. Compile and run the `ServerForm.java` file to start the server.
5. Compile and run the `ClientForm.java` file to start the client application.
6. Follow the usage instructions provided in the README to interact with the server and client applications.

## Dependencies

This project has the following dependencies:

- Java Development Kit (JDK)
- Git (for cloning the repository)

Ensure that you have these dependencies installed on your system before running the project.

## Credits
This project was developed by Beyza Yıldızlı. You can find me on [LinkedIn](https://www.linkedin.com/in/beyzayildizli/) or [GitHub](https://github.com/beyzayildizli).
