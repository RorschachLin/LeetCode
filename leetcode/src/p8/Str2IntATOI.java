package p8;

public class Str2IntATOI {
	public int myAtoi(String str) {

		if (str == null)
			return 0;
		int len = str.length();
		int sign = 1;
		StringBuilder sb = new StringBuilder(len);
		int index = 0;
		while (index < str.length() && str.charAt(index) == ' ')
			index++;
		if (index < len && str.charAt(index) == '-') {
			sign = -1;
			index++;
		} else if (index < len && str.charAt(index) == '+') {
			sign = 1;
			index++;
		}
		sb.append("0");
		while (index < str.length() && Character.isDigit(str.charAt(index))) {
			sb.append(str.charAt(index));
			index++;
		}
		int ret = 0;

		if (sign == 1) {
			for (int i = 0; i < sb.length(); i++) {
				int curr = sb.charAt(i) - '0'; // 可以由char类型的数字转换为int（与'0'相差的数字）
				if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && curr > 7)) {
					return Integer.MAX_VALUE;
				}
				ret = ret * 10 + curr;
			}
		} else {
			for (int i = 0; i < sb.length(); i++) {
				int curr = sb.charAt(i) - '0'; // 可以由char类型的数字转换为int（与'0'相差的数字）
				if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && curr > 8)) {
					return Integer.MIN_VALUE;
				}
				ret = ret * 10 - curr;
			}
		}

		return ret;

	}
}
