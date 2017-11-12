package shannon.matthew.com.feature;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class Util {

  public static void hideKeyboard(View v) {
    if (v == null) return;
    InputMethodManager inputManager = (InputMethodManager) v.getContext().getSystemService(INPUT_METHOD_SERVICE);

    if (inputManager == null) return ;
    inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
  }

  public static void showMessage(View v, String msg) {
    Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG).show();
  }

}
