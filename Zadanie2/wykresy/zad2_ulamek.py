from cProfile import label
import pandas as pd
import matplotlib.pyplot as plt

table = pd.read_csv("err_my_gauss_ulamek.csv")
print(table.head())
print(table.columns)


plt.plot(table["size"], table["errGaussGUlamek"], label="bez wyb. ulamek")
plt.plot(table["size"], table["errGaussPGUlamek"],
         label="częściowy wyb. ulamek")
plt.plot(table["size"], table["errGaussFGUlamek"],
         label="pełny wyb. ulamek")

plt.legend(loc="upper left")
# plt.ylim(-0.01, 0.01)
# plt.xlim(400, 500)
# plt.yscale("log")
plt.show()
