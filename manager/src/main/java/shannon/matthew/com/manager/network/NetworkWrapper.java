package shannon.matthew.com.manager.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;

@Singleton
public class NetworkWrapper {

  private Retrofit retrofit;

  @Inject
  NetworkWrapper(Retrofit retrofit) {
    this.retrofit = retrofit;
  }

  public <T> T create(Class<T> t) {
    return retrofit.create(t);
  }

}
