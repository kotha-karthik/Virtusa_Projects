from expense_manager import initialize_file, add_expense, view_expenses
from analytics import monthly_summary, category_breakdown, highest_spending_category

def menu():
    print("\n====== Expense Tracker ======")
    print("1. Add Expense")
    print("2. View Expenses")
    print("3. Monthly Summary")
    print("4. Category Breakdown")
    print("5. Highest Spending Category")
    print("6. Exit")

def main():
    initialize_file()

    while True:
        menu()
        choice = input("Enter your choice: ")

        if choice == "1":
            date = input("Enter date (YYYY-MM-DD): ")
            category = input("Enter category (Food/Travel/Bills/etc): ")
            amount = input("Enter amount: ")
            description = input("Enter description: ")

            add_expense(date, category, amount, description)

        elif choice == "2":
            view_expenses()

        elif choice == "3":
            monthly_summary()

        elif choice == "4":
            category_breakdown()

        elif choice == "5":
            highest_spending_category()

        elif choice == "6":
            print("Exiting...")
            break

        else:
            print("Invalid choice")

if __name__ == "__main__":
    main()