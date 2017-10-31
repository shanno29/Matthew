package shannon.matthew.com.manager.gps;

import android.location.Address;
import android.location.Location;

public class Loc {

  public double lat;
  public double lon;

  public Loc(Location location) {
    this(location.getLatitude(), location.getLongitude());
  }

  public Loc(Address address) {
    this(address.getLatitude(), address.getLongitude());
  }

  public Loc(double lat, double lon) {
    this.lat = lat;
    this.lon = lon;
  }

}
