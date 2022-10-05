package org.mule.extension.html.template.parser.internal;

public class ParserUtils {

	protected String getCode(int fi, String str) {
		if ((fi + 2) == str.length()) {
			return "";
		}
		int i = getLastIndex(str.substring(fi + 2), fi);
		if (i == 0) {
			return "";
		}
		// System.out.println(str.substring(fi, i + 1));
		return str.substring(fi, i + 1);
	}

	private int getLastIndex(String str, int firstI) {
		int count = 1;
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ']') {
				count--;
			} else if (c[i] == '[') {
				count++;
			}
			if (count == 0) {
				return firstI + i + 2;
			}
		}
		return 0;
	}

}
