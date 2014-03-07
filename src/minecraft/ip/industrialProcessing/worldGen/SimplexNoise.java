package ip.industrialProcessing.worldGen;

import java.util.Random;

public class SimplexNoise {

    SimplexNoiseOctave[] octaves;
    float[] frequencys;
    float[] amplitudes;

    int largestFeature;
    float persistence;
    int seed;

    public SimplexNoise(int largestFeature, int smallestFeature, float persistence, int seed) {
        this.largestFeature = largestFeature;
        this.persistence = persistence;
        this.seed = seed;

        // recieves a number (eg 128) and calculates what power of 2 it is (eg
        // 2^7)
        int maxNumberOfOctaves = (int) Math.ceil(Math.log10(largestFeature) / Math.log10(2));
        int minNumberOfOctaves = (int) Math.floor(Math.log10(smallestFeature) / Math.log10(2));

        int numberOfOctaves = maxNumberOfOctaves - minNumberOfOctaves;

        octaves = new SimplexNoiseOctave[numberOfOctaves];
        frequencys = new float[numberOfOctaves];
        amplitudes = new float[numberOfOctaves];

        Random rnd = new Random(seed);
        float sum = 0;
        for (int i = 0; i < numberOfOctaves; i++) {
            octaves[i] = new SimplexNoiseOctave(rnd.nextInt());

            frequencys[i] = (float) Math.pow(2, i + minNumberOfOctaves);
            sum += amplitudes[i] = (float) Math.pow(persistence, maxNumberOfOctaves - (i + minNumberOfOctaves));
        }
        for (int i = 0; i < amplitudes.length; i++) {
            amplitudes[i] /= sum;
        }
    }

    public float getNoise(float x, float y) {

        float result = 0;

        for (int i = 0; i < octaves.length; i++) {
            // float frequency = Math.pow(2,i);
            // float amplitude = Math.pow(persistence,octaves.length-i);

            result = result + octaves[i].noise(x / frequencys[i], y / frequencys[i]) * amplitudes[i];
        }

        return result;

    }

    public float getNoise(float x, float y, float z) {

        float result = 0;

        for (int i = 0; i < octaves.length; i+=2) {
            float octave = octaves[i].noise(x / frequencys[i], y / frequencys[i], z / frequencys[i]);
            result = result + octave * amplitudes[i];
        }

        return result;

    }
}