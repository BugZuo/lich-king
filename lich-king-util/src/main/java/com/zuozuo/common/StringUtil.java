package com.zuozuo.common;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bug on 16/1/8.
 */
public class StringUtil {
  static String nameStr = "!|#|$|%|^|&|_|:|\"|<|>|-|=|~|;|\'|,|！|#|￥|%|…|&|（|）|—|：|“|”|《|》|？|【|】|；|‘|，|。|、|`|°|╮";
  static String nameUnicode = "[\\u003f]|[\\u0028]|[\\u0029]|[\\u002a]|[\\u002b]|[\\u007b]|[\\u007c]|[\\u007d]|[\\u002e]";

  public StringUtil() {
  }

  public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  public static boolean isPhoneNumberValid(String mobiles) {
    Pattern p = Pattern.compile("^(1[0-9])\\d{9}$");
    Matcher m = p.matcher(mobiles);
    return m.matches();
  }

  public static boolean isEmail(String email) {
    if (isEmpty(email)) {
      return false;
    } else {
      String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
      Pattern p = Pattern.compile(str);
      Matcher m = p.matcher(email);
      return m.matches();
    }
  }

  public static String escapeQueryChars(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == 92 || c == 43 || c == 45 || c == 33 || c == 40 || c == 41 || c == 58 || c == 94 || c == 91 || c == 93 || c == 34 || c == 123 || c == 125 || c == 126 || c == 63 || c == 124 || c == 38 || c == 59 || c == 47) {
        sb.append('\\');
      }

      sb.append(c);
    }

    return sb.toString();
  }

  public static boolean isUsername(String username) {
    if (isEmpty(username)) {
      return false;
    } else {
      String str = "^([\\u2E80-\\u33FF]|[\\u3400-\\u9FA5]|[a-zA-Z0-9]|" + nameStr + "|" + nameUnicode + ")*$";
      Pattern p = Pattern.compile(str);
      Matcher m = p.matcher(username);
      return m.matches();
    }
  }

  public static String getNoSpaceStr(String username) {
    if (isEmpty(username)) {
      return "";
    } else {
      username = getNoEmojiStr(username);
      return username.replaceAll("\\s*|\t|\r|\n", "");
    }
  }

  public static String getNoEmojiStr(String emojiStr) {
    if (isEmpty(emojiStr)) {
      return "";
    } else {
      Pattern pattern = Pattern.compile("[^\ud83c\udc00-\udbff\udfff]|[\uff00-\uffef一-龥]");
      Matcher matcher = pattern.matcher(emojiStr);

      String normalStr;
      for (normalStr = ""; matcher.find(); normalStr = normalStr + matcher.group()) {
        ;
      }

      return normalStr;
    }
  }

  public static String filterUtf8Mb4(String source, boolean isReplaceEmpty) {
    byte[] bytes = source.getBytes(StandardCharsets.UTF_8);
    ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
    ByteBuffer replaceBuffer = ByteBuffer.allocate(4);
    int firstMatch = -1;
    int i = 0;

    while (i < bytes.length) {
      short result = (short) bytes[i];
      if (result > 0) {
        buffer.put(bytes[i++]);
      } else {
        result = (short) (result + 256);
        if ((result ^ 192) >> 5 == 0) {
          buffer.put(bytes, i, 2);
          i += 2;
        } else if ((result ^ 224) >> 4 == 0) {
          buffer.put(bytes, i, 3);
          i += 3;
        } else if ((result ^ 240) >> 3 == 0) {
          if (firstMatch < 0) {
            firstMatch = i;
            replaceBuffer.put(bytes, i, 4);
          }

          buffer.put(bytes, firstMatch, 4);
          i += 4;
        }
      }
    }

    buffer.flip();
    replaceBuffer.flip();
    String var9 = new String(buffer.array(), StandardCharsets.UTF_8);
    String replace = new String(replaceBuffer.array(), StandardCharsets.UTF_8);
    if (isReplaceEmpty) {
      return var9.replaceAll(replace, "");
    } else {
      return var9.replaceAll(replace, ":question:");
    }
  }

  public static String changeEmpty2Default(String s, String defaultS) {
    return StringUtils.isEmpty(s) ? defaultS : s;
  }

  public static String urlEncode(String s) {
    try {
      if (s == null) {
        return "";
      }

      if (!isEncoded(s)) {
        return URLEncoder.encode(s, "UTF-8");
      }
    } catch (UnsupportedEncodingException var2) {
      ;
    }

    return s;
  }

  public static boolean isEncoded(String url) {
    return url != null && url.indexOf(37) > 0;
  }

  public static String htmlSafeExt(String content) {
    return isEmpty(content) ? content : content.replaceAll("eval", "e-v-a-l").replaceAll("function\\(", "");
  }

  public static String htmlSafe(String content) {
    if (isEmpty(content)) {
      return content;
    } else {
      String re = "(<br\\s*/\\s*>|\\&lt;br\\s*/\\s*\\&gt;)";
      content.replaceAll(re, "&br&");
      content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", " <br />");
      return content;
    }
  }

  public static String getNoHtmlStr(String content) {
    return Jsoup.clean(content, Whitelist.none());
  }

  public static String getUniqueId() {
    return String.valueOf(UUID.randomUUID());
  }

  public static void main(String[] args) {
    System.out.println(getUniqueId());
  }
}
