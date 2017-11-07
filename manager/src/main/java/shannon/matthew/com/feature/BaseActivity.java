package shannon.matthew.com.feature;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import static dagger.android.AndroidInjection.inject;
import static io.reactivex.Observable.fromIterable;
import static shannon.matthew.com.R.anim.slide_from_left;
import static shannon.matthew.com.R.anim.slide_to_left;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

  public Config config = getClass().getAnnotation(Config.class);
  public CompositeDisposable sub = new CompositeDisposable();
  public abstract void onReady();
  public Binding binding;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    binding = DataBindingUtil.setContentView(this, config.layout());
    getSupportFragmentManager().addOnBackStackChangedListener(this::setupToolbar);
    inject(this);
    onReady();
  }

  @Override
  protected void onDestroy() {
    sub.clear();
    binding.unbind();
    super.onDestroy();
  }

  public void setupToolbar() {
    sub.add(fromIterable(getSupportFragmentManager().getFragments())
      .lastElement().cast(BaseFragment.class)
      .map(frag -> frag.config.title())
      .subscribe(this::setTitle)
    );
  }

  public Consumer<Fragment> toNext = fragment -> getSupportFragmentManager().beginTransaction()
    .setCustomAnimations(slide_from_left, slide_to_left, slide_from_left, slide_to_left)
    .replace(config.root(), fragment)
    .addToBackStack(null)
    .commit();

}
