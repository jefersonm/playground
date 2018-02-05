a = list()
a.append(1)
a.append(2)

# Anonymous function
print(lambda x, y: x + y)

print(reduce(lambda x, y: x + y, a))

print(map(lambda x: x + 1, a))

print(filter(lambda x: x > 1, a))
