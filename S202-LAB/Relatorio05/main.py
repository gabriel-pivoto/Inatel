from database import Database
from bookModel import BookModel

db = Database(database="Relatorio05", collection="Livros")
book_model = BookModel(database=db)

def create_book():
    title = input("Enter book title: ")
    author = input("Enter book author: ")
    year = int(input("Enter publication year: "))
    price = float(input("Enter book price: "))
    book_model.create_book(title, author, year, price)
    print("Book created successfully!")

def read_book_by_id():
    book_id = input("Enter book ID: ")
    book = book_model.read_book_by_id(book_id)
    if book:
        print(f"Book details:\n {book}")
    else:
        print("Book not found.")

def update_book():
    book_id = input("Enter book ID to update: ")
    title = input("Enter new book title: ")
    author = input("Enter new author: ")
    year = input("Enter new publication year: ")
    price = input("Enter new book price: ")

    updated_data = {}
    updated_data["title"] = title
    updated_data["author"] = author
    updated_data["year"] = int(year)
    updated_data["price"] = float(price)

    book_model.update_book(book_id, **updated_data)
    print("Book updated successfully!")

def delete_book():
    book_id = input("Enter book ID to delete: ")        
    book_model.delete_book(book_id)

def main_menu():
    options = {
        '1': create_book,
        '2': read_book_by_id,
        '3': update_book,
        '4': delete_book,
        '5': lambda: 5(print("Exiting..."), exit())
    }
    
    while True:
        print("1 - Create Book")
        print("2 - Read Book by ID")
        print("3 - Update Book")
        print("4 - Delete Book")
        print("5 - Exit")

        choice = input("Enter your choice (1-5): ")

        action = options.get(choice)
        if action:
            action()
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main_menu()