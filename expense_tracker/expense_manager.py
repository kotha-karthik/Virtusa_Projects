import pandas as pd
import os

FILE_NAME = "data.csv"

def initialize_file():
    if not os.path.exists(FILE_NAME):
        df = pd.DataFrame(columns=["Date", "Category", "Amount", "Description"])
        df.to_csv(FILE_NAME, index=False)

def add_expense(date, category, amount, description):
    df = pd.read_csv(FILE_NAME)
    new_data = {
        "Date": date,
        "Category": category,
        "Amount": float(amount),
        "Description": description
    }
    df = pd.concat([df, pd.DataFrame([new_data])], ignore_index=True)
    df.to_csv(FILE_NAME, index=False)
    print("Expense added successfully!")

def view_expenses():
    df = pd.read_csv(FILE_NAME)
    if df.empty:
        print("No expenses recorded.")
    else:
        print(df)