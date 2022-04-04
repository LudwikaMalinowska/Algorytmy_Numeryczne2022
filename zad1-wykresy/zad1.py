from cProfile import label
import pandas as pd
import matplotlib.pyplot as plt

table = pd.read_csv("../Zadanie1/test.csv")
print(table.head())
print(table.columns)

# plt.plot(table["x"], table["sinArctg From Prev Backwards"],
#          label="sinArctg From Prev Backwards")
# plt.plot(table["x"], table["sinArctg Backwards"],
#          label="sin(x) * arctg(x) od końca")


# plt.plot(table["x"], table["sinArctg From Prev"],
#          label="sinArctg From Prev")

plt.plot(table["x"], table["sinArctg"], label="sin(x) * arctg(x)")


plt.legend(loc="upper left")
# plt.ylim(-0.01, 0.01)
plt.xlim(0, 1)
plt.yscale("log")
plt.show()

# 0 - x
# 1 - sin(x) * arctg(x)
# 2 - od końca
# 3 - z poprzedniego elementu
# 4 - z poprzedniego elementu od końca
