from database import Database
from helper.writeAJson import writeAJson

class Pokedex():
    
    def __init__(self, database: Database):
        self.db = database
        
    def getPokemonByName(self, name: str):
        pokemon =  self.db.collection.find({"name": name})
        writeAJson(pokemon, "pokemon_by_name")
        
    def getPokemonByType(self, types: list):
        pokemon =  self.db.collection.find({"type": {"$in": types}})
        writeAJson(pokemon, "pokemon_by_type")

    def getIceWeakness(self):
        pokemon =  self.db.collection.find({"weaknesses": "Ice"})
        writeAJson(pokemon, "Ice_weaknesses")
        
    def getNotinEggs(self):
        pokemon =  self.db.collection.find({"egg": "Not in Eggs"})
        writeAJson(pokemon, "NotinEggs")
        
        
    def getSpawnChance(self):
        pokemon =  self.db.collection.find({"spawn_chance": {"$gt": 0.3, "$lt": 0.6}})
        writeAJson(pokemon, "SpawnChance")
