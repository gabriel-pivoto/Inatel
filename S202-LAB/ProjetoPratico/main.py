import sys
from database import Database
from entities import *
from crud import ClassroomDatabase

db = Database(database='School', collection='classes')
classroom_db = ClassroomDatabase(db)

def add_classroom():
    class_name = input("Enter class name: ")
    semester = input("Enter semester: ")
    professor_name = input("Enter professor's name: ")
    professor_age = int(input("Enter professor's age: "))
    professor_subject = input("Enter professor's subject: ")

    professor = Professor(professor_name, professor_age, professor_subject)
    classroom = Classroom(class_name, semester, professor)
    classroom_db.save(classroom)
    print(f"Classroom {class_name} added successfully.")

def update_classroom():
    class_name = input("Enter class name to update: ")
    classroom = classroom_db.load(class_name)
    if classroom:
        while True:
            print("1. Add Student")
            print("2. Remove Student")
            print("3. Update Semester")
            print("4. Update Professor")
            print("5. Save and Exit")
            choice = input("Enter your choice: ")
            
            if choice == '1':
                student_name = input("Enter student name: ")
                student_age = int(input("Enter student age: "))
                student = Student(student_name, student_age)
                classroom.add_student(student)
                print(f"Student {student_name} added successfully.")
            elif choice == '2':
                student_name = input("Enter student name to remove: ")
                classroom.remove_student(student_name)
                print(f"Student {student_name} removed successfully.")
            elif choice == '3':
                semester = input("Enter new semester: ")
                classroom.semester = semester
                print("Semester updated successfully.")
            elif choice == '4':
                professor_name = input("Enter new professor's name: ")
                professor_age = int(input("Enter new professor's age: "))
                professor_subject = input("Enter new professor's subject: ")
                classroom.professor = Professor(professor_name, professor_age, professor_subject)
                print("Professor updated successfully.")
            elif choice == '5':
                classroom_db.update(classroom)
                print(f"Classroom {class_name} updated successfully.")
                break
            else:
                print("Invalid choice. Please try again.")
    else:
        print(f"Classroom {class_name} not found.")

def delete_classroom():
    class_name = input("Enter class name to delete: ")
    classroom_db.delete(class_name)
    print(f"Classroom {class_name} deleted successfully.")

def load_classroom():
    class_name = input("Enter class name to load: ")
    classroom = classroom_db.load(class_name)
    if classroom:
        print(f"Class Name: {classroom.class_name}")
        print(f"Semester: {classroom.semester}")
        print(f"Professor: {classroom.professor.name}")
        print("Students:")
        for student in classroom.list_students():
            print(f" - {student}")
    else:
        print(f"Classroom {class_name} not found.")

def main():
    while True:
        print("1. Add Classroom")
        print("2. Update Classroom")
        print("3. Delete Classroom")
        print("4. Load Classroom")
        print("5. Exit")
        choice = input("Enter your choice: ")
        
        if choice == '1':
            add_classroom()
        elif choice == '2':
            update_classroom()
        elif choice == '3':
            delete_classroom()
        elif choice == '4':
            load_classroom()
        elif choice == '5':
            sys.exit()
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
