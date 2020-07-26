# python program by Eric Adamian
# newton's interpolation (divided differences): evaluation based on user input

import re
import sys

# user interface/input result
print("****************************************************************************")
print("NEWTON'S INTERPOLATION")
print("")
print("- If you would like to exit the program, enter 'Q' or 'q'.")

while True:
    userInput = input("Please provide a value (such as 4 or 5) to be used to evaluate the polynomial : ")

    # allows user to exit the program (while requiring valid int)
    try:
        if (userInput == 'Q' or userInput == 'q'):
            print("Exiting the program.")
            sys.exit()
        else:
            value = int(userInput)
    except ValueError:
        print("Please enter a valid integer. Exiting the program.")
        sys.exit()

    # pseudocode translation
    def Coeff(n, xs, ys, cs):
        for i in range(n):
            cs[i] = ys[i]
        for j in range(1, n):
            for i in range(n - 1, j - 1, -1):
                cs[i] = (cs[i] - cs[i - 1]) / (xs[i] - xs[i - j])

    def EvalNewton(n, xs, cs, z):
        result = cs[n - 1]
        for i in range(n - 2, -1, -1):
            result = result * (z - xs[i]) + cs[i]
        return result


    # open/read our input file with data points
    dataPoints = open("datapoints.txt").read()

    # parsing pattern with regular expression
    pattern = re.compile('-?[0-9]+.[0-9]+')

    # searching for total number of data points
    # through a given array of data points
    dataPoints_array = []
    for x in range(len(pattern.findall(dataPoints))):
        dataPoints_array.append(float(pattern.findall(dataPoints)[x]))

    # searching x array's (and y array's) data points
    # appending values to data point array
    x_array = []
    for x in range(int(len(dataPoints_array) / 2)):
        x_array.append(dataPoints_array[x])

    y_array = []
    for y in range(x + 1, len(dataPoints_array)):
        y_array.append(dataPoints_array[y])

    # calling our values, printing our evaluation value
    Coeff(len(x_array), x_array, y_array, dataPoints_array)
    print("The evaluation value is: ",  end = " ")
    print(EvalNewton(len(x_array), x_array, dataPoints_array, value))