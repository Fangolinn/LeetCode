class Solution:
    def countStudents(self, students: list[int], sandwiches: list[int]) -> int:
        unfed_students_in_a_row: int = 0

        while len(students):
            current_student: int = students.pop(0)

            if current_student == sandwiches[0]:
                sandwiches.pop(0)
                unfed_students_in_a_row = 0
                continue

            unfed_students_in_a_row += 1
            students.append(current_student)

            if unfed_students_in_a_row == len(students):
                break

        return len(students)
        