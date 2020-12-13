
String userOption;

const int RED_PIN = 13;
const int GREEN_PIN = 12;
const int YELLOW_PIN = 11;

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
    Serial.println(userOption);
    ledAction(userOption);
  }
  delay(500);
}

void ledAction(String userOption) {
  if (userOption == "ON_RED" ) {
    Serial.println("RED OPTION");
    digitalWrite(RED_PIN, HIGH);
  } else if (userOption ==  "ON_GREEN" ) {
    Serial.println("GREEN OPTION");
    digitalWrite(GREEN_PIN, HIGH);
  } else if (userOption == "ON_YELLOW") {
    Serial.println("YELLOW OPTION");
    digitalWrite(YELLOW_PIN, HIGH);
  } else if (userOption == "OFF_RED" ) {
    Serial.println("RED OPTION OFF");
    digitalWrite(RED_PIN, LOW);
  } else if (userOption ==  "OFF_GREEN" ) {
    Serial.println("GREEN OPTION OFF");
    digitalWrite(GREEN_PIN, LOW);
  } else if (userOption == "OFF_YELLOW") {
    Serial.println("YELLOW OPTION OFF");
    digitalWrite(YELLOW_PIN, LOW);
  } else {
    Serial.println("OPTION NOT MATCHED");
  }
}
