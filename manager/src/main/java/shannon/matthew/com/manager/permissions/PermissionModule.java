package shannon.matthew.com.manager.permissions;

import com.apt7.rxpermissions.PermissionObservable;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public abstract class PermissionModule {

  public PermissionModule() {}

  @Provides
  @Singleton
  static PermissionObservable permissionObservable() {
    return PermissionObservable.getInstance();
  }
}
