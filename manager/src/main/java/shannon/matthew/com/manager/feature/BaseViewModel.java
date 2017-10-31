package shannon.matthew.com.manager.feature;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel {

  protected <T> FlowableTransformer<T, T> threads() {
    return flowable -> flowable
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread());
  }
}
