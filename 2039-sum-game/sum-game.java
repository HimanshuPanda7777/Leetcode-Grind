class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int unknownLeft = 0, unknownRight = 0;
        int sumLeft = 0, sumRight = 0;

        // First half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                unknownLeft++;
            } else {
                sumLeft += num.charAt(i) - '0';
            }
        }

        // Second half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                unknownRight++;
            } else {
                sumRight += num.charAt(i) - '0';
            }
        }

        // Alice gets the final move
        if ((unknownLeft + unknownRight) % 2 == 1)
            return true;

        if (unknownLeft > unknownRight) {
            return sumLeft - sumRight
                    + 9 * (unknownLeft - unknownRight) / 2 != 0;
        }

        return sumLeft - sumRight
                - 9 * (unknownRight - unknownLeft) / 2 != 0;
    }
}