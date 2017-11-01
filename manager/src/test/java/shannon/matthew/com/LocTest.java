package shannon.matthew.com;

import org.junit.Assert;
import org.junit.Test;
import shannon.matthew.com.manager.gps.Loc;

public class LocTest extends BaseTest {

  private Loc loc;

  @Override
  protected void setUpTest() throws Exception {
    loc =  new Loc(0.0, 0.0);
  }

  @Test
  public void testConstructor() {
    Assert.assertEquals(loc.lat, 0.0, 0);
    Assert.assertEquals(loc.lon, 0.0, 0);
  }

}
