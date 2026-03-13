class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1, right = (long)1e18;
        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int height, int[] workerTimes) {

        long total = 0;

        for (int t : workerTimes) {

            long low = 0, high = height;

            while (low <= high) {
                long mid = (low + high) / 2;

                long need = t * mid * (mid + 1) / 2;

                if (need <= time) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            total += high;

            if (total >= height)
                return true;
        }

        return total >= height;
    }
}