public class WaterContainer {

    public static int computeMaxWaterVolume(int[] heightsArray) {
        int maxVolume = 0;
        int leftPointer = 0;
        int rightPointer = heightsArray.length - 1; 
        while (leftPointer < rightPointer) {
            int volume = Math.min(heightsArray[leftPointer], heightsArray[rightPointer]) * (rightPointer - leftPointer);
            maxVolume = Math.max(maxVolume, volume);
            if (heightsArray[leftPointer] < heightsArray[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] heightsArray1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water volume: " + computeMaxWaterVolume(heightsArray1));
        int[] heightsArray2 = {1, 1};
        System.out.println("Maximum water volume: " + computeMaxWaterVolume(heightsArray2));
    }
}
