class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentCount = students.length;
        int studentsWhoRequeued = 0;

        int sandwichIndex = 0;
        int studentIndex = 0;
        while (studentsWhoRequeued < studentCount) {
            sandwichIndex = sandwichIndex % sandwiches.length;
            studentIndex = studentIndex % students.length;

            if (sandwiches[sandwichIndex] == -1) {
                sandwichIndex++;
                continue;
            }

            if (students[studentIndex] == -1) {
                studentIndex++;
                continue;
            }
            
            if (sandwiches[sandwichIndex] == students[studentIndex]) {
                sandwiches[sandwichIndex++] = -1;
                students[studentIndex++] = -1;
                studentCount--;
                studentsWhoRequeued = 0;
            } else {
                studentIndex++;
                studentsWhoRequeued++;
            }
        }

        return studentCount;
    }
}
