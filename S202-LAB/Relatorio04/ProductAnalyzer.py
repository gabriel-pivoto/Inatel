from database import Database
from helper.writeAJson import writeAJson

db = Database(database="mercado", collection="compras")


class productAnalyzer:

    def __init__(self, database: Database):
        self.db = database
    
    def totalSalesDay(self):
        response = self.db.collection.aggregate([
            {"$unwind": "$produtos"},
            {"$group": {"_id": "$data_compra", "total": {"$count": {}}}}
        ])
        writeAJson(response, "totalSalesDay")

    def bestSeller(self):
        response = self.db.collection.aggregate([
             {"$unwind": "$produtos"},
             {"$group": {"_id": "$produtos.descricao", "total": {"$sum": "$produtos.quantidade"}}},
             {"$sort": {"total": -1}},
             {"$limit": 1}
        ])
        writeAJson(response, "bestSeller")

    def moreSpentOneSinglePurchase(self):
        response = self.db.collection.aggregate([
             {"$unwind": "$produtos"},
             {"$group": {"_id": "$cliente_id", "total": {"$sum": {"$multiply": ["$produtos.quantidade", "$produtos.preco"] }}}},
             {"$sort": {"total": -1}},
             {"$limit": 1}
        ])
        writeAJson(response, "moreSpentOneSinglePurchase")

    def productsMoreThanOnePurchase(self):
        response = self.db.collection.aggregate([
             {"$unwind": "$produtos"},
             {"$group": {"_id": "$produtos.descricao", "total": {"$count":{}}}},
             {"$match": {"total": {"$gt": 1}}}
        ])
        writeAJson(response, "productsMoreThanOnePurchase")

