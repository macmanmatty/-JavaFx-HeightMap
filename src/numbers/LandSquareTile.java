package numbers;

public class LandSquareTile {
int number;
int locationx;
int locationy;
LandSquareTile(int x,  int y, int number){
	locationx=x;
	locationy=y;
	this.number=number;
	
	
}


public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public int getLocationx() {
	return locationx;
}

public void setLocationx(int locationx) {
	this.locationx = locationx;
}

public int getLocationy() {
	return locationy;
}

public void setLocationy(int locationy) {
	this.locationy = locationy;
}

}
