const prompt = require("prompt-sync")();

student = prompt(Number("How many students do you have? "));
subject= prompt(Number("How many subjects do they offer? "));
      

let scores = [student][subject];

        const studentTotals = []
        const subjectTotals = []
        const subjectPasses = []
        const subjectFails = []

        for (let index = 0; index < student; index++){
            for (let count = 0; count < subject; count++){

               console.log("Entering score for student " + (index + 1));
               let studentScores = prompt("Enter score for subject " + (count + 1) + ": ");

                

                while (isScores(studentScores)){
                   console.log("Invalid score! Score must be between 0 and 100.");
         	   studentScores = prompt("Enter score again: ");
                    
                }

                scores[index][count] = studentScores;

               console.log("Saving >>>>>>>>>>>>>>>>>>>>>");
               console.log("Saved successfully");
            }

            studentTotals.push(calculateTotal(scores[index]));
        }

        for (let index = 0; index < subject; index++){
            let total = 0;
            let passes = 0;
            let fails = 0;

            for (let count = 0; count < student; count++){
                total += scores[count][index];

                if (scores[count][index] >= 50){
                    passes++;
                } else {
                    fails++;
                }
            }

            subjectTotals.push(total);
            subjectPasses.push(passes);
            subjectFails.push(fails);
        }

       console.log("\nSaved successfully >>>>>>>>>>>>>>>>>>>>>");

        displayScores(scores, student, subject, studentTotals);

        let classTotal = 0;

        for (let total of studentTotals){
            classTotal += total;
        }

        let classAverage = calculateClassAverage(studentTotals);

        let highest = scores[0][0];
        let lowest = scores[0][0];

        let highestStudent = 0;
        let highestSubject = 0;
        let lowestStudent = 0;
        let lowestSubject = 0;

        for (let index = 0; index < student; index++){
            for (let count = 0; count < subject; count++){

                if (scores[index][count] > highest){
                    highest = scores[index][count];
                    highestStudent = index;
                    highestSubject = count;
                }

                if (scores[index][count] < lowest){
                    lowest = scores[index][count];
                    lowestStudent = index;
                    lowestSubject = count;
                }
            }
        }

        let hardestSubject = 0;
        let easiestSubject = 0;

        for (let index = 0; index < subject; index++){

            if (subjectFails[index] > subjectFails[hardestSubject]){
                hardestSubject = index;
            }

            if (subjectPasses[index] > subjectPasses[easiestSubject]){
                easiestSubject = index;
            }
        }

       console.log("\n");

        for (let index = 0; index < subject; index++){

            let highestScore = findHighest(scores, index);
            let lowestScore = findLowest(scores, index);

            let highestPosition = 0;
            let lowestPosition = 0;

            for (let count = 0; count < student; count++){

                if (scores[count][index] == highestScore){
                    highestPosition = count;
                    break;
                }
            }

            for (let count = 0; count < student; count++){

                if (scores[count][index] == lowestScore){
                    lowestPosition = count;
                    break;
                }
            }

           console.log("SUBJECT SUMMARY");
           console.log("Subject " + (index + 1));

           console.log("Highest scoring student is: Student " + (highestPosition + 1) + " scoring " + highestScore);

           console.log("Lowest scoring student is: Student " + (lowestPosition + 1) + " scoring " + lowestScore);

           console.log("Total Score is: " + subjectTotals[index]);

           console.log("Average score is: " + (subjectTotals[index] / student);

           console.log("Number of passes: " + subjectPasses[index]);
           console.log("Number of Fails: " + subjectFails[index]);

        }

       console.log("The hardest subject is Subject " + (hardestSubject + 1) + " with " + subjectFails.at(hardestSubject) + " failures");

       console.log("The easiest subject is Subject " + (easiestSubject + 1) + " with " + subjectPasses.at(easiestSubject) + " passes");

       console.log("The overall Highest score is scored by Student " + (highestStudent + 1) + " in subject " + (highestSubject + 1) + " scoring " + highest);

       console.log("The overall Lowest score is scored by Student " + (lowestStudent + 1) + " in subject " + (lowestSubject + 1) + " scoring " + lowest);

       console.log("\nCLASS SUMMARY");

       console.log("Class total score is: " + classTotal);

       console.log("Class Average score is: " + classAverage);
    }

function isScores(scores){
        if (scores < 0 || scores > 100) return true;
        return false;
    }

function calculateTotal(scores){
        let total = 0;

        for (let score : scores){
            total += score;
        }

        return total;
    }

function calculateClassAverage(scores){
        let total = 0;

        for (let score of scores){
            total += score;
        }

        return  total / scores.length;
    }

function findHighest(scores, subject){
        let highest = scores[0][subject];

        for (let index = 0; index < scores.length; index++){
            if (scores[index][subject] > highest){
                highest = scores[index][subject];
            }
        }

        return highest;
    }

function findLowest(scores, subject){
        let lowest = scores[0][subject];

        for (let index = 0; index < scores.length; index++){
            if (scores[index][subject] < lowest) {
                lowest = scores[index][subject];
            }
        }

        return lowest;
    }

function displayScores(scores, student, subject, totals){

        console.log("\nSTUDENT SCORES");

        for (let index = 0; index < student; index++){

            let average = totals[index] / subject;

          console.log("\nStudent " + (index + 1));

            for (let count = 0; count < subject; count++){
                console.log("Subject " + (count + 1) + ": " + scores[index][count]);
            }

            console.log("Total: " + totals[index]);
            console.log("Average: " + average);
        }
    }
}
