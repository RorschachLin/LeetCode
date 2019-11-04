package p151;

public class ReverseWords {

	public String reverseWordsInStr(String s) {
		int len = s.length();
		if (s == null || len == 0)
			return "";
		
		int blank = 0;
		// remove blanks on front
		while (blank < len && s.charAt(blank) == ' ') {
			blank++;
		}
		s = s.substring(blank);
		int subLen = s.length();
		int head = subLen - 1;
		int tail = subLen - 1;
		StringBuilder sb = new StringBuilder(subLen);
		while (head >= 0) {
			while (head >= 0 && s.charAt(head) == ' ') {
				head--;
			}
			tail = head;
			while (head >= 0 && s.charAt(head) != ' ') {
				head--;
			}
			sb.append(s.substring(head + 1, tail + 1));
			// front blanks are removed, so if head pointer is not at head, append splliter
			if (head > 0) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = " fejfo fjewa naei9";
		System.out.println(new ReverseWords().reverseWordsInStr(s));
	}
}
