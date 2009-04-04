package jp.co.sisc.frame.core.utils;

import java.util.Vector;

/**
 * 系统用工具类
 * @author lnf
 *
 */
public class armUtil {
	public static final boolean isEmpty(String x_str) {
		return x_str == null || x_str.length() == 0;
	}

	public static boolean isEmpty(StringBuffer x_str) {
		return x_str == null || x_str.length() == 0;
	}

	public static boolean isEmpty(Object x_ary[]) {
		return x_ary == null || x_ary.length == 0;
	}

	public static boolean isEmpty(Vector<?> x_vec) {
		return x_vec == null || x_vec.size() == 0;
	}

	public static boolean equals(String x_str1, String x_str2) {
		if (isEmpty(x_str1))
			return isEmpty(x_str2);
		else
			return x_str1.equals(x_str2);
	}
}
