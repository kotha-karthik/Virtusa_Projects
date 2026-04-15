import pandas as pd
import matplotlib.pyplot as plt

FILE_NAME = "data.csv"

def monthly_summary():
    df = pd.read_csv(FILE_NAME)
    if df.empty:
        print("No data available.")
        return

    df["Date"] = pd.to_datetime(df["Date"])
    df["Month"] = df["Date"].dt.to_period("M")

    summary = df.groupby("Month")["Amount"].sum()
    print("\nMonthly Summary:")
    print(summary)

def category_breakdown():
    df = pd.read_csv(FILE_NAME)
    if df.empty:
        print("No data available.")
        return

    category_sum = df.groupby("Category")["Amount"].sum()

    print("\nCategory-wise Spending:")
    print(category_sum)

    # Pie Chart
    category_sum.plot(kind="pie", autopct='%1.1f%%')
    plt.title("Spending by Category")
    plt.ylabel("")
    plt.show()

def highest_spending_category():
    df = pd.read_csv(FILE_NAME)
    if df.empty:
        print("No data available.")
        return

    category_sum = df.groupby("Category")["Amount"].sum()
    highest = category_sum.idxmax()

    print(f"\nHighest spending category: {highest}")