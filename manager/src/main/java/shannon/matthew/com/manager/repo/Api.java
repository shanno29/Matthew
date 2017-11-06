package shannon.matthew.com.manager.repo;

import java.util.List;

import io.reactivex.Flowable;
import shannon.matthew.com.manager.BaseManager;

public abstract class Api<T> extends BaseManager {

  public Flowable<T> get(int id) {
    throw new UnsupportedOperationException("get");
  }

  public Flowable<List<T>> getAll() {
    throw new UnsupportedOperationException("getAll");
  }

  public Flowable<T> add(T t) {
    throw new UnsupportedOperationException("add");
  }

  public Flowable<T> modify(T t) {
    throw new UnsupportedOperationException("modify");
  }

  public Flowable<T> delete(T t) {
    throw new UnsupportedOperationException("delete");
  }

}
