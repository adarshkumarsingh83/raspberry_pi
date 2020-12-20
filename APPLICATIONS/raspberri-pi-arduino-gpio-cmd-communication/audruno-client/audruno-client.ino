#include <Wire.h>
#define SLAVE_ADDRESS 0x8

const int RED_PIN = 13;
const int GREEN_PIN = 12;
const int YELLOW_PIN = 11;

int RED_PIN_STATE = LOW;
int GREEN_PIN_STATE = LOW;
int YELLOW_PIN_STATE = LOW;

String userOption;
String responseMessage;


void setup() {
  Serial.begin(9600);
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(YELLOW_PIN, OUTPUT);

  Wire.begin(SLAVE_ADDRESS);
  Wire.onReceive(receiveEvent);
  Wire.onRequest(sendData);
}

void loop() {
}


void receiveEvent(int data) {
  String command;
  while (Wire.available() > 0)  {
    char c = Wire.read();
    command = command.concat(c);
  }
  Serial.println(data);
  Serial.println(command);
  ledAction(command);
  delay(500);
}

void sendData() {
  int lengthValue = responseMessage.length() + 1;
  char buffer[lengthValue];
  responseMessage.toCharArray(buffer, lengthValue);
  Wire.write(buffer);
}

void ledAction(String userOption) {
  if (userOption == "ON_RED" ) {
    RED_PIN_STATE = HIGH;
    digitalWrite(RED_PIN, RED_PIN_STATE);
    responseMessage = "RED LIGHT ON OPTION EXECUTED";
  } else if (userOption ==  "ON_GREEN" ) {
    GREEN_PIN_STATE = HIGH;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
    responseMessage = "GREEN LIGHT ON OPTION EXECUTED";
  } else if (userOption == "ON_YELLOW") {
    YELLOW_PIN_STATE = HIGH;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
    responseMessage = "YELLOW LIGHT ON OPTION EXECUTED";
  } else if (userOption == "OFF_RED" ) {
    RED_PIN_STATE = LOW;
    digitalWrite(RED_PIN, RED_PIN_STATE);
    responseMessage = "RED LIGHT OFF OPTION EXECUTED";
  } else if (userOption ==  "OFF_GREEN" ) {
    GREEN_PIN_STATE = LOW;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
    responseMessage = "GREEN LIGHT OFF OPTION EXECUTED";
  } else if (userOption == "OFF_YELLOW") {
    YELLOW_PIN_STATE = LOW ;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
    responseMessage = "YELLOW LIGHT OFF OPTION EXECUTED";
  } else {
    responseMessage = "OPTION NOT MATCHED";
  }
}
