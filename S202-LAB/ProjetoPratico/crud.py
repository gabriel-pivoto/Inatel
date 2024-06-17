from database import *
from entities import *

class ClassroomDatabase:
    def __init__(self, db: Database):
        self.db = db

    def save(self, classroom: Classroom):
        classroom_dict = {
            "class_name": classroom.class_name,
            "student_list": classroom.list_students(),
            "semester": classroom.semester,
            "professor": classroom.professor.name
        }
        self.db.collection.insert_one(classroom_dict)

    def update(self, classroom: Classroom):
        self.db.collection.update_one(
            {"class_name": classroom.class_name},
            {"$set": {
                "student_list": classroom.list_students(),
                "semester": classroom.semester,
                "professor": classroom.professor.name
            }}
        )

    def delete(self, class_name: str):
        self.db.collection.delete_one({"class_name": class_name})

    def load(self, class_name: str):
        data = self.db.collection.find_one({"class_name": class_name})
        if data:
            professor = Professor(data['professor'], 0, "") 
            classroom = Classroom(data['class_name'], data['semester'], professor)
            classroom.student_list = data['student_list']
            return classroom
        else:
            return None
