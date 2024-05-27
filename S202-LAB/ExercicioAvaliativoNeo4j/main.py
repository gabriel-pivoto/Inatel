from teacher_crud import TeacherCRUD
from database import Database
from query import Queries

def main():
    uri = "xxxxxxxxxxxxxxxxxxxxx"
    user = "xxxxxxxxxxxxxxxxxxxxxx"
    password = "xxxxxxxxxxxxxxxxxxx" 
    db = Database(uri, user, password)
    teacher_crud = TeacherCRUD(db)
    query = Queries(db)
    


    #questão 1
    query.get_teacher_renzo_info()
    query.get_teachers_starting_with_m()
    query.get_all_city_names()
    query.get_schools_between_numbers()
    #questão 2
    query.get_oldest_and_youngest_teacher_year()
    query.get_average_city_population()
    query.get_city_by_cep_with_a_to_A()
    query.get_third_char_onwards_of_teacher_names()
    
    #questão 3
    teacher_crud.create('Chris Lima', 1956, '189.052.396-66')
    print(teacher_crud.read('Chris Lima'))
    teacher_crud.update('Chris Lima', '162.052.777-77')
    print(teacher_crud.read('Chris Lima'))
    teacher_crud.delete('Chris Lima')
    print(teacher_crud.read('Chris Lima'))

    db.close()

if __name__ == '__main__':
    main()
