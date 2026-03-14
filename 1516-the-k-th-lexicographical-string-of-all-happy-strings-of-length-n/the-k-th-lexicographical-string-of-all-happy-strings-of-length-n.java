import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings("", n, happyStrings);
        
        // Check if k is within the bounds of the generated happy strings
        if (k > happyStrings.size()) {
            return "";
        }
        
        return happyStrings.get(k - 1); // k is 1-indexed
    }

    private void generateHappyStrings(String current, int n, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }

        for (char ch : new char[] {'a', 'b', 'c'}) {
            // Ensure the last character is not the same as the current character
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                generateHappyStrings(current + ch, n, happyStrings);
            }
        }
    }
}
