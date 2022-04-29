from cProfile import label
import pandas as pd
import matplotlib.pyplot as plt

# table = pd.read_csv("time_my_gauss.csv")
table = pd.read_csv("err_my_gauss.csv")
print(table.head())
print(table.columns)


# plt.plot(table["size"], table["timeGaussGFloat"], label="bez wyb. float")
# plt.plot(table["size"], table["timeGaussPGFloat"],
#          label="częściowy wyb. float")
# plt.plot(table["size"], table["timeGaussFGFloat"], label="pełny wyb. float")

# plt.plot(table["size"], table["timeGaussGDouble"], label="bez wyb. double")
# plt.plot(table["size"], table["timeGaussPGDouble"],
#          label="częściowy wyb. double")
# plt.plot(table["size"], table["timeGaussFGDouble"], label="pełny wyb. double")


plt.plot(table["size"], table["errGaussGFloat"], label="bez wyb. float")
plt.plot(table["size"], table["errGaussPGFloat"],
         label="częściowy wyb. float")
plt.plot(table["size"], table["errGaussFGFloat"], label="pełny wyb. float")

# plt.plot(table["size"], table["errGaussGDouble"], label="bez wyb. double")
# plt.plot(table["size"], table["errGaussPGDouble"],
#          label="częściowy wyb. double")
# plt.plot(table["size"], table["errGaussFGDouble"],
#          label="pełny wyb. double")

plt.legend(loc="upper left")
# plt.ylim(-0.01, 0.01)
# plt.xlim(400, 500)
plt.yscale("log")
plt.show()
