package shannon.matthew.com.manager.storage;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

import static java.lang.Integer.valueOf;

public class Converters {

  @TypeConverter
  public static Date toDate(Long timestamp) {
    return timestamp == null ? null : new Date(timestamp);
  }

  @TypeConverter
  public static Long toTimestamp(Date date) {
    return date == null ? null : date.getTime();
  }

  @TypeConverter
  public static int[] intArrayFromString(String value) {
    int[] res = new int[]{};
    if (value.isEmpty()) return res;
    String[] chars = value.split(",");
    for (int i = 0; i < chars.length; i++) res[i]= valueOf(chars[i]);
    return res;
  }

  @TypeConverter
  public static String StringFromIntArray(int[] array) {
    StringBuilder res = new StringBuilder();
    if (array == null) return res.toString();
    for (int e : array) res.append(e).append(",");
    return res.toString();
  }

}