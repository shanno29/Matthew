package shannon.matthew.com.manager.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class PrefsModule {

  public PrefsModule() {}

  @Provides
  static SharedPreferences sharedPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

}
