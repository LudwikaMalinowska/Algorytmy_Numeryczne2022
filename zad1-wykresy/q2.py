from cProfile import label
import pandas as pd
import matplotlib.pyplot as plt

table = pd.read_csv("../Zadanie1/elements.csv")
print(table.head())
print(table.columns)


plt.plot(table["x"], table["elements"], label="liczba składników")


plt.legend(loc="upper left")
plt.xlim(0, 1)
# plt.yscale("log")
plt.show()
