package shannon.matthew.com.manager.gps;

import android.content.Context;

import com.apt7.rxpermissions.Permission;
import com.apt7.rxpermissions.PermissionObservable;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY;
import static io.reactivex.BackpressureStrategy.*;

@Module
public abstract class GpsModule {

  public GpsModule() {}

  @Provides
  @Singleton
  static RxLocation reactiveLocationProvider(Context context) {
    return new RxLocation(context);
  }

  @Provides
  @Singleton
  static LocationRequest locationRequest() {
    return LocationRequest.create().setPriority(PRIORITY_HIGH_ACCURACY).setInterval(5000);
  }

  @Provides
  @Singleton
  static Flowable<Permission> permissionObservable(Context context) {
    return PermissionObservable.getInstance()
            .request(context, ACCESS_FINE_LOCATION)
            .toFlowable(BUFFER);
  }

}
