package shannon.matthew.com.manager.repo;

import java.util.List;

import io.reactivex.Flowable;
import shannon.matthew.com.manager.BaseManager;

public abstract class Api<T> extends BaseManager {

  Flowable<T> get(int id) {
    throw new UnsupportedOperationException("get");
  }

  Flowable<List<T>> getAll() {
    throw new UnsupportedOperationException("getAll");
  }

  Flowable<T> add(T t) {
    throw new UnsupportedOperationException("add");
  }

  Flowable<T> modify(T t) {
    throw new UnsupportedOperationException("modify");

  }

  Flowable<T> delete(T t) {
    throw new UnsupportedOperationException("delete");

  }

}
