package shannon.matthew.com.manager.repo;

import java.util.List;

import io.reactivex.Flowable;

public interface Api<T> {

  Flowable<T> add(T t);

  Flowable<T> modify(T t);

  Flowable<T> delete(T t);

  Flowable<T> get(int id);

  Flowable<List<T>> getAll();


}


