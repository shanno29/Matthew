package shannon.matthew.com.feature;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import io.reactivex.disposables.CompositeDisposable;
import shannon.matthew.com.R;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.databinding.DataBindingUtil.inflate;
import static android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS;
import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static dagger.android.support.AndroidSupportInjection.inject;

public abstract class BaseFragment<Binding extends ViewDataBinding> extends Fragment {
  public Config config = getClass().getAnnotation(Config.class);
  public CompositeDisposable sub = new CompositeDisposable();
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
  public void onDestroyView() {
    sub.clear();
    binding.unbind();
    super.onDestroyView();
  }

  public void showToast(String msg) {
    makeText(getContext(), msg, LENGTH_SHORT).show();
  }

  public void hideKeyboard() {
    View view = getActivity().getCurrentFocus();
    if (view == null) return;

    Object service = getActivity().getSystemService(INPUT_METHOD_SERVICE);
    if (!(service instanceof InputMethodManager)) return;

    InputMethodManager inputManager = ((InputMethodManager) service);
    inputManager.hideSoftInputFromWindow(view.getWindowToken(), HIDE_NOT_ALWAYS);
  }

  public void goTo(int id, Fragment fragment) {
    getFragmentManager().beginTransaction()
      .setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_left)
      .replace(id, fragment)
      .addToBackStack(null)
      .commit();
  }

  public void goBack() {
    hideKeyboard();
    getFragmentManager().popBackStack();
  }

}
