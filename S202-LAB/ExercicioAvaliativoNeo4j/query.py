from database import Database

class Queries:
    def __init__(self, db):
        self.db = db

    def get_teacher_renzo_info(self):
        query = "MATCH (t:Teacher {name: 'Renzo'}) RETURN t.ano_nasc AS ano_nasc, t.cpf AS cpf"
        return self.db.execute_query(query)

    def get_teachers_starting_with_m(self):
        query = "MATCH (t:Teacher) WHERE t.name STARTS WITH 'M' RETURN t.name AS name, t.cpf AS cpf"
        return self.db.execute_query(query)

    def get_all_city_names(self):
        query = "MATCH (c:City) RETURN c.name AS name"
        return self.db.execute_query(query)

    def get_schools_between_numbers(self):
        query = """
        MATCH (s:School)
        WHERE s.number >= 150 AND s.number <= 550
        RETURN s.name AS name, s.address AS address, s.number AS number
        """
        return self.db.execute_query(query)

    def get_oldest_and_youngest_teacher_year(self):
        oldest_query = "MATCH (t:Teacher) RETURN MIN(t.ano_nasc) AS oldest"
        youngest_query = "MATCH (t:Teacher) RETURN MAX(t.ano_nasc) AS youngest"
        oldest = self.db.execute_query(oldest_query)
        youngest = self.db.execute_query(youngest_query)
        return {"oldest": oldest[0]["oldest"], "youngest": youngest[0]["youngest"]}

    def get_average_city_population(self):
        query = "MATCH (c:City) RETURN AVG(c.population) AS average_population"
        result = self.db.execute_query(query)
        return result[0]["average_population"] if result else None

    def get_city_by_cep_with_a_to_A(self):
        query = f"MATCH (c:City {{cep: '37540-000'}}) RETURN REPLACE(c.name, 'a', 'A') AS name"
        result = self.db.execute_query(query)
        return result[0]["name"] if result else None

    def get_third_char_onwards_of_teacher_names(self):
        query = "MATCH (t:Teacher) RETURN SUBSTRING(t.name, 2) AS chars_from_third"
        return self.db.execute_query(query)
