from database import Database
from helper.writeAJson import writeAJson
from pokedex import Pokedex

db = Database(database="pokedex", collection="pokemons")
pokedex = Pokedex(db)

pokedex.getPokemonByName("Bulbasaur")
pokedex.getPokemonByType(["Grass", "Poison"])
pokedex.getNotinEggs()
pokedex.getIceWeakness()
pokedex.getSpawnChance()