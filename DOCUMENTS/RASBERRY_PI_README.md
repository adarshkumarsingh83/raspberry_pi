
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

### for mulitple verion selection 
$ sudo update-alternatives --config java 


### remote desktop for pi using 
- https://www.realvnc.com/en/connect/download/viewer/