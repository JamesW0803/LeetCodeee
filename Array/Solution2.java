




// time complexity = O(log(m+n))
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = m;
        int partitionX, partitionY;
        int maxLeftX, maxLeftY, minRightX, minRightY;

        while (left <= right) {
            partitionX = (left + right) / 2;
            partitionY = (m + n + 1) / 2 - partitionX;

            maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];

            minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}