from neo4j import GraphDatabase
from neo4j.exceptions import ServiceUnavailable

def get_engineer(tx):
    query = """
        MATCH(n:Person:Student) RETURN n.name AS engineer;
    """
    try:
        result = tx.run(query)
        return [row['engineer'] for row in result]

    except ServiceUnavailable as exception:
        print("{query} raised an error: \n {exception}".format(query=query, exception=exception))
        raise

def get_father_from(tx, entity):
    query = """
        MATCH (father {name: $entity})-[:FATHER_OF]->(child)
        RETURN child.name AS child_name;
    """
    try:
        result = tx.run(query, entity=entity)
        return [row['child_name'] for row in result]

    except ServiceUnavailable as exception:
        print("{query} raised an error: \n {exception}".format(query=query, exception=exception))
        raise



def get_husband_since(tx, entity):
    query = """
        MATCH (p:Person {name: $entity})-[e:HUSBAND_OF]->(spouse)
        RETURN e.since AS data, spouse.name AS name;
    """
    # print("Query:", query)
    # print("Entity:", entity)
    try:
        result = tx.run(query, entity=entity)
        return [f"The spouse of {entity} is {row['name']} since {row['data']}" for row in result]

    except ServiceUnavailable as exception:
        print("{query} raised an error: \n {exception}".format(query=query, exception=exception))
        raise

def get_siblings(tx, entity):
    query = """
        MATCH (person {name: $entity})-[:SIBLING_OF]->(sibling)
        RETURN sibling.name AS sibling_name;
    """
    try:
        result = tx.run(query, entity=entity)
        return [row['sibling_name'] for row in result]

    except ServiceUnavailable as exception:
        print("{query} raised an error: \n {exception}".format(query=query, exception=exception))
        raise
def get_pets_owned_by(tx, entity):
    query = """
        MATCH (owner {name: $entity})-[:OWNER_OF]->(pet)
        RETURN pet.name AS pet_name;
    """
    try:
        result = tx.run(query, entity=entity)
        return [row['pet_name'] for row in result]

    except ServiceUnavailable as exception:
        print("{query} raised an error: \n {exception}".format(query=query, exception=exception))
        raise



uri = ""
user = ""
password = ""

driver = GraphDatabase.driver(uri, auth=(user, password))

while True:
    print("\n1 - Who is the Engineer?")
    print("2 - Who is the father of?")
    print("3 - Who is married to whom? Since when?")
    print("4 - Who is the sibling of?")
    print("5 - Who is the owner of?")
    x = input()

    if x == '1':
        with driver.session() as session:
            result = session.read_transaction(get_engineer)
            print(result)
    elif x == '2':
        entity = input("Father's name: ")
        with driver.session() as session:
            result = session.read_transaction(get_father_from, entity)
            print(result)
    elif x == '3':
        entity = input("Person's name: ")
        with driver.session() as session:
            result = session.read_transaction(get_husband_since, entity)
            print(result)
    elif x == '4':
        entity = input("Person's name: ")
        with driver.session() as session:
            result = session.read_transaction(get_siblings, entity)
            print(result)
    elif x == '5':
        entity = input("Person's name: ")
        with driver.session() as session:
            result = session.read_transaction(get_pets_owned_by, entity)
            print(result)
    
    else:
        break

driver.close()
