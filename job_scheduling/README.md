# Job Scheduling Algorithms

- Job scheduling algorithms through an operating system.
- Uses 5, 10, and 15 jobs; evaluates start and end time with each job completion
- Evaluates first-come-first-serve (FCFS), shortest-job-first (SJF), and Round Robin (RR- with time slices 2 and 5)

# Input files

- 5jobs.txt, 10jobs.txt, and 15jobs.txt
- Files formatted such that (Job title, time, job title, time, etc...)

# How to run (command line):

javac Main.java

java Main Xjobs.txt (such that X = 5, 10, or 15)

# Output

- If file is empty, error message
- Otherwise, display start time, end time, and description of job description for each job scheduling algorithm
- Calculates and displays turnaround time for each algorithm