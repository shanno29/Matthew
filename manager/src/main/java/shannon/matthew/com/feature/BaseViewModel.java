package shannon.matthew.com.feature;

import io.reactivex.FlowableTransformer;
import static io.reactivex.android.schedulers.AndroidSchedulers.*;
import static io.reactivex.schedulers.Schedulers.*;

public abstract class BaseViewModel {

  protected <T> FlowableTransformer<T, T> threads() {
    return flowable -> flowable
      .subscribeOn(io())
      .observeOn(mainThread());
  }
}
