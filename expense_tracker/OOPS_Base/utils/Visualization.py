import matplotlib.pyplot as plt


class Visualization:

    @staticmethod
    def show_pie_chart(category_summary, month):

        plt.figure(figsize=(8, 8))

        plt.pie(
            category_summary,
            labels=category_summary.index,
            autopct='%1.1f%%'
        )

        plt.title(f"Expense Distribution - {month}")

        plt.show()
