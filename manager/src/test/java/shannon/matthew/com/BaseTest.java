package shannon.matthew.com;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.robolectric.annotation.Config.NONE;

@Config(sdk = 21, application = AppMock.class, manifest = NONE)
@RunWith(RobolectricTestRunner.class)
public abstract class BaseTest {

  @Before
  public final void beforeTest() throws Exception {
    setUpTest();
  }

  protected void setUpTest() throws Exception {}

}