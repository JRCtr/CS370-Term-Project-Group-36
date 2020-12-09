import java.util.Scanner;
import java.util.Random;

    public class hangman {
        static final int numberOfTries = 7;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int totalWins = 0;
            int totalLosses = 0;
            int totalScore = 0;

            String dictionary[] = {
                                    "reddit", "facebook", "java", "assignment", "game", "hello", "islam", "religion", "internet", "face", "accommodate" ,"achromaticities",
                                    "achiever","adaptive","aerofoil", "affordable", "against", "agoraphobic", "ahchoo","airdrop","albumin","ambient","anesthesiologists",
                                    "anteater","apocalypse","archangel","assemble","athletic","augment", "aviary","axiom","azimuth","babble","backwoods","beanbags","bilaterally",
                                    "boneyard", "brandish","buckskin","bypass","cabbages","characterize","cilantro","clutter","collaborate","crankshaft","curtain","cynic",
                                    "czar","dastardly","debate","dialogue","domesticate","drifter","dumbfound","earthworm","emulator","erratic","exasperate","family","flammable",
                                    "furlong","galvanize","goodness","groundhog","haircut","hickory","homework","hypothetical","implant","inconclusive","italic","jellyfish",
                                    "juggernaut","kaleidoscope","lacquer","macroscopic","maximum","microchip","natural","oblong","oozes","paladin","percussion","questionable",
                                    "radish","ridiculous","sailboat","semiconscious","snafu","tailor","thumb","traitorous","unbox","urbanize","vendor","vigilante","warthog",
                                    "windowsill","xenophobia","yearbook","yoghurt","zealot","zoogeography"
                                  };

            boolean keepPlaying = true;
            while(keepPlaying){ //loop while game is still going
                int rand = random.nextInt(dictionary.length);
                char correctWord[] = dictionary[rand].toCharArray();
                char guessArray[] = new char[correctWord.length];
                for(int i=0; i<guessArray.length; i++){
                    guessArray[i] =  '*';
                }
                int timesTried=0;
                boolean match = false;
                while (match == false && timesTried != numberOfTries){
                    System.out.println("you have " + (numberOfTries - timesTried) + " tries left");
                    printArray(guessArray);
                    System.out.println("Enter a single letter to guess: ");
                    char guess = scanner.nextLine().charAt(0);
                    if(guess == '*'){
                        match = true;
                        keepPlaying = false;
                    }else{
                        boolean hit = false;
                        for(int i=0;i<correctWord.length;i++){
                            if(correctWord[i] == guess){
                                hit =true;
                                guessArray[i] = guess;
                            }
                        }
                        if(hit==false){
                            timesTried++;
                        }
                        if(isGuessed(guessArray)){
                            match = true;
                            totalWins++;
                            System.out.println("You got it!");
                        }
                    }
                }
                if(match == false){
                    totalLosses++;
                    System.out.println("Out of tries!");
                    System.out.println("The word was " + dictionary[rand]);
                }
                int scoreThisRound = score((numberOfTries - timesTried));
                totalScore += scoreThisRound;

                System.out.println("Your score this round was " + scoreThisRound + "! Your total score is "+totalScore);
                System.out.println("You have "+ totalWins+" wins and "+totalLosses+" losses! Play again? (y/n) ");
                String choice = scanner.nextLine();
                if(choice.equals("n")){
                    keepPlaying = false;
                }
            }

            System.out.println("Game ended! Final Score is "+totalScore+". //TODO send scores to leaderboard or something similar");
        }

        public static void printArray(char array[]){
            for(int i=0; i<array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        public static boolean isGuessed(char[] array){ //check if guessed
            boolean result = true;
            for(int i=0; i<array.length; i++){
                if(array[i] == '*'){
                    result = false;
                }
            }
            return result;
        }

        public static int score(int triesLeft){ //caculate running score
            int score=0;
            switch (triesLeft){
                case 7: score = 70;
                break;
                case 6: score = 60;
                break;
                case 5: score = 50;
                break;
                case 4: score = 40;
                break;
                case 3: score = 30;
                break;
                case 2: score = 20;
                break;
                case 1: score = 10;
                break;
                case 0: score = 0;
                break;
            }
            return score;
        }

    }
