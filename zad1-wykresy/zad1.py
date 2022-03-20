from cProfile import label
import pandas as pd
import matplotlib.pyplot as plt

table = pd.read_csv("test.csv")
print(table.head())
print(table.columns)

plt.plot(table["x"], table["sinArctg"], label="sinArctg")
plt.plot(table["x"], table["sinArctg Backwards"],
         label="sinArctg Backwards")
plt.plot(table["x"], table["sinArctg From Prev"],
         label="sinArctg From Prev")
plt.plot(table["x"], table["sinArctg From Prev Backwards"],
         label="sinArctg From Prev Backwards")
plt.legend(loc="upper left")
# plt.ylim(-0.01, 0.01)
# plt.xlim(-0.5, 0.5)
plt.show()

# 0 - x
# 1 - sin(x) * arctg(x)
# 2 - od końca
# 3 - z poprzedniego elementu
# 4 - z poprzedniego elementu od końca
