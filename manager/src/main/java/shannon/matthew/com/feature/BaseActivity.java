package shannon.matthew.com.feature;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import shannon.matthew.com.manager.R;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {
  public Config config = getClass().getAnnotation(Config.class);
  public CompositeDisposable sub = new CompositeDisposable();
  public Binding binding;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    binding = DataBindingUtil.setContentView(this, config.layout());
    getSupportFragmentManager().addOnBackStackChangedListener(this::setupToolbar);
    AndroidInjection.inject(this);
  }

  @Override
  protected void onDestroy() {
    sub.clear();
    binding.unbind();
    super.onDestroy();
  }


  public void setupToolbar() {
    sub.add(Observable.fromIterable(getSupportFragmentManager().getFragments())
      .lastElement()
      .cast(BaseFragment.class)
      .map(v -> v.config.title())
      .subscribe(this::setTitle)
    );
  }

  public void goTo(Fragment fragment) {
    getSupportFragmentManager().beginTransaction()
      .setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_left)
      .replace(android.R.id.content, fragment)
      .addToBackStack(null)
      .commit();
  }

}

