import csv
import os
import pandas as pd
from datetime import datetime

from models.Expense import Expense
from utils.visualization import Visualization


class ExpenseManager:

    FILE_NAME = "data/expenses.csv"

    def __init__(self):

        os.makedirs("data", exist_ok=True)

        if not os.path.exists(self.FILE_NAME):

            with open(self.FILE_NAME, mode='w', newline='') as file:

                writer = csv.writer(file)

                writer.writerow([
                    "Date",
                    "Category",
                    "Amount",
                    "Description"
                ])

    
    def add_expense(self):

        try:

            date = input("Enter Date (YYYY-MM-DD): ")

            datetime.strptime(date, "%Y-%m-%d")

            category = input(
                "Enter Category (Food/Travel/Bills/Shopping): "
            )

            amount = float(input("Enter Amount: "))

            description = input("Enter Description: ")

            expense = Expense(
                date,
                category,
                amount,
                description
            )

            with open(self.FILE_NAME, mode='a', newline='') as file:

                writer = csv.writer(file)

                writer.writerow(expense.to_list())

            print("\nExpense Added Successfully!")

        except Exception as e:

            print("Error:", e)

    
    def view_expenses(self):

        df = pd.read_csv(self.FILE_NAME)

        print("\n========== ALL EXPENSES ==========\n")

        print(df)

    def monthly_summary(self):

        month = input("Enter Month (YYYY-MM): ")

        df = pd.read_csv(self.FILE_NAME)

        filtered_df = df[df["Date"].str.startswith(month)]

        if filtered_df.empty:

            print("\nNo Expenses Found!")

            return

        total = filtered_df["Amount"].sum()

        print(f"\nTotal Expense: ₹{total}")

        category_summary = (
            filtered_df.groupby("Category")["Amount"]
            .sum()
            .sort_values(ascending=False)
        )

        print("\nCategory Wise Spending:\n")

        print(category_summary)

        highest_category = category_summary.idxmax()

        highest_amount = category_summary.max()

        print("\nHighest Spending Category:")

        print(f"{highest_category} : ₹{highest_amount}")

  
    def show_chart(self):

        month = input("Enter Month (YYYY-MM): ")

        df = pd.read_csv(self.FILE_NAME)

        filtered_df = df[df["Date"].str.startswith(month)]

        if filtered_df.empty:

            print("\nNo Data Found!")

            return

        category_summary = (
            filtered_df.groupby("Category")["Amount"]
            .sum()
        )

        Visualization.show_pie_chart(
            category_summary,
            month
        )
