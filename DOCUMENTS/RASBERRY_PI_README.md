
### To update pi 
$ sudo apt update 

### find ip of the pi 
$ ifconfig 

### to pi config 
$ sudo 

### shout down now and reboot 
$ suso shutdown -h now - r 

### To shutdown the pi 
$ sudo halt

### ssh to the pi from other pc 
$ 


### adding new users 
$ sudo adduser <name>
$ sudo usermod -a -G sudo <name>
or 
$ sudo useradd <name> -m -s /bin/bash -g <users-groupname>
$ sudo passwd <name>

### to delete users 
$ sudo userdel -r <name> 


### to login into other users 
$ sudo login 


### Rasp config 
$ sudo raspi-config 


### java on pi 
$ sudo apt install openjdk-8-jdk openjdk-8-jre 

### maven on pi 
	- ssh to the pi 
	- open maven page and copy the link of the maven download "https://apache.osuosl.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz"
	- use cmd 
		- wget https://apache.osuosl.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
		- cd /opt 
		- sudo tar -xzvf /home/pi/apache-maven-xxx-bin.tar.gz
	- add into the path 
		- $ sudo nano /etc/profile.d/maven.sh 
			```
              M2_HOME='/opt/pache-maven-xxx'
              PATH=$PATH:$M2_HOME/bin
			```
	- sudo reboot 
	- mvn -version 
### for mulitple verion selection 
$ sudo update-alternatives --config java 

### git on pi 
$ sudo apt-get install git-core 


### To enable ssh in i 
$ sudo systemctl enable ssh
$ sudo systemctl start ssh

### shoutdown pi 
- sudo shutdown now 

### reboot pi 
- sudo reboot now 


### remote desktop for pi using 
- https://www.realvnc.com/en/connect/download/viewer/

### ssh to the pi from mac 
	- To find ip of pi 
	- $ ifconfig 
$ ssh pi@1<92.168.0.xx>
- for exit 
	- exit 


