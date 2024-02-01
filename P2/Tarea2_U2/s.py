file = open(".txt", "w")

file.write("{")

for i in range(0, 10000):
    if i == 9999:
        file.write(str(i))
        break
    file.write(str(i) + ", ")

file.write("}")