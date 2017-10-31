package shannon.matthew.com.manager.repo;

import java.util.List;

import io.reactivex.Flowable;

public interface Api<T> {

  Flowable<List<T>> getAll();

  Flowable<T> get(int id);

  Flowable<T> add(T t);

  Flowable<T> modify(T t);

  Flowable<T> delete(T t);

}