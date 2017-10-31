package shannon.matthew.com;

import android.content.Context;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
  AndroidSupportInjectionModule.class,
  AppComponentMock.MockAppModule.class,
  //ActivityModuleMock.class,
  //FragmentModuleMock.class,
  //ManagerModuleMock.class,
})
public interface AppComponentMock extends AndroidInjector<AppMock> {

  @Component.Builder
  abstract class Builder extends AndroidInjector.Builder<AppMock> {}

  @Module
  abstract class MockAppModule {

    @Provides
    @Singleton
    static Context context(AppMock app) {
      return app;
    }

  }

}
