package shannon.matthew.com.manager.storage;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class StorageModule {

  public StorageModule() {}

  @Provides
  @Singleton
  static RoomDatabase rideFreeDb(@Named("DATABASE") String path, @Named("CONTRACT") Class<? extends RoomDatabase> db, Context context) {
    return Room.databaseBuilder(context, db, path)
      .fallbackToDestructiveMigration()
      .allowMainThreadQueries() // TODO REMOVE
      .build();
  }

}
