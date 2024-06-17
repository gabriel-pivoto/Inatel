class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

class Professor:
    def __init__(self, name, age, subject):
        self.name = name
        self.age = age
        self.subject = subject
        self.classes = []

    def add_class(self, classroom):
        self.classes.append(classroom.class_name)

    def remove_class(self, class_name):
        self.classes.remove(class_name)

    def list_classes(self):
        return self.classes

class Classroom:
    def __init__(self, class_name, semester, professor):
        self.class_name = class_name
        self.student_list = []
        self.semester = semester
        self.professor = professor

    def add_student(self, student):
        self.student_list.append(student.name)

    def remove_student(self, name):
        self.student_list = [student for student in self.student_list if student != name]

    def list_students(self):
        return self.student_list
