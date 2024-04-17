class Solution {
    private final static double KELVIN_DIFF = 273.15d;

    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + KELVIN_DIFF, celsius * 1.8 + 32};
    }
}
