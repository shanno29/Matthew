package shannon.matthew.com;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AppMock extends DaggerApplication {

  @Override
  protected AndroidInjector<AppMock> applicationInjector() {
    return DaggerAppComponentMock.builder().create(this);
  }

}