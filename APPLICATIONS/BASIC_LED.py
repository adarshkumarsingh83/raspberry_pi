import RPi.GPIO as GPIO
import time

RED_PIN = 17

GPIO.setmode(GPIO.BCM)
GPIO.setup(RED_PIN,GPIO.OUT)
GPIO.setwarnings(False)
try:
	for i in range(0, 10):
		GPIO.output(RED_PIN,True)
		time.sleep(1)
		GPIO.outpu(RED_PIN,False)
		time.sleep(1)

except:
  print("exception")


finally:
   GPIO.cleanup()
   print("cleanup executed")