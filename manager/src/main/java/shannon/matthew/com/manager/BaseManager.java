package shannon.matthew.com.manager;

import android.util.Log;

import io.reactivex.FlowableTransformer;

public abstract class BaseManager {

  protected <T> FlowableTransformer<T, T> outputRes() {
    return flowable -> flowable
        .doOnNext(this::logOutput)
        .doOnError(this::logError);
  }

  private void logError(Throwable throwable) {
    throwable.printStackTrace();
    logOutput(throwable.getMessage());
  }

  private <T> void logOutput(T value) {
    Log.d("MATTHEW", this.getClass().getName() + ": " + value.toString());
  }
}
