

const int RED_PIN = 13;
const int GREEN_PIN = 12;
const int YELLOW_PIN = 11;

int RED_PIN_STATE = LOW;
int GREEN_PIN_STATE = LOW;
int YELLOW_PIN_STATE = LOW;

String userOption;

void setup() {
  Serial.begin(9600);
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(YELLOW_PIN, OUTPUT);
}

void loop() {
  if (Serial.available()) {
    userOption = Serial.readString();
    userOption.trim();
    if (userOption.startsWith("ON_") || userOption.startsWith("OFF_")) {
      ledAction(userOption);
    }
  }
  delay(500);
}

void ledAction(String userOption) {

  if (userOption == "ON_RED" ) {
    Serial.println("RED LIGHT ON OPTION EXECUTED");
    RED_PIN_STATE = HIGH;
    digitalWrite(RED_PIN, RED_PIN_STATE);
  } else if (userOption ==  "ON_GREEN" ) {
    Serial.println("GREEN LIGHT ON OPTION EXECUTED");
    GREEN_PIN_STATE = HIGH;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
  } else if (userOption == "ON_YELLOW") {
    Serial.println("YELLOW LIGHT ON OPTION EXECUTED");
    YELLOW_PIN_STATE = HIGH;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
  } else if (userOption == "OFF_RED" ) {
    Serial.println("RED LIGHT OFF OPTION EXECUTED");
    RED_PIN_STATE = LOW;
    digitalWrite(RED_PIN, RED_PIN_STATE);
  } else if (userOption ==  "OFF_GREEN" ) {
    Serial.println("GREEN LIGHT OFF OPTION EXECUTED");
    GREEN_PIN_STATE = LOW;
    digitalWrite(GREEN_PIN, GREEN_PIN_STATE);
  } else if (userOption == "OFF_YELLOW") {
    Serial.println("YELLOW LIGHT OFF OPTION EXECUTED");
    YELLOW_PIN_STATE = LOW ;
    digitalWrite(YELLOW_PIN, YELLOW_PIN_STATE);
  } else {
    Serial.println("OPTION NOT MATCHED");
  }
  Serial.flush();
}
