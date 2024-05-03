class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Strings = version1.split("\\.");
        String[] v2Strings = version2.split("\\.");

        int versionIndex = 0;
        int v1Version;
        int v2Version;

        while (true) {
            if (versionIndex >= v1Strings.length && versionIndex >= v2Strings.length) {
                break;
            }

            if (versionIndex < v1Strings.length) {
                v1Version = Integer.parseInt(v1Strings[versionIndex]);
            } else {
                v1Version = 0;
            }

            if (versionIndex < v2Strings.length) {
                v2Version = Integer.parseInt(v2Strings[versionIndex]);
            } else {
                v2Version = 0;
            }

            if (v1Version < v2Version) {
                return -1;
            } else if (v1Version > v2Version) {
                return 1;
            }

            versionIndex++;
        }

        return 0;

    }
}
