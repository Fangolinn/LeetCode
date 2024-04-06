class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sEditable = new StringBuilder(s);

        int counter = 0;
        int i = sEditable.length() - 1;
        while (i >= 0) {
            char c = sEditable.charAt(i);

            if (c == ')') {
                counter++;
            } else if (c == '(') {
                counter--;
            }

            if (counter == -1) {
                sEditable.deleteCharAt(i);
                counter = 0;
            }

            i--;
        }

        counter = 0;
        i = 0;
        while (i < sEditable.length()) {
            char c = sEditable.charAt(i);

            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }

            if (counter == -1) {
                sEditable.deleteCharAt(i);
                counter = 0;
            } else {
                i++;
            }
        }

        return sEditable.toString();
    }
}
