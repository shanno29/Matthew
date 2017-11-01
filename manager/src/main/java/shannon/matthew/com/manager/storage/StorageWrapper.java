package shannon.matthew.com.manager.storage;

import android.arch.persistence.room.RoomDatabase;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StorageWrapper {

  private RoomDatabase db;

  @Inject
  StorageWrapper(RoomDatabase db) {
    this.db = db;
  }

  public <T> T get(Class<T> t) {
    return t.cast(db);
  }

}
