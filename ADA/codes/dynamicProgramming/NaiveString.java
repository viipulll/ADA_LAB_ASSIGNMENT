public class NaiveString {

    public static void search(String text, String pattern) {
        int size = text.length();
        int m = pattern.length();

        for (int idx = 0; idx <= size - m; idx++) {
            int jdx;

            for (jdx = 1; jdx < m; jdx++) {
                if (text.charAt(idx + jdx) != pattern.charAt(jdx))
                    break;
            }

            if (jdx == m)
                System.out.println("Pattern found at index " + idx);
        }
    }

    public static void main(String[] args) {
        String text = "112312311231124";
        String pattern = "1231";

        search(text, pattern);
    }
}