from services.expense_manager import ExpenseManager


class ExpenseTrackerApp:

    def __init__(self):

        self.manager = ExpenseManager()

    def run(self):

        while True:

            print("\n========== SMART EXPENSE TRACKER ==========")

            print("1. Add Expense")
            print("2. View Expenses")
            print("3. Monthly Summary")
            print("4. Show Pie Chart")
            print("5. Exit")

            choice = input("\nEnter Choice: ")

            if choice == '1':

                self.manager.add_expense()

            elif choice == '2':

                self.manager.view_expenses()

            elif choice == '3':

                self.manager.monthly_summary()

            elif choice == '4':

                self.manager.show_chart()

            elif choice == '5':

                print("\nThank You!")
                break

            else:

                print("\nInvalid Choice!")


if __name__ == "__main__":

    app = ExpenseTrackerApp()

    app.run()
