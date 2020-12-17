#include <Wire.h>
#define SLAVE_ADDRESS 0x8

const int RED_PIN = 13;
const int GREEN_PIN = 12;
const int YELLOW_PIN = 11;

int RED_PIN_STATE = LOW;
int GREEN_PIN_STATE = LOW;
int YELLOW_PIN_STATE = LOW;

String userOption;
int responseMessage;


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
  int command = 0;
  while (Wire.available() > 0)  {
    command = Wire.read();
  }
  Serial.println(data);
  Serial.println(command);
  ledAction(command);
  delay(500);
}

void sendData(){
  Wire.write(responseMessage);
}

void ledAction(int userOption) {
  if (userOption == 2 ) {
    RED_PIN_STATE = HIGH;
    digitalWrite(RED_PIN, RED_PIN_STATE);
    responseMessage = 2;
  } else if (userOption ==  4 ) {
    GREEN_PIN_STATE = HIGH;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
    responseMessage = 4;
  } else if (userOption == 6) {
    YELLOW_PIN_STATE = HIGH;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
    responseMessage = 6;
  } else if (userOption == 1 ) {
    RED_PIN_STATE = LOW;
    digitalWrite(RED_PIN, RED_PIN_STATE);
    responseMessage = 1;
  } else if (userOption ==  3 ) {
    GREEN_PIN_STATE = LOW;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
    responseMessage = 3;
  } else if (userOption == 5) {
    YELLOW_PIN_STATE = LOW ;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
    responseMessage = 5;
  } else {
    responseMessage = 0;
  }
}
