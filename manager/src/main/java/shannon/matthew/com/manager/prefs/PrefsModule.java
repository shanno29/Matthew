package shannon.matthew.com.manager.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class PrefsModule {

  public PrefsModule() {}

  @Provides
  @Singleton
  static SharedPreferences sharedPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

  @Provides
  @Singleton
  static RxSharedPreferences rxPreferences(SharedPreferences preferences) {
    return RxSharedPreferences.create(preferences);
  }

}
