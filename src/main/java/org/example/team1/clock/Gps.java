package org.example.team1.clock;

public class Gps {
// double 위도 double 경도
double lon; 
double lat;

void Gps(){
    this.lon=37.321321;
    this.lat=137.312321;
    System.out.println("현재 위도는"+ lon + "현재 경도는" + lat);
}
void gpsUpdate(double lon, double lat) {
    this.lon=lon;
    this.lat=lat;
    System.out.println("갱신된 위도는"+ lon + "갱신된 경도는" + lat );
}

}
