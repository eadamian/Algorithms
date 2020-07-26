# Gaussian Elimination

- Algorithm used for solving a system of linear equations
- Takes in a .lin file containing a given matrix
- Executable as naive gaussian elimination, or with scaled partial pivoting

# How to run (command line):
- For naive gaussian elimination:
	1) javac Gaussian.java
	2) java Gaussian sys1.lin
	3) cat sys1.sol

- For scaled partial pivoting:	
	1) javac Gaussian.java
 	2) java Gaussian --spp sys1.lin	
	3) cat sys1.sol								


# Output

- Outputs .sol containing row reduced operations
- If incorrecly inputted, an error message will appear
