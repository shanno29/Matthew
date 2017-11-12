package shannon.matthew.com.feature;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.databinding.DataBindingUtil.inflate;
import static android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY;
import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static dagger.android.support.AndroidSupportInjection.inject;
import static shannon.matthew.com.R.anim.slide_from_left;
import static shannon.matthew.com.R.anim.slide_to_left;
import static shannon.matthew.com.feature.Util.hideKeyboard;

public abstract class BaseFragment<Binding extends ViewDataBinding> extends Fragment {

  public Config config = getClass().getAnnotation(Config.class);
  public CompositeDisposable sub = new CompositeDisposable();
  public abstract void onReady();
  public Binding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
    super.onCreateView(inflater, container, bundle);
    binding = inflate(inflater, config.layout(), container, false);
    getActivity().setTitle(config.title());
    inject(this);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(View view, Bundle bundle) {
    super.onViewCreated(view, bundle);
    onReady();
  }

  @Override
  public void onDestroyView() {
    sub.clear();
    binding.unbind();
    super.onDestroyView();
  }

  public void goBack() {
    hideKeyboard(getView());
    getFragmentManager().popBackStack();
  }

  public Consumer<Fragment> toNext = fragment -> getFragmentManager().beginTransaction()
    .setCustomAnimations(slide_from_left, slide_to_left, slide_from_left, slide_to_left)
    .replace(config.root(), fragment)
    .addToBackStack(null)
    .commit();

}
