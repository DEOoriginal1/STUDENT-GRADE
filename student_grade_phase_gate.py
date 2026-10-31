

classes = int(input("What class are you? "))
students = input("How many students do you have? ")
subjects = int(input("How many subjects are you offering? "))



print(f"""
===============================================================================================
	STUDENT		{subjects}	{subjects}	{subjects}	TOTAL	AVG	POS
===============================================================================================




""")

def subjects_of_students(subjects):
	for index in range (len(subjects)):
		subject_name = print(f"{index + 1}")
		subjects[subject_name] = {}
	return subjects
		
		
		
		
def scores_of_students(scores):
	for index in range (len(classes)):
		class_name = print("Enter Class name: ")
		scores[class_name] = {}
	return scores
	

def class_of_students(classes):
	for index in range (len(classes)):
		student_class = print("")
		classes[student_class] = {}
	return classes	


def total_of_scores(scores):

	pass
	
	
	
def average_of_the_total_score(scores):

	total_of_scores(scores)
	pass
	
	
def position_in_class():

	pass


	
