# String转其他类型工具类

```
public class StringUtils {
    private static final String TAG = "StringUtils";
    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final char[] DIGITS_UPPER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String EMPTY = "";
    public static final String comma = ",";


    public static final String EMPTY_HOLDER = "--";

    public static final String ONE = "一";
    public static final String TWO = "二";
    public static final String THREE = "三";
    public static final String FOUR = "四";

    public static String numberToStr(int n) {
        String str = "";

        switch (n) {
            case 1:
                str = ONE;
                break;
            case 2:
                str = TWO;
                break;
            case 3:
                str = THREE;
                break;
            case 4:
                str = FOUR;
                break;
        }

        return str;
    }

    public static char[] encodeHex(final byte[] data) {
        return encodeHex(data, true);
    }

    public static char[] encodeHex(final byte[] data, final boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    private static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    public static String format(String format, Object... args) {
        return String.format(Locale.US, format, args);
    }

    public static boolean isMobilePhoneNumber(String number) {
        return !TextUtils.isEmpty(number) && number.matches("^[1][3-8]\\d{9}$");
    }

    public static boolean isEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String[] toArray(JSONArray array) {
        int len = array != null ? array.length() : 0;
        String[] ss = new String[len];
        for (int i = 0; i < len; i++) {
            ss[i] = array.optString(i);
        }
        return ss;
    }

    public static String join(String[] array, String separator) {
        return join(array, separator, 0, array.length);
    }

    public static String join(String[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = EMPTY;
        }

        // endIndex - startIndex > 0: Len = NofStrings *(len(firstString) + len(separator))
        // (Assuming that all Strings are roughly equally long)
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return EMPTY;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length())
                + separator.length());

        StringBuilder buf = new StringBuilder(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    public static boolean isNull(String str) {
        if (str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为1,英文字符长度为0.5
     *
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static double getLength(String s) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 1;
            } else {
                valueLength += 0.5;
            }
        }
        // 进位取整
        return Math.ceil(valueLength);
    }

    public static String from(InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        StringWriter writer = new StringWriter();
        int n = 0;
        char[] buffer = new char[1024 * 4];
        while (-1 != (n = reader.read(buffer)))
            writer.write(buffer, 0, n);
        return writer.toString();
    }

    public static String getMinValueStr(String v1, String v2) {
        if (v1 == null && v2 == null) {
            return null;
        } else if (v1 == null) {
            return v2;
        } else if (v2 == null) {
            return v1;
        } else {
            final double d1 = Double.valueOf(v1);
            final double d2 = Double.valueOf(v2);
            return d1 <= d2 ? v1 : v2;
        }
    }

    public static String getMaxValueStr(String v1, String v2) {
        if (v1 == null && v2 == null) {
            return null;
        } else if (v1 == null) {
            return v2;
        } else if (v2 == null) {
            return v1;
        } else {
            final double d1 = Double.valueOf(v1);
            final double d2 = Double.valueOf(v2);
            return d1 >= d2 ? v1 : v2;
        }
    }

    public static int getFractionCount(String number) {
        if (TextUtils.isEmpty(number)) {
            return 0;
        }
        final int pos = number.indexOf('.');
        if (pos < 0) {
            return 0;
        }
        return number.length() - pos - 1;
    }

    public static int getMaxFractionCount(String[] numbers) {
        int count = 0;
        for (String str : numbers) {
            count = Math.max(count, getFractionCount(str));
        }
        return count;
    }

    public static int compareNumber(String number1, String number2) {
        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
            return 1;
        }
        final double d1 = Double.valueOf(number1);
        final double d2 = Double.valueOf(number2);
        return Double.compare(d1, d2);
    }

    public static double parseDoubleStr(String valueStr, double def) {
        try {
            return Double.parseDouble(valueStr);
        } catch (Exception e) {
        }
        return def;
    }

    public static double parseDoubleStr(String valueStr) {
        return parseDoubleStr(valueStr, 0);
    }

    public static Double parseDoubleWithSymbolPoint(String str) {
        try {
            if (!TextUtils.isEmpty(str))
                return Double.parseDouble(str.replaceAll(",", "."));
        } catch (Exception e) {
        }
        return 0.0;
    }

    public static int parseInteger(String valueStr, int def) {
        try {
            return Integer.parseInt(valueStr);
        } catch (Exception e) {
        }
        return def;
    }

    public static long parseLong(String valueStr, long def) {
        try {
            return Long.parseLong(valueStr);
        } catch (Exception e) {
        }
        return def;
    }

    public static int parseInteger(String valueStr) {
        return parseInteger(valueStr, 0);
    }

    /**
     * 判断字符串 status是否包含arr数组中任意一个元素,
     *
     * @return 如果包含就返回为true(代表显示图表), 否则为false(不做处理)
     */
    public static boolean checkTickerState(String status, String[] arr) {
        for (String s : arr) {
            if (status.contains(s)) {
                //如果包含就返回为true
                return true;
            }
        }
        return false;
    }

    public static Double parseDouble(String str) {
        try {
            if (!TextUtils.isEmpty(str))
                return Double.parseDouble(str.replaceAll(",", ""));
        } catch (Exception e) {
        }
        return 0.0;
    }

    public static double parseValueStr(String valueStr) {
        try {
            return Double.parseDouble(valueStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 检测一个字符串是否有效
     */
    public static String checkStrIfEmpty(String str, String def) {
        return TextUtils.isEmpty(str) ? def : str;
    }

    public static int getChangeToNumberCheckColor(String str) {
        float n = NumberUtils.getFloat(str, 0);
        if (n == 0) {
            return 0;
        }

        return n > 0 ? 1 : -1;
    }

    public static int getChangeColor(String str) {
        if (str == null) {
            return 0;
        }
        if (str.startsWith("+")) {
            return 1;
        } else if (str.startsWith("-")) {
            return -1;
        }
        return 0;
    }

    public static int getChangeColorWithoutSign(String str) {
        if (str == null) {
            return 0;
        }
        double value = StringUtils.parseDouble(str);

        if (value < 0) {
            return -1;
        }
        if (value > 0) {
            return 1;
        }
        return 0;
    }

    public static boolean isEmpty(String number) {
        return TextUtils.isEmpty(number) || "null".equals(number);
    }

    public static boolean isEmpty(Double number) {
        return number == null || number == 0;
    }

    public static List<String> getURLEncodeString(List<String> args) {
        List<String> results = new ArrayList<>();
        for (String tmp : args) {
            results.add(getURLEncodeString(tmp));
        }
        return results;
    }

    public static String getURLEncodeString(String key) {
        if (key == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        String[] values = key.split(":");
        for (int k = 0; k < values.length; k++) {
            try {
                values[k] = URLEncoder.encode(values[k], "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            if (k != 0) {
                sb.append(":");
            }
            sb.append(values[k]);
        }
        return sb.toString();
    }

    /**
     * Returns {@code true} if the given string is null, empty, or comprises only
     * whitespace characters, as defined by {@link Character#isWhitespace(char)}.
     *
     * @param string The String that should be examined.
     * @return {@code true} if {@code string} is null, empty, or consists of
     * whitespace characters only
     */
    public static boolean isEmptyOrWhitespace(String string) {
        if (string == null) {
            return true;
        }
        int length = string.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int parseInt(String string, int defaultValue) {
        if (string != null) {
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException nfe) {
                // ignore
            }
        }
        return defaultValue;
    }


    public static String getString(String str, String defValue) {

        return TextUtils.isEmpty(str) ? defValue : str;
    }

    public static String getString(String str) {

        return TextUtils.isEmpty(str) ? EMPTY_HOLDER : str;
    }

    private static String regex = "(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|" +
            "[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|" +
            "[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|" +
            "[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|" +
            "[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|" +
            "[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|" +
            "[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|" +
            "[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|" +
            "[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|" +
            "[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)";
    /**
     * 截取特殊字符
     *
     * @param content String
     * @return String
     */
    public static String sievingSpeChat(String content) {
        if (!Utils.isEmpty(content)) {
            return content.replaceAll(regex, "");
        }
        return "";
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str String
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
         Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.find();
    }
}

```
