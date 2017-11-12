package shannon.matthew.com.manager.network;

import android.content.Context;

import com.google.gson.Gson;

import java.util.Set;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import java9.util.stream.StreamSupport;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java9.util.stream.StreamSupport.*;
import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

@Module
public abstract class NetworkModule {

  public NetworkModule() {}

  @Provides
  @Singleton
  static Gson gson() {
    return new Gson();
  }

  @Provides
  @Singleton
  static Cache provideOkHttpCache(Context context) {
    return new Cache(context.getCacheDir(), 10 * 1024 * 1024);
  }

  @Provides
  @Singleton
  static OkHttpClient provideOkHttpClient(Cache cache, Set<Interceptor> interceptors) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    stream(interceptors).forEach(builder::addInterceptor);
    return builder
      .connectTimeout(30, SECONDS)
      .writeTimeout(30, SECONDS)
      .readTimeout(30, SECONDS)
      .cache(cache)
      .build();
  }

  @Provides
  @Singleton
  static Retrofit provideRetrofit(@Named("API") String path, Gson gson, OkHttpClient client) {
    return new Retrofit.Builder().baseUrl(path)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .client(client)
      .build();
  }

  @Provides
  @Singleton
  static NetworkWrapper networkWrapper(Retrofit retrofit) {
    return new NetworkWrapper(retrofit);
  }

}